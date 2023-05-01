package com.example.k2023_04_17_video

import android.widget.MediaController
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.k2023_04_17_video.databinding.ActivityMainBinding

/*
  https://developer.android.com/reference/android/widget/VideoView
 */
class MainActivity : AppCompatActivity() {

    private lateinit var bindings : ActivityMainBinding
    private val videoStream = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
    private lateinit var myMediaController: MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        bindings.videoView.setVideoURI(Uri.parse(videoStream))
        myMediaController = MediaController(this)
        myMediaController.setAnchorView(bindings.videoView)
        myMediaController.setMediaPlayer(bindings.videoView)

        bindings.onButton.setOnClickListener {
            bindings.videoView.start()
        }

        bindings.offButton.setOnClickListener {
            bindings.videoView.pause()
        }
    }
}