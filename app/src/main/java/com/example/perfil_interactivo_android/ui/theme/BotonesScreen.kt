package com.example.perfil_interactivo_android.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.scale
import androidx.navigation.compose.rememberNavController

@Composable
fun Botones(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var SwitchStatus by remember { mutableStateOf(false) }

    Header(
        navController = navController,
        drawerState = drawerState,
        scope = scope,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF00325F))
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .height(620.dp)
                    .width(350.dp)
                    .background(Color.White)
                    .padding(30.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Botones",
                        fontFamily = roboto,
                        fontWeight = FontWeight.Black,
                        fontSize = 32.sp,
                        modifier = Modifier.padding(top = 30.dp, end = 3.dp),
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.height(150.dp))

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = "Modo Oscuridad",
                            fontFamily = roboto,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color(0xFF717275),
                            modifier = Modifier
                                .padding(bottom = 30.dp),
                            textAlign = TextAlign.Center,
                        )
                        Switch(
                            checked = SwitchStatus,
                            onCheckedChange = { SwitchStatus = it },
                            modifier = Modifier.scale(2.5f),
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color(0xFF00325F),
                                checkedTrackColor = Color(0xFF0053A1),
                                checkedBorderColor = Color.Transparent,
                                uncheckedThumbColor = Color(0xFF00325F),
                                uncheckedTrackColor = Color(0xFFE6D7D7),
                                uncheckedBorderColor = Color.Transparent
                            )
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BotonesPreview() {
    val navController = rememberNavController()
    Botones(navController = navController)
}