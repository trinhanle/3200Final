package com.example.k2024_04_04_my_service.services


import android.os.IBinder

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.*
import android.util.Log
import android.widget.Toast
import com.example.k2024_04_04_my_service.controllers.RadioMediaPlayerController
import com.example.k2024_04_04_my_service.models.RadioButtonCommands
import com.example.k2024_04_04_my_service.models.RadioState

private const val MSG_SAY_HELLO = 1
private const val MSG_SAY_BYE = 2

class RadioService : Service() {
    private lateinit var mMessenger: Messenger
    lateinit var  mediaPlayer: MediaPlayer
    lateinit var radioMediaPlayerController: RadioMediaPlayerController

    override fun onCreate() {
        super.onCreate()

        mediaPlayer = MediaPlayer()
        radioMediaPlayerController = RadioMediaPlayerController()
        radioMediaPlayerController.bindMediaPlayer(mediaPlayer)
    }

    override fun onBind(intent: Intent): IBinder? {
        mMessenger = Messenger(IncomingHandler(radioMediaPlayerController,this))
        return mMessenger.binder
    }

    inner class LocalBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods
        fun getService(): RadioService {
            return this@RadioService
        }
    }

    companion object {
        class IncomingHandler(
            private val radioMediaPlayerController: RadioMediaPlayerController,
            context: Context,
            applicationContext: Context = context.applicationContext
        ) : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                Log.i("PGB", "Message")

                msg.arg1++;

                when (msg.what) {
                    RadioButtonCommands.RADIO_ON.ordinal -> {
                        Log.i("PGB", " RADIO_ON")
                        radioMediaPlayerController.setUpMediaPlayer()
                        radioMediaPlayerController.setUrl()
                        radioMediaPlayerController.prepareMediaPlayer()
                        radioMediaPlayerController.startMediaPlayer()
                    }
                    RadioButtonCommands.RADIO_PAUSE.ordinal -> {
                        Log.i("PGB", " RADIO_PAUSE")
                        radioMediaPlayerController.pauseMediaPlayer()
                    }
                    RadioButtonCommands.RADIO_OFF.ordinal -> {
                        Log.i("PGB", " RADIO_OFF")
                        radioMediaPlayerController.stopAndDestroyMediaPlayer()
                    }
                    else -> super.handleMessage(msg)
                }
            }
        }
    }
}