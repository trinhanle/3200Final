package com.example.k2023_03_28_simplelooperhandler

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

class MyThread : Thread() {
    companion object {
        @JvmField
        val TAG = "PGB_thread"
    }

    private var mHandler : MyThreadHandler? = null

    override fun run()  {
        Looper.prepare()
        mHandler = Looper.myLooper()?.let { MyThreadHandler(it) }
        Looper.loop()
    }

    public fun sendMessageToBackgroundThread(message: Message) {
        mHandler?.sendMessage(message)
    }

    private class MyThreadHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            Log.i(TAG,Thread.currentThread().name + " " + msg.toString())
        }
    }
}