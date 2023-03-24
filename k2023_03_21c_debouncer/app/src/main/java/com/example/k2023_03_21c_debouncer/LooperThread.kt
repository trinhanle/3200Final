package com.example.k2023_03_21c_debouncer

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import kotlinx.coroutines.delay


class LooperThread() : Thread("Custom Thread") {
    val TAG = "LOOPER"
    lateinit var mHandler: Handler
    override fun run() {
        Looper.prepare()
        mHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                sleep(1000)
                Log.i(TAG, "Looper name " + looper.thread.name)
                // Stuff
                looper.thread.interrupt()
            }
        }
        Looper.loop()
    }
}
