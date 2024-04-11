package com.example.k2024_04_09_video_svc

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.Messenger
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.k2024_04_09_video_svc.databinding.ActivityMainBinding

class VideoService : Service() {

    private lateinit var mMessenger: Messenger

    private lateinit var binding: ActivityMainBinding

    lateinit var player: ExoPlayer
    lateinit var mediaItem: MediaItem
    fun buildVideoPlayer() {
        val playerView: PlayerView = binding.root.findViewById(R.id.player_view)
        player = ExoPlayer.Builder(this).build()
        playerView.player = player
        mediaItem = MediaItem.fromUri(aStrangeVideo)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }



    inner class VideoServiceBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods
        fun getService(): VideoService {
            return this@VideoService
        }
    }

    override fun onCreate() {
        super.onCreate()

        buildVideoPlayer()
    }
    override fun onBind(intent: Intent): IBinder {
        return VideoServiceBinder()
    }
}