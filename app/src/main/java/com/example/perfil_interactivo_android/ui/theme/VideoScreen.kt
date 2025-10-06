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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.perfil_interactivo_android.data.Videosdata
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.foundation.pager.rememberPagerState
import kotlin.math.absoluteValue
import androidx.compose.ui.util.lerp
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.AspectRatioFrameLayout
import com.example.perfil_interactivo_android.data.Lugares


@Composable
fun Video(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var mostrarDialogoVideo by remember { mutableStateOf(false) }
    val videolist = remember { mutableStateListOf<Videosdata>() }
    var URL_Video by remember { mutableStateOf("") }
    val pagerState = rememberPagerState(pageCount = { videolist.size })

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
                        text = "Videos",
                        fontFamily = roboto,
                        fontWeight = FontWeight.Black,
                        fontSize = 36.sp,
                        modifier = Modifier
                            .width(200.dp)
                            .padding(top = 30.dp, end = 70.dp),
                        textAlign = TextAlign.Center,
                    )


                    VerticalPager (
                        state = pagerState,
                        contentPadding = PaddingValues(vertical = 140.dp),
                        modifier = Modifier
                            .fillMaxWidth()

                    ) { page ->
                        VideoPlayerDemo(
                            videoUrl = videolist[page].URLVideos,
                            isSelected = page == pagerState.currentPage,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .clip(RoundedCornerShape(16.dp))
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
                                        start = 0.5f,   
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
                        .clickable { mostrarDialogoVideo = true }
                )

            }
        }
    }
    if (mostrarDialogoVideo) {
        Dialog(
            onDismissRequest = {
                mostrarDialogoVideo = false
                URL_Video = ""
            }
        ) {
            Column(
                modifier = Modifier
                    .width(400.dp)
                    .height(300.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Adjuntar video",
                    fontFamily = roboto,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 25.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = URL_Video,
                    onValueChange = { URL_Video = it },
                    label = { Text("URL del video",
                        fontFamily = roboto,
                        fontWeight = FontWeight.Medium) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(30.dp))

                TextButton(
                    onClick = {
                        if (URL_Video.isNotBlank()) {
                            val videonuevo = Videosdata(URL_Video)
                            videolist.add(videonuevo)
                        }
                        mostrarDialogoVideo = false
                        URL_Video = ""
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
}

@androidx.annotation.OptIn(UnstableApi::class)
@Composable
fun VideoPlayerDemo(
    videoUrl: String,
    isSelected: Boolean = true,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val exoPlayer = remember(videoUrl) {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(videoUrl)
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = false
        }
    }

    LaunchedEffect(isSelected) {
        if (!isSelected) {
            exoPlayer.pause()
        }
    }
    AndroidView(
        modifier = modifier,
        factory = { ctx ->
            PlayerView(ctx).apply {
                player = exoPlayer
                useController = true
                setShowBuffering(PlayerView.SHOW_BUFFERING_WHEN_PLAYING)
                resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
            }
        }
    )
    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VideoPreview() {
    val navController = rememberNavController()
    Video(navController = navController)
}