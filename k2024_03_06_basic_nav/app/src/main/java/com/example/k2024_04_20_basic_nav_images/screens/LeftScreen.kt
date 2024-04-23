package com.example.k2024_04_20_basic_nav_images.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.k2024_04_20_basic_nav_images.timers.LeftScreenViewModel


@Composable
fun LeftScreen(name: String, myViewModel: LeftScreenViewModel) {
    val counter = myViewModel.counter

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(0.75F)
    ) {
        Text("Hello $name")
        Spacer(modifier = Modifier.padding(15.dp))
        Text("Hello ${counter.value.toString()}")
        Spacer(modifier = Modifier.padding(15.dp))
        Button(onClick = { myViewModel.increment() }) {
            Text( "Count: " + counter.value.toString() )
        }
    }
}
