package com.example.marvel_app_project.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.marvel_app_project.MainActivity
import com.example.marvel_app_project.R

class HeroesNotification(private val context: Context) {
    companion object{
        const val HEROES_CHANNEL_ID = "heroes_channel"
    }

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    fun showNotification(title:String?, text: String?, heroId: String?){
        val activityIntent = Intent(context, MainActivity::class.java)
        activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activityIntent.putExtra("heroId", heroId?.toInt())
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_UPDATE_CURRENT else 0
        )

        val notification = NotificationCompat.Builder(context, HEROES_CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_boy_24)
            .setContentTitle(title)
            .setContentText(text + " " + heroId)
            .setContentIntent(activityPendingIntent)
            .setAutoCancel(true)
            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .build()

        notificationManager.notify(1, notification)
    }
}