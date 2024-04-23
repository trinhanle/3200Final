package com.example.k2024_04_20_basic_nav_images.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.k2024_04_20_basic_nav_images.timers.RightScreenViewModel


@Composable
fun RightScreen(name: String, myViewModel: RightScreenViewModel) {

    var time = myViewModel.time

    val text = remember {
        mutableStateOf("0")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(0.75F)
    ) {
        Text("Hello $name", fontSize = 36.sp)
        Spacer(modifier = Modifier.padding(15.dp))
        Text("Minutes:Seconds = ${time.value.getCurrentMinutes()}:${time.value.getCurrentSeconds()}", fontSize = 26.sp)
        Spacer(modifier = Modifier.padding(15.dp))
        OutlinedTextField(value = text.value,
            onValueChange = { text.value = time.value.getCurrentSeconds() },
            modifier = Modifier
                .fillMaxWidth(0.5F)
                .align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(15.dp))
        Button(onClick = {  myViewModel.updateText()
                            text.value = time.value.getCurrentSeconds()
        }
            ) {
            Text(  text = time.value.getCurrentSeconds() + " seconds " )
        }
    }
}