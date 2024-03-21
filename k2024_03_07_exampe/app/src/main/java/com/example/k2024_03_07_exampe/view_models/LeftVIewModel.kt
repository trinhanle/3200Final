package com.example.k2024_03_07_exampe.view_models

import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import com.example.k2024_03_07_exampe.model.Timer

class LeftVIewModel : ViewModel() {

    private  val _timer = mutableStateOf(Timer())

    val timer: State<Timer> = _timer




}