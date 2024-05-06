package com.example.marvel_app_project.data.network

import com.example.marvel_app_project.BuildConfig
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
