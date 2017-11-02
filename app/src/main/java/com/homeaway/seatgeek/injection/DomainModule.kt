package com.homeaway.seatgeek.injection

import android.content.Context
import android.preference.PreferenceManager
import com.f2prateek.rx.preferences2.RxSharedPreferences
import com.homeaway.domain.EventsProvider
import com.homeaway.domain.api.ApiDataSource
import com.homeaway.domain.api.retrofit.SeatGeekService
import com.homeaway.domain.database.DatabaseDataSource
import com.homeaway.domain.preferences.PreferencesDataSource
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Omar on 11/1/17.
 */

@Module
class DomainModule(private val context: Context) {

  @Singleton
  @Provides
  fun createRxSharedPreferences(): RxSharedPreferences {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    return RxSharedPreferences.create(sharedPreferences)
  }

  @Singleton
  @Provides
  fun createInterceptor(): Interceptor {
    return SeatGeekService.Factory.createApiInterceptor()
  }

  @Singleton
  @Provides
  fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
    return SeatGeekService.Factory.createOkHttp(interceptor)
  }

  @Singleton
  @Provides
  fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return SeatGeekService.Factory.createRetrofit(okHttpClient)
  }

  @Singleton
  @Provides
  fun createSeatGeekService(retrofit: Retrofit): SeatGeekService {
    return SeatGeekService.Factory.createApiService(retrofit)
  }
}
