package com.example.k2024_04_11_simple_looper

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.TextView

class LooperThread() : Thread("My Looper Thread") {
    var TAG = "LOOPER_THREAD"
    lateinit var mHandler: Handler
    override fun run() {
        Looper.prepare()
        mHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                Log.d(TAG, "Looper name " + looper.thread.name)
                msg.arg1 += 3
                msg.obj = "IN Looper"
                looper.thread.interrupt()
            }
        }
        Looper.loop()
    }
}
