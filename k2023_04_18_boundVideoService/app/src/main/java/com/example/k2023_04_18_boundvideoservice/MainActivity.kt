package com.example.k2023_04_18_boundvideoservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import com.example.k2023_04_18_boundvideoservice.databinding.ActivityMainBinding
import com.example.k2023_04_18_boundvideoservice.models.VideoCommands
import com.example.k2023_04_18_boundvideoservice.services.BoundVideoService

class MainActivity : AppCompatActivity() {

    private lateinit var bindings: ActivityMainBinding
    private var  messenger: Messenger? =  null
    private lateinit var msg: Message

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)

        bindings.startButton.setOnClickListener {
            msg = Message.obtain(null, VideoCommands.START.ordinal, 4, -5)
            messenger?.send(msg)
            msg.recycle()
        }

        bindings.stopButton.setOnClickListener {
            msg = Message.obtain(null, VideoCommands.STOP.ordinal, 4, -5)
            messenger?.send(msg)
            msg.recycle()
        }

    }

    override fun onStart() {
        super.onStart()
        Intent(this, BoundVideoService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    private val connection = object: ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            messenger = Messenger(service)
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            messenger = null // Not ideal
        }
    }
}