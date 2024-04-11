package com.example.k2024_04_11_basic_service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Messenger
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

class MyService : Service() {

    private lateinit var mMessenger: Messenger
    private lateinit var mHandler: Handler
    init {
        Thread("Custom Thread") {
            var TAG = "LOOPER_THREAD"

            override fun run() {
                Looper.prepare()
                mHandler = object : Handler(Looper.getMainLooper()) {
                    override fun handleMessage(msg: Message) {
                        Log.d(TAG, "Looper name " + looper.thread.name)
                        msg.arg1 += 3
                        //val textView = msg.obj as TextView
                        //textView.setText("Hello: " + msg.arg1.toString())
                        looper.thread.interrupt()
                    }
                }
                Looper.loop()
            }
        }
    }


    override fun onBind(intent: Intent): IBinder {
        mMessenger = Messenger(mHandler)
        return mMessenger.binder
    }
}