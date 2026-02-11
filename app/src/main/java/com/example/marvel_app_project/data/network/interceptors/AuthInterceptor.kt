package com.example.marvel_app_project.data.network.interceptors

import com.example.marvel_app_project.data.network.ParseConstants
import com.example.marvel_app_project.data.network.interceptors.AuthInterceptor.Companion.authInterceptor
import okhttp3.Interceptor

/**
 * [AuthInterceptor] is a class that initialize OkHttp lib interceptor which handle all authorization
 * parameters for Marvel API.
 * It uses parameter [authInterceptor] inside companion object of this class
 *
 * For more info about interceptors check [this tutorial] (https://www.geeksforgeeks.org/android/okhttp-interceptor-in-android/?ysclid=mfgjvbvm6t49413577)
 * @author Zyuzin Roman
 */

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