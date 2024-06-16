package com.example.marvel_app_project.notification

import android.util.Log
import com.example.marvel_app_project.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class HeroesNotificationService: FirebaseMessagingService(){

    private lateinit var notification: HeroesNotification
    override fun onCreate() {
        super.onCreate()
        notification = HeroesNotification(this)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        if(message.notification == null || message.data.isEmpty()){
            Log.d(getString(R.string.fcm_tag), getString(R.string.fcm_error_message))
        }

        notification.showNotification(
            message.notification?.title,
            message.notification?.body,
            message.data["heroId"]
        )

    }

    override fun onNewToken(token: String) {
        Log.d(getString(R.string.fcm_token_tag), getString(R.string.fcm_token_update) + token)


        //TODO(Make send registration to a server with current token function)
    }
}