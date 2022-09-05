package no.rindus.android.rindus.ui.forecast.components.web

import android.graphics.Bitmap
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import no.rindus.android.rindus.ui.theme.White300

@Composable
fun NetworkScreen() {
    val url = remember { mutableStateOf("https://www.rindus.de/") }
    val visibility = remember { mutableStateOf(false) }
    val progress = remember { mutableStateOf(0.0F) }

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(Modifier.fillMaxSize()) {
                AndroidView(factory = { context ->
                    WebView(context).apply {
                        settings.javaScriptEnabled = true

                        webViewClient = object : WebViewClient() {
                            override fun onPageStarted(
                                view: WebView, url: String,
                                favicon: Bitmap?,
                            ) {
                                visibility.value = true
                            }

                            override fun onPageCommitVisible(
                                view: WebView, url: String,
                            ) {
                                visibility.value = false
                            }
                        }

                        webChromeClient = object : WebChromeClient() {
                            override fun onProgressChanged(
                                view: WebView, newProgress: Int,
                            ) {
                                progress.value = newProgress.toFloat()
                            }
                        }

                        loadUrl(url.value)
                    }
                }, update = {
                    it.loadUrl(url.value)
                })
            }
        }
        if (visibility.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(White300)
            ) {

                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center),
                )
            }
        }
    }
}