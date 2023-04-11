package com.example.k2023_04_06_basic_intent_service_binded.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder



class CountService : Service() {
    private var value: Int = 0
    private var serviceBinder = LocalServiceBinder()

    override fun onBind(intent: Intent): IBinder {
        return serviceBinder
    }

    fun getValue() : Int {
        //Thread.sleep(1000)
        value = value.plus(1)
        return value
    }

    inner class LocalServiceBinder : Binder() {
        fun getServiceBinder(): CountService = this@CountService
    }
}
