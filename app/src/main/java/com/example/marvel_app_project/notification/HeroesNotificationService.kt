package com.example.marvel_app_project.notification

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

        notification.showNotification(
            message.notification?.title,
            message.notification?.body,
            message.data["heroId"]
        )

    }

    override fun onNewToken(token: String) {
        //TODO(Make send registration to a server with current token function)
    }
}