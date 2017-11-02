package com.homeaway.seatgeek.presentation.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import com.homeaway.domain.dto.Event
import com.homeaway.seatgeek.R
import com.homeaway.seatgeek.base.BaseActivity
import com.homeaway.seatgeek.injection.MainComponent
import com.homeaway.seatgeek.presentation.details.injection.DaggerDetailsComponent
import com.homeaway.seatgeek.utility.ExtensionHelper.firstImage
import com.homeaway.seatgeek.utility.ExtensionHelper.prettyDate
import kotlinx.android.synthetic.main.activity_details.*
import javax.inject.Inject

/**
 * Created by Omar on 11/2/17.
 */
class DetailsActivity : BaseActivity(), DetailsContract.View {

  @Inject
  lateinit var detailsPresenter: DetailsPresenter

  override val layoutId: Int
    get() = R.layout.activity_details

  var event: Event? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // TODO 11/2: Implement @PaperParcel or @Parcelize
    event = intent.getSerializableExtra(EXTRA_EVENT_KEY) as Event?

    initViews()
  }

  override fun onStart() {
    super.onStart()

    detailsPresenter.start(this)
  }

  override fun onStop() {
    super.onStop()

    detailsPresenter.stop()
  }

  override fun onResume() {
    super.onResume()

    detailsPresenter.checkFavorite(event, false)
  }

  override fun injectDependencies(mainComponent: MainComponent?) {
    DaggerDetailsComponent.builder()
        .mainComponent(mainComponent)
        .build()
        .inject(this)
  }

  override fun showFavorite(isFavorite: Boolean, favoriteChanged: Boolean) {
    val colorTitle: Int
    val message: Int
    if (isFavorite) {
      colorTitle = R.color.colorAccent
      message = R.string.added_to_favorites
    } else {
      colorTitle = R.color.colorPrimary
      message = R.string.removed_from_favorites
    }

    val color = ContextCompat.getColor(this, colorTitle)
    details_title.setTextColor(color)

    if (favoriteChanged) {
      Snackbar.make(details_container, message, Snackbar.LENGTH_SHORT)
          .setAction(getString(R.string.undo), { detailsPresenter.toggleFavorite(event) })
          .show()
    }
  }

  private fun initViews() {
    supportActionBar?.subtitle = event?.title

    details_image.setImageURI(event?.firstImage())

    details_title.text = event?.title
    details_subtitle.text = event?.venue?.city
    details_date.text = event?.datetimeLocal?.prettyDate()
    details_venue.text = event?.venue?.name

    details_favorite.setOnClickListener { detailsPresenter.toggleFavorite(event) }
  }

  companion object {
    val EXTRA_EVENT_KEY = "EXTRA_EVENT_KEY"

    fun newIntent(context: Context, event: Event) {
      val intent = Intent(context, DetailsActivity::class.java)
      intent.putExtra(EXTRA_EVENT_KEY, event)
      context.startActivity(intent)
    }
  }
}