package com.example.k2024_04_18_volley_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.example.k2024_04_18_volley_compose.ui.theme.K2024_04_18_volley_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            K2024_04_18_volley_composeTheme {
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

    val jsonArrayRequest = JsonArrayRequest(
        Request.Method.GET,
        urlJSON,
        null,
        { response ->
            // Display the first 500 characters of the response string.
            val basicQuestionView
            basicQuestionView.setText("Response is: ${response}")

            var questionList: List<Question> = gson.fromJson(response.toString(), Array<Question>::class.java ).toList()
        },
        { error ->  basicQuestionView.text = "Error: ${error}" })

    queue.add(jsonArrayRequest)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
