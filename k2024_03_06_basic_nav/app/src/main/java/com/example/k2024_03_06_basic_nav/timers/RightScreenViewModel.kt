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

class RightScreenViewModel : ViewModel() {

    private val _text = mutableStateOf(GregorianCalendar.getInstance().get(GregorianCalendar.SECOND).toString())
    val text: String = _text.value

    fun updateText(newText: String) {
        _text.value = newText
    }

}