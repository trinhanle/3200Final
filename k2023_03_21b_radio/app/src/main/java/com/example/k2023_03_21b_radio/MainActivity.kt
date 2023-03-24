package com.example.k2023_03_21b_radio

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.net.VpnService.prepare
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k2023_03_21b_radio.databinding.ActivityMainBinding
import java.net.URI

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var binding: ActivityMainBinding
    private var myUri =  "http://stream.whus.org:8000/whusfm"
    private var yourUri = "https://0n-classicrock.radionetz.de/0n-classicrock.mp3"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.onButton.setOnClickListener {
            setUpRadio(myUri)
        }

        binding.pauseButton.setOnClickListener {
            mediaPlayer?.pause()
        }

        binding.stopButton.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }

        binding.toggleStationButton.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null

            setUpRadio(yourUri)
        }
    }

    private fun setUpRadio(uri: String) {
        mediaPlayer = MediaPlayer().apply {
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
}