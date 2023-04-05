package com.example.k2023_04__04_basic_service

import android.app.Service
import android.content.Intent
import android.os.*
import android.view.View.OnCreateContextMenuListener
import android.widget.Toast

class BasicService : Service() {
    private lateinit var myLooper: Looper
    private lateinit var myHandler: Handler

    override fun onBind(intent: Intent?): IBinder? {
        //TODO("Not yet implemented")
        return null
    }

    private inner class ServiceHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
            stopSelf(msg.arg1)
        }
    }

    override fun onCreate() {
        HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND).apply {
            start()

            // Get the HandlerThread's Looper and use it for our Handler
            myLooper = looper
            myHandler = ServiceHandler(looper)
        }
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show()

        myHandler?.obtainMessage()?.also { msg ->
            msg.arg1 = startId
            myHandler?.sendMessage(msg)
        }

        return START_STICKY
    }

    override fun onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show()
    }

}