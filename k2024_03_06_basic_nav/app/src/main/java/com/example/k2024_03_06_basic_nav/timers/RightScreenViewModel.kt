package com.example.k2024_03_06_basic_nav.timers

import android.icu.util.Calendar
import android.icu.util.GregorianCalendar
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.k2024_03_06_basic_nav.models.CurrentTime

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