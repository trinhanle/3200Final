package com.example.k2024_03_06_basic_nav.models

import android.icu.util.GregorianCalendar
import java.time.LocalDateTime


class CurrentTime {
    private var ldt = LocalDateTime.now()

    fun getCurrentSeconds() : String {
        ldt = LocalDateTime.now()
        return ldt.second.toString()
    }

    fun getCurrentMinutes() : String {
        ldt = LocalDateTime.now()
        return ldt.minute.toString()
    }

    fun updateTime() {
        ldt = LocalDateTime.now()
    }

}