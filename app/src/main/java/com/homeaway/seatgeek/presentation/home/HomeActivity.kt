package com.homeaway.seatgeek.presentation.home

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.View
import android.widget.Toast
import com.homeaway.domain.dto.Event
import com.homeaway.seatgeek.R
import com.homeaway.seatgeek.base.BaseActivity
import com.homeaway.seatgeek.injection.MainComponent
import com.homeaway.seatgeek.presentation.details.DetailsActivity
import com.homeaway.seatgeek.presentation.home.adapters.EventAdapter
import com.homeaway.seatgeek.presentation.home.injection.DaggerHomeComponent
import com.homeaway.seatgeek.utility.KeyboardHelper
import com.homeaway.seatgeek.utility.RxSearchView
import com.miguelcatalan.materialsearchview.MaterialSearchView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_home.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

import com.homeaway.seatgeek.utility.ExtensionHelper.refresh


class HomeActivity : BaseActivity(), HomeContract.View {

  private val SEARCH_TERM_KEY = "SEARCH_TERM_KEY"

  @Inject
  lateinit var homePresenter: HomePresenter

  override val layoutId: Int
    get() = R.layout.activity_home

  private var compositeDisposable: CompositeDisposable? = null

  private val eventList = mutableListOf<Event>()
  private val eventAdapter = EventAdapter(eventList, { DetailsActivity.newIntent(this, it) })

  private var searchTerm: String? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    home_recycler.adapter = eventAdapter
    home_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
  }

  override fun onStart() {
    super.onStart()

    homePresenter.start(this)
    compositeDisposable = CompositeDisposable()
  }

  override fun onStop() {
    super.onStop()

    homePresenter.stop()
    compositeDisposable?.dispose()
  }

  override fun onResume() {
    super.onResume()

    setupSearchView()
    homePresenter.loadEvents(searchTerm)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.home_menu, menu)

    val item = menu?.findItem(R.id.action_search)
    home_search.setMenuItem(item)
    return true
  }

  override fun onSaveInstanceState(outState: Bundle?) {
    super.onSaveInstanceState(outState)
    outState?.putString(SEARCH_TERM_KEY, searchTerm)
  }

  override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
    super.onRestoreInstanceState(savedInstanceState)
    searchTerm = savedInstanceState?.getString(SEARCH_TERM_KEY)
  }

  override fun injectDependencies(mainComponent: MainComponent?) {
    DaggerHomeComponent.builder()
        .mainComponent(mainComponent)
        .build()
        .inject(this)
  }

  override fun updateList(list: List<Event>) {
    eventList.refresh(list)
    eventAdapter.notifyDataSetChanged()
  }

  override fun errorHappened(error: String) {
    Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
  }

  override fun showProgressBar(indeterminate: Boolean, progress: Int) {
    home_progress.isIndeterminate = indeterminate
    home_progress.progress = progress
    home_progress.visibility = View.VISIBLE
  }

  override fun hideProgressBar() {
    home_progress.visibility = View.INVISIBLE
  }

  private fun setupSearchView() {
    home_search.setOnSearchViewListener(object : MaterialSearchView.SearchViewListener {
      override fun onSearchViewClosed() {
        KeyboardHelper.hideKeyboard(this@HomeActivity)
      }

      override fun onSearchViewShown() {
        KeyboardHelper.hideKeyboard(this@HomeActivity)
      }
    })

    val disposable = RxSearchView.textChanges(home_search)
        .debounce(200, TimeUnit.MILLISECONDS)
        .filter({ it.length > 1 })
        .distinctUntilChanged()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({
          searchTerm = it
          homePresenter.loadEvents(it)
        })

    compositeDisposable?.add(disposable)
  }

}