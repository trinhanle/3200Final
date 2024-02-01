package com.example.k2024_01_25a

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.k2024_01_25a.ui.theme.K2024_01_25aTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Get the layout inflater
        val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // Inflate a layout
        val view = layoutInflater.inflate(R.layout.activity_main, null)

        // Add the inflated layout to the activity
        setContentView(view)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(this,"Hello", Toast.LENGTH_LONG).show()
            }
        )
        }
    }

