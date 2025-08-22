package com.example.quranapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quranapp.presentation.main.MainViewModel
import com.example.quranapp.presentation.splash.SplashScreen
import com.example.quranapp.ui.theme.QuranAppTheme
import com.example.quranapp.utils.LocaleHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuranApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        enableEdgeToEdge()

        setContent {
            val mainViewModel: MainViewModel = hiltViewModel()
            val state by mainViewModel.state

            val context = LocalContext.current
            val localizedContext = LocaleHelper.setLocale(context, state.currentLanguage)

            val darkTheme = when (state.currentTheme) {
                "dark" -> true
                "light" -> false
                else -> isSystemInDarkTheme()
            }

            QuranAppTheme(
                darkTheme = darkTheme,
                dynamicColor = true
            ) {
                QuranAppNavigation()
            }
        }
    }
}

@Composable
fun QuranAppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("main_screen") {
            // Asosiy ekran
        }
        composable("settings_screen") {
            // Sozlamalar ekrani
        }
    }
}