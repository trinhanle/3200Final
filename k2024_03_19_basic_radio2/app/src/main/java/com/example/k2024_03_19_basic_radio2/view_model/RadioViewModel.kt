package com.example.k2024_03_19_basic_radio2.view_model

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.k2024_03_19_basic_radio2.TAG
import com.example.k2024_03_19_basic_radio2.model.RadioStations
import com.example.k2024_03_19_basic_radio2.radioStations

class RadioViewModel : ViewModel() {

    var mediaPlayer: MediaPlayer? = MediaPlayer()

    var reset = false


    fun mediaPlayerStart() {
        mediaPlayer?.start()
        Log.i(TAG,"started radio")
    }
    fun mediaPlayerSetupAndRun() {
        if (reset) {
            mediaPlayer = MediaPlayer()
        }
        mediaPlayer?.apply {
        setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build()
        )

        var str = radioStations.getNextUrl()
        Log.i(TAG,"url = $str")
        mediaPlayer?.setDataSource(str)
        mediaPlayer?.prepareAsync()

        }
    }

    fun mediaEnd() {
        mediaPlayer?.stop()
        mediaPlayer?.release()

        mediaPlayer = null

        reset = true
    }

    fun mediaPause() {
        mediaPlayer?.pause()
    }

    fun mediaRestart() {
        mediaPlayer?.start()
    }

}