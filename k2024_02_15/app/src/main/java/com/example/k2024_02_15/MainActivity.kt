package com.example.k2024_02_15

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.k2024_02_15.ui.theme.K2024_02_15Theme


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            K2024_02_15Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}


// var buttonLabel = remember { mutableStateOf("SELECTED") }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

   Column(modifier = Modifier.padding(30.dp),
       horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
   {
       var buttonLabel = remember { mutableStateOf( "Select") }
       var textBoxValue = remember { mutableStateOf( "0") }
       Text(
           text = "Hello $name!",
           fontSize = 40.sp,
           modifier = modifier
       )
       Button(onClick = { buttonLabel.value = "DONE" }, modifier = Modifier
           .padding(bottom = 32.dp)
           .fillMaxWidth(0.5F)) {
           Text(text = "${buttonLabel.value}")
       }
       EditNumberField(value = textBoxValue.value, { textBoxValue.value = it },
           modifier)
   }
}

@Composable
fun EditNumberField(value: String,
                    onValueChange: (String) -> Unit,
                    modifier: Modifier = Modifier) {

    TextField(value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier)
}
