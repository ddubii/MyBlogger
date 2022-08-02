package com.hb.imageup

import okhttp3.OkHttpClient
import retrofit2.Retrofit

import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitSetting {
    val API_BASE_URL = "http://192.168.219.103:8080/"
    val httpClient = OkHttpClient.Builder()

    val baseBuilder = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(ScalarsConverterFactory.create())

    fun <S> createBaseService(serviceClass: Class<S>?): S {
        val retrofit = baseBuilder.client(httpClient.build()).build()
        return retrofit.create(serviceClass)
    }
}
