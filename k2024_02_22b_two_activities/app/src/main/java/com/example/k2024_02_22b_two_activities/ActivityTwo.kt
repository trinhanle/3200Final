package com.example.k2024_02_22b_two_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.k2024_02_22b_two_activities.ui.theme.AppTheme

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        setContent {
            AppTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    TextField(value = "ACTIVITY 2", onValueChange = {})
                    val str:String? = intent.getStringExtra(Intent.EXTRA_TEXT)
                    TextField(value = str ?: "Else", onValueChange = {})
                }
                
            }
        }
    }
}