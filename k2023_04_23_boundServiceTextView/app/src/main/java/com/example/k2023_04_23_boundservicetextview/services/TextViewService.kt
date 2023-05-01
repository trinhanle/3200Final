package com.example.k2023_04_23_boundservicetextview.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Binder
import android.os.IBinder
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import java.util.*

class TextViewService  : Service() {
    private val videoStream = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
    private lateinit var myMediaController: MediaController

    private val binder = LocalBinder()
    private var myText: String = "Start"
    //private val mediaPlayer: MediaPlayer? = null

    private val mGenerator = Random()

    fun setupMediaPlayer(videoView: VideoView) {
        videoView.setVideoURI(Uri.parse(videoStream))
        myMediaController = MediaController(this)
        myMediaController.setAnchorView(videoView)
        myMediaController.setMediaPlayer(videoView)
    }

    val randomNumber: Int
        get() = mGenerator.nextInt(100)

    fun updateText(newText: String) {
        myText = newText
    }
    fun setView(myView: TextView, videoView: VideoView) {
        myView.text = myText
        videoView.start()
    }

    inner class LocalBinder : Binder() {
        fun getService(): TextViewService = this@TextViewService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }
}