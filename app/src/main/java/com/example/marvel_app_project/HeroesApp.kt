package com.example.marvel_app_project

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.example.marvel_app_project.notification.HeroesNotification
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HeroesApp: Application() {

    override fun onCreate() {
        super.onCreate()

        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                HeroesNotification.HEROES_CHANNEL_ID,
                getString(R.string.hero_notification_name),
                NotificationManager.IMPORTANCE_DEFAULT
            )

            channel.description = getString(R.string.hero_notification_description)

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(channel)

        }
    }
}