package com.example.k2024_04_18a_remembercoil

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.k2024_04_18a_remembercoil.ui.theme.K2024_04_18A_rememberCOILTheme

var toggle: Boolean = true

class MainActivity : ComponentActivity() {

    var url1 = "https://images.metmuseum.org/CRDImages/ad/web-large/ADA3882.jpg"
    var url2 = "https://images.metmuseum.org/CRDImages/ad/original/117343.jpg"
    var url = url1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            K2024_04_18A_rememberCOILTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly) {
                        Button(onClick = { url = url2 } ) {
                                    Text("Get Image")
                        }
                        if (toggle) {
                            getImageFromUrl(url)
                        } else {
                            getImageFromUrl(url2)
                        }
                        toggle = ! toggle
                    }
                }
            }
        }
    }

    @Composable
    fun getImageFromUrl(url : String) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp)
        ){
            Image(
                painter = rememberAsyncImagePainter(url),
                contentDescription = "Met image",
                modifier = Modifier.wrapContentSize().wrapContentHeight().wrapContentWidth()
            )
            Button(onClick = { changeMyUrl(url2) }) {
                Text("Update image")
            }
        }
    }

    fun changeMyUrl(newUrl: String) {
        url = newUrl
        Log.i("PGB", "in change URL")
    }

}


