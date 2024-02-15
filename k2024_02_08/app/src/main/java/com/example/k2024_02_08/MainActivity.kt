package com.example.k2024_02_08

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.k2024_02_08.ui.theme.K2024_02_08Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button

val array: List<String> = listOf("Hello", "Good day", "Sunshine")
var index: Int = 0
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            K2024_02_08Theme {
                MyContainer()
            }
        }
    }
}

@Composable
fun MyContainer() {
    Column {
        Greeting(index)
        Button(onClick = { index = index + 1 }) {
            Text("Select")
        }
        CounterText()
    }
}

@Composable
fun CounterText() { // RythmDroid
    val count = remember {
        mutableStateOf(0)
    }
    Button(onClick = { count.value += 1 }) {
        Text(text = "Current Count = ${count.value}")
    }
}

@Composable
fun Greeting(index: Int, modifier: Modifier = Modifier) {
    Text(
        text = array[index],
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    K2024_02_08Theme {
        Greeting(0)
    }
}