package com.homeaway.seatgeek.utility

import android.view.View
import com.homeaway.domain.dto.Event
import com.homeaway.domain.dto.Performer
import com.homeaway.seatgeek.presentation.home.adapters.EventAdapter
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Omar on 11/2/17.
 */
object ExtensionHelper {
  fun View.viewHolder(): EventAdapter.ViewHolder = EventAdapter.ViewHolder(this)

  fun <E> MutableList<E>.refresh(list: List<E>) {
    this.clear()
    this.addAll(list)
  }

  fun Event.firstImage(): String? {
    val placeholder = "http://www.rapidvaluesolutions.com/wp-content/uploads/2015/02/Google-Material-Design.png"

    this.performers
        .filter({ performer -> performer.image != null })
        .forEach({ performer -> return performer.image })

    return placeholder
  }

  fun String.prettyDate(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
    val outputFormat = SimpleDateFormat("EEE, d MMM yyyy, hh:mm aaa", Locale.US)
    val date = inputFormat.parse(this)
    return outputFormat.format(date)
  }
}