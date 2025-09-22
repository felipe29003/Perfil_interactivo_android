package com.example.perfil_interactivo_android


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.perfil_interactivo_android.navegacion.NavApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavApp() // Punto central de navegación
        }
    }
}