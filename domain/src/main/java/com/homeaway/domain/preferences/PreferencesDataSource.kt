package com.homeaway.domain.preferences

import android.content.SharedPreferences
import com.f2prateek.rx.preferences2.RxSharedPreferences
import com.homeaway.domain.DataSource
import com.homeaway.domain.dto.Event
import io.reactivex.Single
import javax.inject.Inject


/**
 * Created by Omar on 11/1/17.
 */

class PreferencesDataSource @Inject constructor(private val rxSharedPreferences: RxSharedPreferences) {
  fun toggleFavorite(event: Event) {
    val id = event.id.toString()
    val preference = rxSharedPreferences.getBoolean(id)
    when {
      isFavorite(event) -> preference.delete()
      else -> preference.set(true)
    }
  }

  fun isFavorite(event: Event): Boolean {
    val id = event.id.toString()
    return rxSharedPreferences.getBoolean(id).isSet
  }

}