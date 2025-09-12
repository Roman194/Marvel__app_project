package com.example.marvel_app_project.data.network.interceptors

import com.example.marvel_app_project.data.network.interceptors.LogInterceptor.Companion.loggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor

/**
 * [LogInterceptor] is a class that initialize OkHttp lib interceptor which logs all request and
 * responses to API in logcat.
 * It uses parameter [loggingInterceptor] inside companion object of this class
 *
 * For more info about interceptors check [this tutorial] (https://www.geeksforgeeks.org/android/okhttp-interceptor-in-android/?ysclid=mfgjvbvm6t49413577)
 * @author Zyuzin Roman
 */
class LogInterceptor {

    companion object {
        val loggingInterceptor = HttpLoggingInterceptor()
            .apply {
                setLevel(HttpLoggingInterceptor.Level.BASIC)
            }
    }
}