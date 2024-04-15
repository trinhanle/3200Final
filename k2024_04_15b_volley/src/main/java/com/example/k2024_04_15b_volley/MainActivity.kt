package com.example.k2024_04_15b_volley

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.k2024_04_15b_volley.ui.theme.K2024_04_15b_volleyTheme
import com.example.k2024_04_15b_volley.ui.theme.K2024_04_15b_volleyTheme

class MainActivity : ComponentActivity() {

    private var queue: RequestQueue? = null
    val url = "https://www.google.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        queue = Volley.newRequestQueue(this)
        var name =  mutableStateOf("Android Yeah!")

        setContent {
            K2024_04_15b_volleyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text("Hello ${name.value}", modifier = Modifier.fillMaxSize(0.5f),
                        fontSize = 20.sp)
                    GetUrlData(changeMe = { value -> name.value = value })
                }
            }
        }
    }

    @Composable
    fun GetUrlData(changeMe : (String) -> Unit) {
        var urlString = ""
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                // Display the first 500 characters of the response string.
                urlString = "Response is: ${response.substring(0, 250)}"
            },  { urlString = "That didn't work!" })
        queue?.add(stringRequest)

        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Button(onClick = { changeMe(urlString) }) {
                Text("Get data",
                    fontSize = 30.sp)
            }
        }
    }
}