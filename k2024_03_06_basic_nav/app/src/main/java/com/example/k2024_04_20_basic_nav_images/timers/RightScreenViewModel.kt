package com.example.k2024_04_20_basic_nav_images.timers

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.k2024_04_20_basic_nav_images.models.CurrentTime

class RightScreenViewModel : ViewModel() {

    private val _time = mutableStateOf(CurrentTime())
    var secondsText: String = _time.value.getCurrentSeconds()
    var minutesText: String = _time.value.getCurrentMinutes()
    val time: State<CurrentTime> get() = _time

    fun updateText() {
        _time.value.updateTime()
        secondsText = _time.value.getCurrentSeconds()
        minutesText = _time.value.getCurrentMinutes()
    }

}