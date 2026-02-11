package com.example.marvel_app_project.notification

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * [HeroesNotificationService] class is used to manage requests on showing [HeroesNotification] from
 * the [FirebaseMessagingService]
 *
 * Класс [HeroesNotificationService] используется для управления запросами на вывод [HeroesNotification] из
 * [FirebaseMessagingService]
 *
 * @see HeroesNotification
 * @author Zyuzin Roman
 */

class HeroesNotificationService: FirebaseMessagingService(){

    private lateinit var notification: HeroesNotification

    /**
     * [onCreate] fun creates [HeroesNotification] instance
     */
    override fun onCreate() {
        super.onCreate()
        notification = HeroesNotification(this)
    }

    /**
     * [onMessageReceived] fun call showNotification method from the [HeroesNotification]
     */
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