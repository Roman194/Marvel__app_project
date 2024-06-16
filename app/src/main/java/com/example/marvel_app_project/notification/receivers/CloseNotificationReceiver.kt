package com.example.marvel_app_project.notification.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.marvel_app_project.notification.HeroesNotification

class CloseNotificationReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val heroesNotification = HeroesNotification(context)

        heroesNotification.closeNotification(1)
    }
}