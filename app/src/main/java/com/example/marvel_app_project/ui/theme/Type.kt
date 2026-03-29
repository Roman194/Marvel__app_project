package com.example.marvel_app_project.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Define the typography styles for the application.
 * This includes styles for body text, titles, and labels.
 * These styles can be used throughout the app to maintain a consistent look and feel.
 */
// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.Bold,
        fontSize = Sizes.fontSizes.heroDescription,
        lineHeight = Sizes.fontSizes.heroDescription,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = Sizes.fontSizes.heroNameInCard,
        lineHeight = Sizes.fontSizes.heroNameInCard,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = Sizes.fontSizes.underLogoText,
        lineHeight = Sizes.fontSizes.underLogoText,
        letterSpacing = 0.sp
    ),
    labelLarge = TextStyle(
        fontFamily = interFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = Sizes.fontSizes.responseError,
        lineHeight = Sizes.fontSizes.responseError,
        letterSpacing = 0.sp
    )
)
