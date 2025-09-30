package com.example.perfil_interactivo_android.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.perfil_interactivo_android.R
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.example.perfil_interactivo_android.navegacion.Actividades
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    Splash()

    LaunchedEffect(Unit) {
        delay(5000)
        navController.navigate(Actividades.Main.route) {
            popUpTo(Actividades.SplashScreen.route) { inclusive = true }
        }
    }
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF0931B6),
                        Color(0xFF9982DB)
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        val imageModifier = Modifier
            .padding(top = 120.dp)
            .size(140.dp)
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "LogoApp",
            modifier = imageModifier
        )

        Text(
            "Perfil interactivo android",
            fontFamily=roboto,
            fontWeight = FontWeight.Bold,
            fontSize= 40.sp,
            modifier = Modifier
                .width(200.dp)
                .padding(top = 90.dp),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(105.dp))
        CircularProgressIndicator(
            modifier = Modifier.size(80.dp),
            color = Color.Gray,
            strokeWidth = 7.dp

        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash()
}