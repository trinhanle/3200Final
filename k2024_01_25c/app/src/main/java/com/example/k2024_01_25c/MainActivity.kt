package com.example.k2024_01_25c

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Get the layout inflater
        val layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // Inflate a layout
        val view = layoutInflater.inflate(R.layout.activity_main, null)

        // Add the inflated layout to the activity
        setContentView(view)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(this,"Hello Great world!", Toast.LENGTH_LONG).show()
            }
        )
    }
}

