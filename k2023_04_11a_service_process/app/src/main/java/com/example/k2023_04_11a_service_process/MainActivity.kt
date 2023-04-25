package com.example.k2023_04_11a_service_process

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.appcompat.view.menu.MenuWrapperICS
import com.example.k2023_04_11a_service_process.databinding.ActivityMainBinding
import com.example.k2023_04_11a_service_process.services.CountingService

private const val MSG_SAY_HELLO = 1
private const val MSG_SAY_BYE = 2


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var  messenger: Messenger? =  null
    private var toggle: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.countButton.setOnClickListener {
                val msg: Message?

                if (toggle) {
                    msg = Message.obtain(null, MSG_SAY_HELLO, 4, -5)
                } else {
                    msg = Message.obtain(null, MSG_SAY_BYE, 4, -5)
                }
                toggle = !toggle

                try {
                    Log.i("PGB", "SEND Message")
                    messenger?.send(msg)
                } catch (e: RemoteException) {
                    Log.i("PGB", "REMOTE Exception")
                    e.printStackTrace()
                }
                //val v = countService.getValue()
                Toast.makeText(this, "Hello ", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onStart() {
            super.onStart()
            Intent(this, CountingService::class.java).also { intent ->
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