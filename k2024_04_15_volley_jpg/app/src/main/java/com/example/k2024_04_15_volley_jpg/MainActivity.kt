package com.example.k2024_04_15_volley_jpg

import android.graphics.Bitmap
import android.os.Bundle
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.k2024_04_15_volley_jpg.ui.theme.K2024_04_15_volley_jpgTheme

class MainActivity : ComponentActivity() {

    private var queue: RequestQueue? = null
    val url = "https://www.google.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        queue = Volley.newRequestQueue(this)
        var name = mutableStateOf("Android Yeah!")

        setContent {
            K2024_04_15_volley_jpgTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
/*
                    Text(
                        "Hello ${name.value}", modifier = Modifier.fillMaxSize(0.5f),
                        fontSize = 20.sp
                    )

 */
                    imageFromURL()
                    //GetUrlJpgData(changeMe = { value -> name.value = value })
                }
            }
        }
    }

    @Composable
    fun GetUrlJpgData(changeMe: (Bitmap) -> Unit) {
        var urlString: String
        val imgRequest = ImageRequest(url,

            { bitmap ->
                {

                }

                // handle Bitmap image
            }, 0, 0, null, null,
            { volleyError ->
                // handle error
            })
        // Add the request to the RequestQueue
        queue?.add(imgRequest)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = {  }) {
                Text(
                    "Get data",
                    fontSize = 30.sp
                )
            }
        }
    }
}


    @Composable
    fun imageFromURL() {
        // on below line we are creating a column,
        Column(
            // in this column we are adding modifier
            // to fill max size, mz height and max width
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .fillMaxWidth()
                // on below line we are adding
                // padding from all sides.
                .padding(10.dp),
            // on below line we are adding vertical
            // and horizontal arrangement.
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // on below line we are adding image for our image view.
            Image(
                // on below line we are adding the image url
                // from which we will  be loading our image.
                // "https://media.geeksforgeeks.org/wp-content/uploads/20210101144014/gfglogo.png"
                // "https://images.metmuseum.org/CRDImages/ad/original/130480.jpg"
                painter = rememberAsyncImagePainter("https://media.geeksforgeeks.org/wp-content/uploads/20210101144014/gfglogo.png"),

                // on below line we are adding content
                // description for our image.
                contentDescription = "MET Image",

                // on below line we are adding modifier for our
                // image as wrap content for height and width.
                modifier = Modifier
                    .wrapContentSize()
                    .wrapContentHeight()
                    .wrapContentWidth()
            )
        }
    }