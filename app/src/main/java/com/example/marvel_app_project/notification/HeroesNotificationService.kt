package com.example.marvel_app_project.notification

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class HeroesNotificationService: FirebaseMessagingService(){

    override fun onNewToken(token: String) {
        Log.d("FCM token", "Refreshed token: $token")


        //sendRegistrationToServer(token)
    }
}