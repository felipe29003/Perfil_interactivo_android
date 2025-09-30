package com.example.perfil_interactivo_android.navegacion

sealed class Actividades(val route: String) {
    object SplashScreen : Actividades("SplashScreen")
    object Main : Actividades("Main")

    object VideoScreen: Actividades(route = "VideoScreen")

    object FotosScreen: Actividades(route = "FotosScreen")

    object WebScreen: Actividades(route=" WebScreen")

    object BotonesScreen: Actividades(route="BotonesScreen")

}