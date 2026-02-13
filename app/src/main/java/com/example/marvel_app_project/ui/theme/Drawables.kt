package com.example.marvel_app_project.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.marvel_app_project.R

/**
 * Object to centralize all drawable resources used in the application.
 * This ensures consistent access to images and prevents resource ID errors.
 * @author Zyuzin Roman
 */
object Drawables {
    val marvelLogo: Painter
        @Composable
        get() = painterResource(R.drawable.marvel_logo)

    val loadingImg: Painter
        @Composable
        get() = painterResource(R.drawable.loading_img)

    val marvelCardLoading: Painter
        @Composable
        get() = painterResource(R.drawable.marvelcard_loading)

    val marvelCardLoadingError: Painter
        @Composable
        get() = painterResource(R.drawable.marvelcard_loadingerror)

    val connectionError: Painter
        @Composable
        get() = painterResource(R.drawable.ic_connection_error)
}