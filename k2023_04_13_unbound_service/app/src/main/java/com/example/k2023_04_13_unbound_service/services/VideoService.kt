package com.example.k2023_04_13_unbound_service.services

import android.app.Service
import android.content.Intent
import android.os.IBinder

class VideoService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}