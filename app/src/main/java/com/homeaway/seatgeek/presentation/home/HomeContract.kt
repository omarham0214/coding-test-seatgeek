package com.homeaway.seatgeek.presentation.home

import com.homeaway.domain.dto.Event

/**
 * Created by Omar on 11/1/17.
 */

interface HomeContract {
  interface View {
    fun updateList(list: List<Event>)
    fun errorHappened(error: String)
    fun showProgressBar(indeterminate: Boolean, progress: Int)
    fun hideProgressBar()
  }

  interface Presenter {
    fun loadEvents(searchTerm: String?)
    fun start(view: View)
    fun stop()
  }
}
