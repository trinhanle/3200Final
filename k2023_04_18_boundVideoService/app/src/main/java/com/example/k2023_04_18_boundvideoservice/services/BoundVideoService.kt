package com.example.k2023_04_18_boundvideoservice.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log
import android.widget.Toast
import com.example.k2023_04_18_boundvideoservice.models.VideoCommands

class BoundVideoService : Service() {

    private lateinit var mMessenger: Messenger

    internal class IncomingHandler(
        context: Context,
        private val applicationContext: Context = context.applicationContext
    ) : Handler() {
        override fun handleMessage(msg: Message) {
            Log.i("PGB", "Message")
            when (msg.what) {
                VideoCommands.START.ordinal ->
                    Log.i("PGB", "Message  START!!")
                VideoCommands.STOP.ordinal ->
                    Log.i("PGB", "Message  STOP!!!")
                VideoCommands.PAUSE.ordinal ->
                    Log.i("PGB", "Message  PAUSE!!!")
                else -> super.handleMessage(msg)
            }
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.i("PGB", "Message  onBind")
        mMessenger = Messenger(IncomingHandler(this))
        return mMessenger.binder
    }

}