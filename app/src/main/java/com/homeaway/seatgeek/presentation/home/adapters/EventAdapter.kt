package com.homeaway.seatgeek.presentation.home.adapters

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.homeaway.domain.dto.Event
import com.homeaway.seatgeek.R

import com.homeaway.seatgeek.utility.ExtensionHelper.viewHolder
import com.homeaway.seatgeek.utility.ExtensionHelper.firstImage
import com.homeaway.seatgeek.utility.ExtensionHelper.prettyDate
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.recycler_event.view.*

/**
 * Created by Omar on 11/2/17.
 */
class EventAdapter(private val events: List<Event>, private val callback: (Event) -> Unit) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
    return LayoutInflater.from(parent?.context)
        .inflate(R.layout.recycler_event, parent, false)
        .viewHolder()
  }

  override fun getItemCount() = events.size

  override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
    holder?.bind(events[position], callback)
  }

  class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    fun bind(event: Event, callback: (Event) -> Unit) = with(itemView) {
      setOnClickListener { callback(event) }

      recycler_image.setImageURI(event.firstImage())
      recycler_event.text = event.title
      recycler_favorite.visibility = if (event.isFavorite) View.VISIBLE else View.GONE
      recycler_location.text = event.venue.city
      recycler_date.text = event.datetimeLocal.prettyDate()
    }
  }
}

