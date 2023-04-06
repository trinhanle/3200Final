package com.example.k2023_04_06_basic_service.services

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log
import android.widget.Toast

class BackgroundService : Service() {

    private lateinit var serviceLooper: Looper
    private lateinit var serviceHandler: ServiceHandler

    private var binder: IBinder? = null        // interface for clients that bind
    private var allowRebind: Boolean = false

    private inner class ServiceHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            try {
                Thread.sleep(5000)
                Log.i("BASIC-SERVICE","Handle message")
            } catch(e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
            stopSelf(msg.arg1) // keep thread alive until service is done
        }
    }

    override fun onCreate() {
        HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND).apply {
            start()

            serviceLooper = looper
            serviceHandler = ServiceHandler(looper)
        }
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onUnbind(intent: Intent): Boolean {
        // All clients have unbound with unbindService()
        return allowRebind
    }

    override fun onRebind(intent: Intent) {
        // A client is binding to the service with bindService(),
        // after onUnbind() has already been called
    }


    override fun onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show()
    }
}