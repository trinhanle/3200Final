package com.example.k2023_03_28_simplelooperhandler

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.TextView

class LooperThread() : Thread("Custom Thread") {
    var TAG = "LOOPER_THREAD"
    lateinit var mHandler: Handler
    override fun run() {
        Looper.prepare()
        mHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                Log.d(TAG, "Looper name " + looper.thread.name)
                msg.arg1 += 3
                val textView = msg.obj as TextView
                textView.setText("Hello: " + msg.arg1.toString())
                looper.thread.interrupt()
            }
        }
        Looper.loop()
    }
}