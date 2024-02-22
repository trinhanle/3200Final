package com.example.k2024_02_22b_two_activities

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.k2024_02_22b_two_activities.ui.theme.K2024_02_22b_two_activitiesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myIntent = Intent(applicationContext,ActivityThree::class.java)

        setContent {
            K2024_02_22b_two_activitiesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android",
                        {
                            myIntent.apply {
                                putExtra(Intent.EXTRA_TEXT, "from Activity 1")
                            }
                            myIntent.also {
                                startActivity(it)
                            }
                        }
                    )
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
            text = "Hello",
            modifier = modifier
        )
        Button(onClick = {
            myLambda()
        }) {
            Text("Launch Activity 2")
        }

        Button(onClick = {
            myLambda()
        }) {
            Text("Launch Activity 2")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    K2024_02_22b_two_activitiesTheme {
        //Greeting("Android")
    }
}