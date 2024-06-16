package com.example.marvel_app_project.notification.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.marvel_app_project.R
import com.example.marvel_app_project.assets.SampleData
import com.example.marvel_app_project.notification.HeroesNotification

class UpdateNotificationReceiver: BroadcastReceiver() {

    //TODO(Solve problems with Hilt injection in a BroadcastReceiver to implement "I'm lucky button functionality with DB")
    override fun onReceive(context: Context, intent: Intent?) {

        val heroesNotification = HeroesNotification(context)

        val randomValue = (0..6).random()
        val currentHero = SampleData.heroEntitySamples[randomValue]
        val heroDescription =
            if(currentHero.serverId.toInt() % 2 == 0)
                currentHero.description
            else
                context.getString(R.string.hero_notification_description)

        heroesNotification.showNotification(currentHero.name, heroDescription,"-1")

    }
}