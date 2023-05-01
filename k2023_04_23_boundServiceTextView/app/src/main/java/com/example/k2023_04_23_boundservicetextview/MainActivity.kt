package com.example.k2023_04_23_boundservicetextview

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import com.example.k2023_04_23_boundservicetextview.services.TextViewService

class MainActivity : AppCompatActivity() {
    private lateinit var mService: TextViewService
    private var mBound: Boolean = false
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var videoView: VideoView

    /** Defines callbacks for service binding, passed to bindService().  */
    private val connection = object : ServiceConnection {

        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as TextViewService.LocalBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.message_button)
        textView = findViewById(R.id.myView)
        videoView = findViewById(R.id.videoView)


        button.setOnClickListener {
            mService.setupMediaPlayer(videoView)
            val num: Int = mService.randomNumber
            mService.updateText("New value $num")
            mService.setView(textView, videoView)
            Toast.makeText(this, "number: $num", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Intent(this, TextViewService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        mBound = false
    }
}