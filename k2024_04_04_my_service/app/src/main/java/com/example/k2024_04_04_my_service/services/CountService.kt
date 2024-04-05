package com.example.k2024_04_04_my_service.services


import android.os.IBinder

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.*
import android.util.Log
import android.widget.TextView
import android.widget.Toast

private const val MSG_SAY_HELLO = 1
private const val MSG_SAY_BYE = 2

class CountingService : Service() {
    private lateinit var mMessenger: Messenger

    internal class IncomingHandler(
        context: Context,
        private val applicationContext: Context = context.applicationContext
    ) : Handler() {
        override fun handleMessage(msg: Message) {
            Log.i("PGB", "Message")

            when (msg.what) {
                MSG_SAY_HELLO ->
                    Log.i("PGB", "Message  HELLO  YEAO!!!")
                MSG_SAY_BYE ->
                    Log.i("PGB", "Message  BYE Good Day!!!")
                else -> super.handleMessage(msg)
            }
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        Toast.makeText(applicationContext, "binding", Toast.LENGTH_SHORT).show()
        mMessenger = Messenger(IncomingHandler(this))
        return mMessenger.binder
    }
}