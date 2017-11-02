package com.homeaway.seatgeek.presentation.details

import android.content.Context
import android.content.Intent
import com.homeaway.domain.dto.Event
import com.homeaway.seatgeek.base.BaseActivity
import com.homeaway.seatgeek.injection.MainComponent

/**
 * Created by Omar on 11/2/17.
 */
class DetailsActivity : BaseActivity() {
  override val layoutId: Int
    get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

  override fun injectDependencies(mainComponent: MainComponent?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  companion object {
    fun newIntent(context: Context, event: Event) {
      val intent = Intent(context, DetailsActivity::class.java)
      context.startActivity(intent)
    }
  }
}