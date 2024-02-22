package com.example.k2024_02_21_two_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.k2024_02_21_two_activities.ui.theme.K2024_02_21_two_activitiesTheme

class ActivityTwo : AppCompatActivity() {

    var myString = "Basic string"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        setContent {
            K2024_02_21_two_activitiesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val s: String? =getIntent().getStringExtra(Intent.EXTRA_TEXT)
                    Log.i("PGB99",s?: "XXXX")
                    DataField(s ?: "Nothing")
                }
            }
        }
    }
}

@Composable
fun DataField(str: String) {
    var text by remember { mutableStateOf(str) }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}