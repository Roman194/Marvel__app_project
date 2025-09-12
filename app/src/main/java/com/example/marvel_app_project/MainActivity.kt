package com.example.marvel_app_project

import android.os.Bundle
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
import dagger.hilt.android.AndroidEntryPoint

/**
 * The Main activity of this app.
 * A place where edge to edge approach and intent for heroId notification adds.
 * Also it's a place where [AppNavGraph] is called
 *
 * @see AppNavGraph
 * @author Zyuzin Roman
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window,false)

        val heroId = intent.getIntExtra("heroId", -1)

        /**
         * Creates composable function invocations
         */
        setContent {
            Marvel_app_projectTheme {

                ApplySystemBarColors()

                /**
                 * [Surface] function set general params for this app UI.
                 *
                 * @property Modifier sets to Fill max possible size
                 * @property color set the background color for this [Surface]
                 */
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /**
                     * [AppNavGraph] function creates the main navigation menu between screens.
                     *
                     * @property heroId is used to choose startDestination on [NavHostController]
                     */
                    AppNavGraph(heroId = heroId)
                }
            }
        }
    }
}

