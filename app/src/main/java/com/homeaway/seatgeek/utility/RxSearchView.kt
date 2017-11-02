package com.homeaway.seatgeek.utility

import com.miguelcatalan.materialsearchview.MaterialSearchView
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by Omar on 11/2/17.
 *
 * RxBinding-like helper to get Observables from text changes on @MaterialSearchView
 */


object RxSearchView {
  fun textChanges(searchView: MaterialSearchView): Observable<String> {
    val subject: BehaviorSubject<String> = BehaviorSubject.create();

    searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
      override fun onQueryTextChange(newText: String): Boolean {
        subject.onNext(newText)
        return true
      }

      override fun onQueryTextSubmit(query: String?): Boolean {
        return true;
      }
    })

    return subject
  }
}