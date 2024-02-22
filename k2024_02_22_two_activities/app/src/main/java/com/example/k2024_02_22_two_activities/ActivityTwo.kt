package com.example.k2024_02_22_two_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.k2024_02_22_two_activities.ui.theme.K2024_02_22_two_activitiesTheme

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        setContent {
            K2024_02_22_two_activitiesTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                Text(stringResource(id = R.string.greetings),  color = Color.Blue,
                    fontSize = 32.sp)
                val s: String? = intent.getStringExtra(Intent.EXTRA_TEXT)
                Text(s ?: "XXX",
                    color = Color.Blue,
                    fontSize = 32.sp)
                }

            }
        }
    }
}