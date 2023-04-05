package com.example.k2023_04_03_debounce_looper_hendler

import android.os.Looper
import android.os.Message
import  android.os.Handler
import android.widget.TextView

class LooperThread : Thread("Looper thread") {
    private var TAG = "LOOPER-THREAD"

    lateinit var mHandler: Handler
    override fun run() {
        Looper.prepare()
        mHandler = object: Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                msg.arg1 += 3
                val textView = msg.obj as TextView
                textView.setText("CSE3200 UConn Won:" + msg.arg1.toString())
                //looper.thread.
                looper.thread.interrupt()
            }
        }
        Looper.loop()
    }
}