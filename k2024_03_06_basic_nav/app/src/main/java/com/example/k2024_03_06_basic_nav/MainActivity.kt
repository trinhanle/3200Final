package com.example.k2024_03_06_basic_nav

import android.icu.util.GregorianCalendar
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.k2024_03_06_basic_nav.timers.LeftScreenViewModel
import com.example.k2024_03_06_basic_nav.timers.RightScreenViewModel
import com.example.k2024_03_06_basic_nav.ui.theme.K2024_03_06_basic_navTheme

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

