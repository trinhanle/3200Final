package com.example.k2024_02_22_two_activities

import android.app.Application
import android.content.Intent
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.k2024_02_22_two_activities.ui.theme.K2024_02_22_two_activitiesTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var myIntent = Intent(applicationContext, ActivityTwo::class.java )

        setContent {
            K2024_02_22_two_activitiesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android",
                    {
                        myIntent.apply {
                            putExtra(android.content.Intent.EXTRA_TEXT, "Hello from Activity 1")
                        }
                        myIntent.also{
                            startActivity(it)
                        }
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, myLambda: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = {
            myLambda()
        }) {
            Text("Launch activity two")
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    K2024_02_22_two_activitiesTheme {
        //Greeting("Android")
    }
}