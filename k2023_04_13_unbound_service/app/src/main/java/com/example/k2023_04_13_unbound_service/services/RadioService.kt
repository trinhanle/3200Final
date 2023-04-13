package com.example.k2023_04_13_unbound_service.services

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.provider.Settings
import android.util.Log

class RadioService : Service() {

    private lateinit var player: MediaPlayer
    private var myUri =  "http://stream.whus.org:8000/whusfm"

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        /*
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player.setLooping(true)
         */
        Log.i("PGB", "HERE")
       setUpRadio(myUri)

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()

        player.stop()
        player.release()
    }

    private fun setUpRadio(uri: String) {
        player = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(applicationContext, Uri.parse(uri))
            prepare()
            start()
        }
    }

    /* */
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

}