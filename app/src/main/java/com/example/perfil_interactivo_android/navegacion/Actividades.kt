package com.example.perfil_interactivo_android.navegacion

sealed class Actividades(val route: String) {
    object SplashScreen : Actividades("SplashScreen")
    object Main : Actividades("Main")

    object VideoScreen: Actividades(route = "VideoScreen")

}