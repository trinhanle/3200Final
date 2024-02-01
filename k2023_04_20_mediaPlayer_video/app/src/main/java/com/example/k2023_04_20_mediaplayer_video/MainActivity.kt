package com.example.k2023_04_20_mediaplayer_video

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.SurfaceHolder
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.k2023_04_20_mediaplayer_video.databinding.ActivityMainBinding
import java.io.IOException


class MainActivity : AppCompatActivity(), SurfaceHolder.Callback {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var myMediaController: MediaController
    private var surfaceHolder: SurfaceHolder? = null

    private val videoStream = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer()
        myMediaController = MediaController(this)
        myMediaController.setAnchorView(binding.videoView)
        binding.videoView


        binding.videoOn.setOnClickListener {
            mediaPlayer.start()
        }

        binding.videoOff.setOnClickListener {
            mediaPlayer.stop()
        }

    }

    private fun setUpVideo(uri: String) {
        mediaPlayer = MediaPlayer().apply {
            setUpVideo(uri)
            prepare()
            start()
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        Toast.makeText(
            this@MainActivity,
            "surfaceCreated()", Toast.LENGTH_LONG
        ).show()
        //mediaPlayer = MediaPlayer()
        mediaPlayer.setDisplay(surfaceHolder)
        //mediaPlayer.setOnPreparedListener()
        try {
            mediaPlayer.setDataSource(videoStream)
            mediaPlayer.prepare()

        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(
                this@MainActivity,
                """
            something wrong!
            ${e.toString()}
            """.trimIndent(),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        TODO("Not yet implemented")
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        TODO("Not yet implemented")
    }


}