package com.example.marvel_app_project.notification.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.marvel_app_project.notification.HeroesNotification

/**
 * [CloseNotificationReceiver] is a [BroadcastReceiver] that handles command to close notification
 * from the [FCM console](https://firebase.google.com/docs/cloud-messaging?hl=ru)
 *
 * [CloseNotificationReceiver] это [BroadcastReceiver], который хранит команды для закрытия нотификаций
 * при использовании FCM console (Firebase service)
 *
 * @see HeroesNotification
 * @author Zyuzin Roman
 */
class CloseNotificationReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val heroesNotification = HeroesNotification(context)

        heroesNotification.closeNotification(1)
    }
}