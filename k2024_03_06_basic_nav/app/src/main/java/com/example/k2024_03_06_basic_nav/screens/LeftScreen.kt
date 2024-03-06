package com.example.k2024_03_06_basic_nav.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.k2024_03_06_basic_nav.timers.LeftScreenViewModel


@Composable
fun LeftScreen(name: String, myViewModel: LeftScreenViewModel) {
    val counter = myViewModel.counter

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(0.75F)
    ) {
        Text("Hello $name")
        Spacer(modifier = Modifier.padding(25.dp))
        Text("Hello ${counter.value.toString()}")
        TextField(
            value = counter.value.toString(),
            onValueChange = {  },
            label = { Text("No label") }
        )

        Button(onClick = { myViewModel.increment() }) {
            Text( counter.value.toString() )
        }
    }
}
