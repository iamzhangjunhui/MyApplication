package com.loyo.myapplication.retrofit_use.net

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitFactory {
    var retrofit: Retrofit
    private const val baseUrl = "https://www.wanandroid.com"
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(initCommonIntercept())
        .readTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS).connectTimeout(15, TimeUnit.SECONDS)
        .callTimeout(15, TimeUnit.SECONDS).build()

    init {
        retrofit =
            Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).client(okHttpClient)
                .build()
    }

    private fun initCommonIntercept(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("charset", "UTF-8").build()
            chain.proceed(request)
        }
    }
}