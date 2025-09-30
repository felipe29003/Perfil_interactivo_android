package com.example.perfil_interactivo_android.navegacion


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.perfil_interactivo_android.ui.theme.MainScreen
import com.example.perfil_interactivo_android.ui.theme.SplashScreen
import com.example.perfil_interactivo_android.ui.theme.Header
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.perfil_interactivo_android.ui.theme.Video


@Composable
fun NavApp() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute == Actividades.SplashScreen.route) {
        NavHost(
            navController = navController,
            startDestination = Actividades.SplashScreen.route
        ) {
            composable(Actividades.SplashScreen.route) {
                SplashScreen(navController)
            }
            composable(Actividades.Main.route) {
                MainScreen()
            }
            composable(Actividades.VideoScreen.route) {
                Video()
            }

        }
    } else {
        Header(
            navController = navController,
            drawerState = drawerState,
            scope = scope
        ) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Actividades.SplashScreen.route,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(Actividades.SplashScreen.route) {
                    SplashScreen(navController)
                }
                composable(Actividades.Main.route) {
                    MainScreen()
                }
                composable(Actividades.VideoScreen.route) {
                    Video()
                }
            }
        }
    }
}




