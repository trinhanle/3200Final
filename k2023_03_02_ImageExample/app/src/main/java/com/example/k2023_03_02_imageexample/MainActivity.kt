package com.example.k2023_03_02_imageexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var rose : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rose = findViewById(R.id.roseView)

        rose.setOnClickListener{
            Toast.makeText(this,"Tapped the rose", Toast.LENGTH_SHORT).show()
        }
    }
}