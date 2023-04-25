package com.example.k2023_04_18_boundvideoservice.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.*
import android.util.Log
import android.widget.Toast
import com.example.k2023_04_18_boundvideoservice.models.VideoCommands
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.LoopingMediaSource
import com.google.android.exoplayer2.upstream.DataSpec
import com.google.android.exoplayer2.upstream.RawResourceDataSource

class BoundVideoService : Service() {

    private lateinit var mMessenger: Messenger
    //private lateinit var exoPlayer: ExoPlayer
    private lateinit var mediaPlayer: MediaPlayer

    val myUri = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"

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

        loadExampleMedia()
        return mMessenger.binder
    }

    private fun loadExampleMedia() {
        
    }

}