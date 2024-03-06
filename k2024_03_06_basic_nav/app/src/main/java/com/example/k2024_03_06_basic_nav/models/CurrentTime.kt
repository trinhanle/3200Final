package com.example.k2024_03_06_basic_nav.models

import android.icu.util.GregorianCalendar

class CurrentTime {

    private val gc = GregorianCalendar.getInstance()
    var seconds: String = gc.get(GregorianCalendar.SECOND).toString()
    var minutes: String = gc.get(GregorianCalendar.MINUTE).toString()

    fun updateTime() {
        gc.time.toString()
        seconds = gc.time.toString() // gc.get(GregorianCalendar.SECOND).toString()
        minutes = gc.time.toString() // gc.get(GregorianCalendar.MINUTE).toString()
    }
}