package com.example.marvel_app_project.data.network

import com.example.marvel_app_project.BuildConfig
import com.example.marvel_app_project.data.network.ParseConstants.Companion.API_KEY
import com.example.marvel_app_project.data.network.ParseConstants.Companion.PRIVATE_API_KEY
import com.example.marvel_app_project.data.network.ParseConstants.Companion.hash
import com.example.marvel_app_project.data.network.ParseConstants.Companion.limit
import com.example.marvel_app_project.data.network.ParseConstants.Companion.ts
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

/**
 * This class provides all QueryParameters info for [AuthInterceptor] inside it companion object.
 * It has such parameters as current timestamp [ts], response objects limit [limit],
 * and the pair of API_KEYS from local.properties file (not commited due to confidential info) [API_KEY] [PRIVATE_API_KEY].
 * [hash] fun is used to code ts + api keys info and send it to [AuthInterceptor]
 */
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
