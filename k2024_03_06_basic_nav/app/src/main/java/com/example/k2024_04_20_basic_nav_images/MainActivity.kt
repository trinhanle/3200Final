package com.example.k2024_04_20_basic_nav_images

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.k2024_04_20_basic_nav_images.timers.LeftScreenViewModel
import com.example.k2024_04_20_basic_nav_images.timers.RightScreenViewModel

class MainActivity : ComponentActivity() {

    private val leftViewModel: LeftScreenViewModel by viewModels<LeftScreenViewModel>()
    private val rightViewModel: RightScreenViewModel by viewModels<RightScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Navigation(leftViewModel, rightViewModel)
        }
    }
}

