package com.example.k2024_03_06_basic_nav.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.k2024_03_06_basic_nav.models.CurrentTime
import com.example.k2024_03_06_basic_nav.timers.RightScreenViewModel


@Composable
fun RightScreen(name: String, myViewModel: RightScreenViewModel) {

    //var secondsText by remember { mutableStateOf(myViewModel) }
    //var secondsText = myViewModel.getSeconds()
    val text = remember {
        mutableStateOf("0")
    }
    val currentTime = CurrentTime()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(0.75F)
    ) {
        Text("Hello $name")
        Spacer(modifier = Modifier.padding(25.dp))
        Text("Hello ${currentTime.seconds}", fontSize = 30.sp)
        OutlinedTextField(
            value = text.value,
            onValueChange = { text.value = it  },
            label = { Text("No label") }
        )

        Button(onClick = { currentTime.updateTime() }) {
            Text( "Update seconds" )
        }
    }
}