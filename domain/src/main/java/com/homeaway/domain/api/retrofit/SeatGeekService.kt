package com.homeaway.domain.api.retrofit

import com.homeaway.domain.dto.SeatGeekResponse
import io.reactivex.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Omar on 11/1/17.
 */

interface SeatGeekService {

  @GET("/2/events?client_id")
  fun retrieveEvents(@Query("q") query: String): Single<SeatGeekResponse>

  object Factory {
    private val BASE_URL = "https://api.seatgeek.com/"
    private val CLIENT_ID = "OTQ4MTk5N3wxNTA5NTc2ODEzLjg3" //TODO: Hide with NDK

    fun createApiInterceptor(): Interceptor {
      return Interceptor { chain ->
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url()
        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("client_id", CLIENT_ID)
            .build()
        val newRequest = originalRequest.newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
      }
    }

    fun createOkHttp(interceptor: Interceptor): OkHttpClient {
      return OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build()
    }

    fun createRetrofit(okHttpClient: OkHttpClient): Retrofit {
      return Retrofit.Builder()
          .baseUrl(BASE_URL)
          .client(okHttpClient)
          .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
          .addConverterFactory(MoshiConverterFactory.create())
          .build();
    }

    fun createApiService(retrofit: Retrofit): SeatGeekService
        = retrofit.create(SeatGeekService::class.java)
  }
}