package com.example.marvel_app_project

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.marvel_app_project.ui.navigation.AppNavGraph
import com.example.marvel_app_project.ui.theme.ApplySystemBarColors
import com.example.marvel_app_project.ui.theme.Marvel_app_projectTheme
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window,false)

        val heroId = intent.getIntExtra("heroId", -1)

        getFCMToken()

        setContent {
            Marvel_app_projectTheme {

                ApplySystemBarColors()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavGraph(heroId = heroId)
                }
            }
        }
    }

    private fun getFCMToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(getString(R.string.fcm_token_tag), getString(R.string.fcm_token_tag_fail), task.exception)
                return@OnCompleteListener
            }

            val token = task.result
            Log.d(getString(R.string.fcm_token_tag), token)

        })
    }
}

