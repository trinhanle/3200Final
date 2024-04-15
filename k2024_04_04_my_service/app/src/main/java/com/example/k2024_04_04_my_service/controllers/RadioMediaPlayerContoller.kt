package com.example.k2024_04_04_my_service.controllers

import android.media.AudioAttributes
import android.media.MediaPlayer
import com.example.k2024_04_04_my_service.models.RadioState


const val url = "http://stream.whus.org:8000/whusfm"


class RadioMediaPlayerController {

    private lateinit var radioState: RadioState
    private var mediaPlayer: MediaPlayer? = null

    fun bindMediaPlayer(myMediaPlayer: MediaPlayer) {
        radioState = RadioState(prepared = false, running = false)
        mediaPlayer = myMediaPlayer
    }

    fun setUpMediaPlayer() {
        mediaPlayer?.apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
        }
    }

    fun setUrl() {
        mediaPlayer?.apply {
            setDataSource(url)
        }
    }

    fun prepareMediaPlayer() {
        if (!radioState.prepared && !radioState.running) {
            mediaPlayer?.apply {
                prepare()
            }
        }
        radioState.prepared = true
        radioState.running = true
    }

    fun startMediaPlayer() {
        if (!radioState.prepared && !radioState.running) {
            mediaPlayer?.apply {
                start()
            }
        }
        radioState.prepared = true
        radioState.running = true
    }

    fun pauseMediaPlayer() {
        if (radioState.running) {
            mediaPlayer?.apply {
                pause()
            }
        }
        radioState.running = false
    }

    fun stopAndDestroyMediaPlayer() {
        if (radioState.running) {
            mediaPlayer?.apply {
                stop()
            }
            mediaPlayer = null

            radioState.running = false
            radioState.prepared = false
        }
    }
}