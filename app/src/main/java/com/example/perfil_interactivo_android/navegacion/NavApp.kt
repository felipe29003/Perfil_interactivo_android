package com.example.perfil_interactivo_android.navegacion


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.perfil_interactivo_android.ui.theme.MainScreen
import com.example.perfil_interactivo_android.ui.theme.SplashScreen
import com.example.perfil_interactivo_android.ui.theme.Fotos
import com.example.perfil_interactivo_android.ui.theme.Web
import com.example.perfil_interactivo_android.ui.theme.Header
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.perfil_interactivo_android.ui.theme.Botones
import com.example.perfil_interactivo_android.ui.theme.Video


@Composable
fun NavApp() {
    val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Actividades.SplashScreen.route,
            ) {
                composable(Actividades.SplashScreen.route) {
                    SplashScreen(navController)
                }
                composable(Actividades.Main.route) {
                    MainScreen(navController)
                }
                composable(Actividades.VideoScreen.route) {
                    Video(navController)
                }
                composable(Actividades.FotosScreen.route) {
                    Fotos(navController)
                }
                composable(Actividades.WebScreen.route) {
                    Web(navController)
                }
                composable(Actividades.BotonesScreen.route) {
                    Botones(navController)
                }
            }
        }






