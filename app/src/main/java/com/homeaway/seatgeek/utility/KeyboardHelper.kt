package com.homeaway.seatgeek.utility

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager


/**
 * Created by Omar on 11/2/17.
 */
object KeyboardHelper {
  fun hideKeyboard(appCompatActivity: AppCompatActivity) {
    val view = appCompatActivity.currentFocus
    if (view != null) {
      val imm = appCompatActivity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
      imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
  }
}