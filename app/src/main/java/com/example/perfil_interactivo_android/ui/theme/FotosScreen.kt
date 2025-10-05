package com.example.perfil_interactivo_android.ui.theme


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
import com.example.perfil_interactivo_android.data.Lugares
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.perfil_interactivo_android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.Dialog
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.draw.shadow
import kotlin.math.absoluteValue
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage


@Composable
fun Fotos(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val imagelist = remember { mutableStateListOf<Lugares>() }
    val pagerState = rememberPagerState(pageCount = { imagelist.size })
    var mostrarDialogo by remember { mutableStateOf(false) }
    var lugarelegido by remember { mutableStateOf<Lugares?>(null) }
    var detallelugar by remember { mutableStateOf(false) }
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
                        text = "Galería",
                        fontFamily = roboto,
                        fontWeight = FontWeight.Black,
                        fontSize = 36.sp,
                        modifier = Modifier
                            .width(200.dp)
                            .padding(top = 30.dp, end = 70.dp),
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.height(70.dp))

                        HorizontalPager(
                            state = pagerState,
                            contentPadding = PaddingValues(horizontal = 50.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) { page ->
                            AsyncImage(
                                model = imagelist[page].URL,
                                contentDescription = imagelist[page].descripcion,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .width(250.dp)
                                    .height(171.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .clickable {
                                        lugarelegido = imagelist[page]
                                        detallelugar = true
                                    }
                                    .graphicsLayer {
                                        val pageOffset = (
                                                (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                                                ).absoluteValue
                                        val scale = lerp(
                                            start = 0.85f,
                                            stop = 1f,
                                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                        )
                                        scaleX = scale
                                        scaleY = scale
                                        alpha = lerp(
                                            start = 0.85f,
                                            stop = 1f,
                                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                        )
                                    }
                            )
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
                onDismissRequest = {
                    mostrarDialogo = false
                    URL = ""
                    campo_ubicacion = ""
                    campo_descripcion = ""
                }
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
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = campo_ubicacion,
                        onValueChange = { campo_ubicacion = it },
                        label = { Text("Ubicación", fontFamily = roboto, fontWeight = FontWeight.Medium) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().height(100.dp)
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    OutlinedTextField(
                        value = campo_descripcion,
                        onValueChange = { campo_descripcion = it },
                        label = { Text("Descripción", fontFamily = roboto, fontWeight = FontWeight.Medium) },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth().height(100.dp)
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    TextButton(
                        onClick = {
                            if (URL.isNotBlank() && campo_ubicacion.isNotBlank() && campo_descripcion.isNotBlank()) {
                                val lugarnuevo = Lugares(URL, campo_ubicacion, campo_descripcion)
                                imagelist.add(lugarnuevo)
                            }
                            mostrarDialogo = false
                            URL = ""
                            campo_ubicacion = ""
                            campo_descripcion = ""
                        },
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

        if (detallelugar && lugarelegido != null) {
            Dialog(
                onDismissRequest = {
                    detallelugar = false
                    lugarelegido = null
                }
            ) {
                Column(
                    modifier = Modifier
                        .width(500.dp)
                        .height(500.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(30.dp)
                        ),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp)
                        .shadow(
                            elevation = 10.dp,
                            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                            clip = true
                        ))
                    {
                        AsyncImage(
                            model = lugarelegido!!.URL,
                            contentDescription = lugarelegido!!.descripcion,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Column(verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize() )
                        {
                            Text(
                                text = "Ubicación:",
                                fontFamily = roboto,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.Black,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )
                            Spacer(modifier = Modifier.height(15.dp))

                            LazyColumn(modifier = Modifier
                                .fillMaxWidth()
                                .height(25.dp),
                            ) {
                                item {
                                    Text(
                                        text = lugarelegido!!.ubicacion,
                                        fontFamily = roboto,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 14.sp,
                                        color = Color.Black,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 8.dp),
                                        textAlign = TextAlign.Start
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = "Descripción:",
                                fontFamily = roboto,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.Black,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            LazyColumn(modifier = Modifier
                                .fillMaxWidth()
                                .height(70.dp),
                            ) {
                                item{
                                    Text(
                                        text = lugarelegido!!.descripcion,
                                        fontFamily = roboto,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 14.sp,
                                        color = Color.Black,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(start = 8.dp),
                                        textAlign = TextAlign.Start
                                    )
                                }
                            }
                        }
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