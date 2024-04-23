package com.example.k2024_04_20_basic_nav_images.models

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