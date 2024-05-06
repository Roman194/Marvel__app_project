package com.example.marvel_app_project.network

import com.example.marvel_app_project.BuildConfig
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class ParseConstants{
    companion object{
        val ts = Timestamp(System.currentTimeMillis()).time.toString()
        const val limit = "10"

        const val API_KEY = BuildConfig.API_KEY
        const val PRIVATE_API_KEY = BuildConfig.PRIVATE_API_KEY

        fun hash():String{
            val inputHashString = "$ts$PRIVATE_API_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(inputHashString.toByteArray())).toString(16).padStart(32,'0')
        }
    }
}

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

val loggingInterceptor = HttpLoggingInterceptor()
    .apply {
        setLevel(HttpLoggingInterceptor.Level.BASIC)
    }

//val client = OkHttpClient.Builder()
//    .addNetworkInterceptor(loggingInterceptor)
//    .addNetworkInterceptor(authInterceptor)
//    .build()