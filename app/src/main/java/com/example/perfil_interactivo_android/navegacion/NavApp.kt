package com.example.perfil_interactivo_android.navegacion


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.perfil_interactivo_android.ui.theme.Main
import com.example.perfil_interactivo_android.ui.theme.SplashScreen

@Composable
fun NavApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Actividades.SplashScreen.route
    ) {
        composable(Actividades.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(Actividades.Main.route) {
            Main()
        }
    }
}