package com.example.marvel_app_project.notification.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.marvel_app_project.notification.HeroesNotification

//@AndroidEntryPoint
class UpdateNotificationReceiver: BroadcastReceiver() {

//    @Inject
//    lateinit var repository: HeroRepository
    //TODO(Solve problems with Hilt injection in a BroadcastReceiver to implement "I'm lucky button functionality")
    override fun onReceive(context: Context, intent: Intent?) {

        val heroesNotification = HeroesNotification(context)


//        CoroutineScope(Dispatchers.IO).launch{
//            val responseFromRepo = repository.randSingleHero()
//
//            val heroDescription =
//                if(responseFromRepo.description != "")
//                    responseFromRepo.description
//                else
//                    "You're unlucky:( No description"
//
//            heroesNotification.showNotification(responseFromRepo.name, heroDescription, responseFromRepo.id.toString())
//        }
    }
}