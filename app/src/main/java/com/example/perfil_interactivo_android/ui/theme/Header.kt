package com.example.perfil_interactivo_android.ui.theme


import android.annotation.SuppressLint
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Popup
import androidx.navigation.PopUpToBuilder
import androidx.navigation.compose.rememberNavController
import com.example.perfil_interactivo_android.R
import com.example.perfil_interactivo_android.ui.theme.roboto
import kotlinx.coroutines.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerDefaults
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    navController: NavHostController,
    drawerState: DrawerState,
    scope: CoroutineScope,
    content: @Composable (PaddingValues) -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet() {
                NavigationDrawerItem(
                    label = { Text(
                        text= "Perfil",
                        fontSize = 30.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight.ExtraBold,
                        color = Black) },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            navController.navigate(Actividades.Main.route)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.usuario_icono),
                            contentDescription = "Icono_usuario",
                            modifier = Modifier.size(35.dp)
                        )
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Fotos",
                        fontSize = 30.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight.ExtraBold,
                        color = Black) },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            navController.navigate(Actividades.FotosScreen.route)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icono_fotos),
                            contentDescription = "Icono_fotos",
                            modifier = Modifier.size(35.dp)
                        )
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Videos",
                        fontSize = 30.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight.ExtraBold,
                        color = Black) },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            navController.navigate(Actividades.VideoScreen.route)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icono_reproductor),
                            contentDescription = "Icono_reproductor",
                            modifier = Modifier.size(35.dp)
                        )
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Web",
                        fontSize = 30.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight.ExtraBold,
                        color = Black) },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            navController.navigate(Actividades.WebScreen.route)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icono_web),
                            contentDescription = "Icono_web",
                            modifier = Modifier.size(35.dp)

                        )
                    }
                )
                NavigationDrawerItem(
                    label = { Text("Botones",
                        fontSize = 30.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight.ExtraBold,
                        color = Black) },
                    selected = false,
                    onClick = {
                        scope.launch {
                            drawerState.close()
                            navController.navigate(Actividades.BotonesScreen.route)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icono_boton),
                            contentDescription = "Icono_boton",
                            modifier = Modifier.size(35.dp)
                        )
                    }
                )

            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "PIA",
                            fontSize = 32.sp,
                            fontFamily = roboto,
                            fontWeight = FontWeight.Normal,
                            color = White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                painter = painterResource(id = R.drawable.icono_menu),
                                contentDescription = "MenuDesplegable",
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    },
                    actions = {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Logo",
                            modifier = Modifier.size(80.dp)
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF00325F)
                    )
                )
            },
            content = content
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Header(
        navController = navController,
        drawerState = drawerState,
        scope = scope,
        content = { paddingValues ->
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
            )
        }
    )
}



