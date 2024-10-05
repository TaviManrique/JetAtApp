package com.manriquetavi.jetatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.manriquetavi.jetatapp.ui.theme.JetAtAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        var isSplashScreenVisible by mutableStateOf(true)
        splashScreen.setKeepOnScreenCondition {
            isSplashScreenVisible
        }
        setContent {
            JetAtAppTheme {
                MyApp(
                    isSplashScreenVisible = isSplashScreenVisible,
                    onSplashFinished = { isSplashScreenVisible = false }
                )
            }
        }
    }
}

@Composable
fun SimulateDataLoading(onSplashFinished: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2000)
        onSplashFinished()
    }
}


@Composable
fun MyApp(isSplashScreenVisible: Boolean, onSplashFinished: () -> Unit) {
    if (isSplashScreenVisible) {
        SimulateDataLoading(onSplashFinished = onSplashFinished)
    } else {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    Text(text = "Bienvenido a la app!")
}
