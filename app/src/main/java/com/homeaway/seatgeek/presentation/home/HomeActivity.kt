package com.homeaway.seatgeek.presentation.home

import android.view.Menu
import android.view.View
import android.widget.Toast
import com.homeaway.domain.dto.Event
import com.homeaway.seatgeek.R
import com.homeaway.seatgeek.base.BaseActivity
import com.homeaway.seatgeek.injection.MainComponent
import com.homeaway.seatgeek.presentation.home.injection.DaggerHomeComponent
import com.homeaway.seatgeek.utility.KeyboardHelper
import com.homeaway.seatgeek.utility.RxSearchView
import com.miguelcatalan.materialsearchview.MaterialSearchView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Predicate
import kotlinx.android.synthetic.main.activity_home.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class HomeActivity : BaseActivity(), HomeContract.View {

  @Inject
  lateinit var homePresenter: HomePresenter

  override val layoutId: Int
    get() = R.layout.activity_home

  private var compositeDisposable: CompositeDisposable? = null

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
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.home_menu, menu)

    val item = menu?.findItem(R.id.action_search)
    home_search.setMenuItem(item)
    return true
  }

  override fun injectDependencies(mainComponent: MainComponent?) {
    DaggerHomeComponent.builder()
        .mainComponent(mainComponent)
        .build()
        .inject(this)
  }

  override fun updateList(list: List<Event>) {
    list.forEach({ println(it) })
  }

  override fun errorHappened(error: String) {
    Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
  }

  override fun showProgressBar(indeterminate: Boolean, progress: Int) {
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
        .debounce(300, TimeUnit.MILLISECONDS)
        .filter({ it.length > 2 })
        .distinctUntilChanged()
        .subscribe({ homePresenter.loadEvents(it) })

    compositeDisposable?.add(disposable)
  }

}
