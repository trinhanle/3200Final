package com.example.k2025_02_01

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.k2025_02_01.ui.theme.K2025_02_01Theme


const val ON_CREATE = "ON__CREATE"
const val ON_START = "ON__START"
const val ON_STOP = "ON__STOP"
const val ON_PAUSE = "ON__PAUSE"
const val ON_RESUME = "ON__RESUME"
const val ON_DESTROY = "ON__DESTROY"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(ON_CREATE, "onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.i(ON_START, "onStart called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(ON_PAUSE, "onPause called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(ON_RESUME, "onResume called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(ON_STOP, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(ON_DESTROY, "onDestroy called")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    K2025_02_01Theme {
        Greeting("Android")
    }
}