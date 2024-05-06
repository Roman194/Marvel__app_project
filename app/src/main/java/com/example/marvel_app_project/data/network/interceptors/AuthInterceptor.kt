package com.example.marvel_app_project.data.network.interceptors

import com.example.marvel_app_project.data.network.ParseConstants
import okhttp3.Interceptor

class AuthInterceptor {
    companion object{
        val authInterceptor = Interceptor{chain ->
            val originalRequest = chain.request()

            val newHttpUrl = originalRequest.url.newBuilder()
                .addQueryParameter("apikey", ParseConstants.API_KEY)
                .addQueryParameter("ts", ParseConstants.ts)
                .addQueryParameter("hash", ParseConstants.hash())
                .addQueryParameter("limit", ParseConstants.limit)
                .build()

            val newRequest = originalRequest.newBuilder()
                .url(newHttpUrl)
                .build()

            chain.proceed(newRequest)
        }
    }
}