package com.homeaway.seatgeek.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.homeaway.domain.dto.Event
import com.homeaway.seatgeek.R
import com.homeaway.seatgeek.base.BaseActivity
import com.homeaway.seatgeek.injection.MainComponent
import com.homeaway.seatgeek.presentation.details.injection.DaggerDetailsComponent
import javax.inject.Inject

/**
 * Created by Omar on 11/2/17.
 */
class DetailsActivity : BaseActivity(), DetailsContract.View {

  @Inject
  lateinit var detailsPresenter: DetailsPresenter

  override val layoutId: Int
    get() = R.layout.activity_details


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    supportActionBar?.subtitle
  }

  override fun injectDependencies(mainComponent: MainComponent?) {
    DaggerDetailsComponent.builder()
        .mainComponent(mainComponent)
        .build()
        .inject(this)
  }

  override fun showFavorite(boolean: Boolean) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  companion object {
    val EXTRA_EVENT_KEY = "EXTRA_EVENT_KEY"

    fun newIntent(context: Context, event: Event) {
      val intent = Intent(context, DetailsActivity::class.java)
//      intent.putExtra(EXTRA_EVENT_KEY, event)
      context.startActivity(intent)
    }
  }
}