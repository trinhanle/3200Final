package com.example.k2024_04_09_service_looper_handler

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Messenger
import android.util.Log
import com.example.k2024_04_09_service_looper_handler.model.TransmissionMessages


class CountingService : Service() {

    private lateinit var mMessenger: Messenger


    internal class LooperThread() : Thread() {
        var  mHandler: Handler? = null
        override fun run() {

            Looper.prepare()
            mHandler = object : Handler(Looper.myLooper()!!) {
                 override fun handleMessage(msg: Message) {
                     super.handleMessage(msg!!)
                    Log.i("PGB", "Message")

                    when (msg?.what) {
                        TransmissionMessages.MSG_SAY_HELLO.ordinal ->
                            Log.i("PGB", "Message  HELLO  YEAO!!!")

                        TransmissionMessages.MSG_SAY_BYE.ordinal ->
                            Log.i("PGB", "Message  BYE Good Day!!!")

                        else -> super.handleMessage(msg!!)
                    }
                }
            }
            Looper.loop()
        }
    }
    override fun onBind(intent: Intent): IBinder {
        mMessenger = Messenger(LooperThread().mHandler)
        return mMessenger.binder
    }
}