package com.example.perfil_interactivo_android.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Font
import androidx.compose.material3.Typography
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.perfil_interactivo_android.navegacion.Actividades
import kotlinx.coroutines.delay
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import com.example.perfil_interactivo_android.R
import com.example.perfil_interactivo_android.ui.theme.roboto


@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .background(Color(0xFF00325F))
            .shadow(6.dp)
            .background(Color(0xFF00325F))

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.icono_menu),
                contentDescription = "MenuDesplegable",
                modifier = Modifier
                    .padding(top = 3.dp)
                    .padding(start = 40.dp)
                    .size(38.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(80.dp)
            )
        }

        Text(
            text = "PIA",
            color = Color.White,
            fontFamily = roboto,
            fontWeight = FontWeight.Normal,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(end = 15.dp)
        )

    }
}





@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    Header()
}