package com.guru.composecookbook.ui.demoui

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.guru.composecookbook.data.DemoDataProvider
import com.guru.composecookbook.ui.cryptoappmvvm.ui.home.CryptoHomeActivity
import com.guru.composecookbook.ui.demoui.spotify.SpotifyActivity
import com.guru.composecookbook.ui.moviesappmvi.ui.MoviesHomeActivity

@Composable
fun DemoUIList() {
    val demoUis = remember { DemoDataProvider.demoUiList }
    val context = ContextAmbient.current
    Scaffold {
        LazyColumnFor(items = demoUis) { title ->
            Button(
                onClick = {
                    when (title) {
                        "Spotify" -> {
                            context.startActivity(
                                SpotifyActivity.newIntent(context, false)
                            )
                        }
                        "CryptoApp+MVVM" -> {
                            context.startActivity(
                                CryptoHomeActivity.newIntent(context, false)
                            )
                        }
                        "MoviesApp+MVVM" -> {
                            context.startActivity(
                                MoviesHomeActivity.newIntent(context, false)
                            )
                        }
                        else -> {
                            context.startActivity(
                                DemoUIHostActivity.newIntent(context, title, false)
                            )
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(12.dp)
            ) {
                Text(text = title, modifier = Modifier.padding(8.dp))
            }
        }
    }
}


@Preview
@Composable
fun previewDemoUis() {
    DemoUIList()
}