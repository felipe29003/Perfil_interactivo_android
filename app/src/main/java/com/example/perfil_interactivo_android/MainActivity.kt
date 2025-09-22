// =================================================================
// Archivo: app/src/main/java/com/example/perfil_interactivo_android/MainActivity.kt
// =================================================================
package com.example.perfil_interactivo_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.perfil_interactivo_android.ui.theme.PerfilinteractivoandroidTheme
import com.example.perfil_interactivo_android.ui.theme.profile.ProfileListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerfilinteractivoandroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "profile_list"
    ) {
        composable("profile_list") {
            ProfileListScreen(navController = navController)
        }
        // Aquí puedes añadir más destinos en el futuro, como la pantalla para añadir perfiles
        // composable("add_profile") {
        //     AddProfileScreen(navController = navController)
        // }
    }
}
