package com.example.perfil_interactivo_android.ui.theme

import android.app.Dialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.perfil_interactivo_android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import coil.compose.rememberAsyncImagePainter
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.Dialog


@Composable
fun Fotos(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val imagelist = listOf(
        "https://cdn.pixabay.com/photo/2021/05/29/03/00/beach-6292382_1280.jpg",
        "https://cdn.pixabay.com/photo/2015/02/17/09/33/machu-pichu-639174_1280.jpg",
        "https://cdn.pixabay.com/photo/2019/10/22/18/31/rio-branco-4569465_1280.jpg"
    )
    var mostrarDialogo by remember { mutableStateOf(false) }
    var URL by remember { mutableStateOf("") }
    var campo_ubicacion by remember { mutableStateOf("") }
    var campo_descripcion by remember { mutableStateOf("") }

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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .height(650.dp)
                    .background(Color.White)
                    .padding(30.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Galeria",
                        fontFamily = roboto,
                        fontWeight = FontWeight.Black,
                        fontSize = 36.sp,
                        modifier = Modifier
                            .width(200.dp)
                            .padding(top = 30.dp, end = 70.dp),
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.height(70.dp))

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(imagelist) { imageUrl ->
                            Image(
                                painter = rememberAsyncImagePainter(imageUrl),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(250.dp)
                                    .height(171.dp)
                                    .clip(RoundedCornerShape(20.dp))
                            )
                        }
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.icono_agregar),
                    contentDescription = "Imagen clickeable",
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                        .align(Alignment.BottomEnd)
                        .size(80.dp)
                        .clickable { mostrarDialogo = true }
                )
            }
        }

        if (mostrarDialogo) {
            Dialog(
                onDismissRequest = { mostrarDialogo = false }
            ) {
                Column(
                    modifier = Modifier
                        .width(400.dp)
                        .height(500.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Adjuntar imagen",
                        fontFamily = roboto,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp,
                        color = Color.Black

                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    OutlinedTextField(
                        value = URL,
                        onValueChange = { URL = it },
                        label = { Text("URL de la imagen",
                            fontFamily = roboto,
                            fontWeight = FontWeight.Medium) },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = campo_ubicacion,
                        onValueChange = { campo_ubicacion = it },
                        label = { Text("Ubicación",fontFamily = roboto,
                            fontWeight = FontWeight.Medium) },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = campo_descripcion,
                        onValueChange = { campo_descripcion = it },
                        label = { Text("Descripción",
                            fontFamily = roboto,
                            fontWeight = FontWeight.Medium
                            ) },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    TextButton(
                        onClick = { mostrarDialogo = false },
                        modifier = Modifier
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(Color(0xFF96EE8B), Color(0xFF58B469))
                                ),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(horizontal = 70.dp, vertical = 5.dp)
                    ) {
                        Text(
                            "Enviar",
                            fontFamily = roboto,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }


    }
}



@Preview(showBackground = true)
@Composable
fun FotosPreview() {
    val navController = rememberNavController()
    Fotos(navController = navController)
}