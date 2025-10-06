package com.example.perfil_interactivo_android.ui.theme

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.navigation.NavHostController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.perfil_interactivo_android.R
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import com.example.perfil_interactivo_android.data.Webdata
import androidx.compose.runtime.getValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.viewinterop.AndroidView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Web(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var URLWeb by remember { mutableStateOf(Webdata("")) }
    var estadobar by remember { mutableStateOf(false) }
    var webcargada by remember { mutableStateOf(false) }

    Header(
        navController = navController,
        drawerState = drawerState,
        scope = scope,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            SearchBar(
                query = URLWeb.URLweb,
                onQueryChange = { newUrl ->
                    URLWeb = URLWeb.copy(URLweb = newUrl) },
                onSearch = {
                    if (URLWeb.URLweb.isNotBlank() && URLWeb.URLweb.startsWith("http")) {
                        webcargada= true
                    }
                    estadobar = false
                },
                active = estadobar,
                onActiveChange = { estadobar = it },
                placeholder = {
                    Text(
                        "Ingresa una URL...",
                        fontFamily = roboto,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Italic
                    )
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.icono_buscar),
                        contentDescription = "Buscar",
                        modifier = Modifier.size(25.dp)
                    )
                },
                trailingIcon = {
                    if(estadobar){
                        Icon(
                            painter = painterResource(id = R.drawable.icono_borrar),
                            contentDescription = "iconoborrar",
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                    if(URLWeb.URLweb.isNotEmpty()) {
                                        URLWeb = URLWeb.copy(URLweb = "")
                                    }
                                    else{
                                        estadobar=false
                                    }

                                }
                        )
                    }
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding( start = 20.dp, end = 20.dp, bottom = 10.dp)
            ) {
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                if (webcargada && URLWeb.URLweb.isNotBlank()){
                    AndroidView(factory ={
                        WebView(it).apply {
                            webViewClient = WebViewClient()
                            settings.javaScriptEnabled = true
                            settings.builtInZoomControls = true
                            settings.displayZoomControls = false
                            loadUrl(URLWeb.URLweb)
                        }
                    } )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WebPreview() {
    val navController = rememberNavController()
    Web(navController = navController)
}