package com.homeaway.seatgeek.presentation.home

import android.view.View
import android.widget.Toast
import com.homeaway.domain.EventsProvider
import com.homeaway.domain.dto.Event
import com.homeaway.seatgeek.R
import com.homeaway.seatgeek.base.BaseActivity
import com.homeaway.seatgeek.injection.MainComponent
import com.homeaway.seatgeek.presentation.home.injection.DaggerHomeComponent
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), HomeContract.View {

  @Inject
  lateinit var homePresenter: HomePresenter

  override val layoutId: Int
    get() = R.layout.activity_home

  override fun onStart() {
    super.onStart()

    homePresenter.start(this)
  }

  override fun onStop() {
    super.onStop()

    homePresenter.stop()
  }

  override fun onResume() {
    super.onResume()

    homePresenter.loadEvents("Texas+Rangers")
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

}
