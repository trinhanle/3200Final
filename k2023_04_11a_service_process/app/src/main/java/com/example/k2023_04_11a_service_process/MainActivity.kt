package com.example.k2023_04_11a_service_process

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.*
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.appcompat.view.menu.MenuWrapperICS
import com.example.k2023_04_11a_service_process.databinding.ActivityMainBinding
import com.example.k2023_04_11a_service_process.services.CountingService

private const val MSG_SAY_HELLO = 1


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var countService: CountingService
    private var  messenger: Messenger? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.countButton.setOnClickListener {
                val msg: Message = Message.obtain(null, MSG_SAY_HELLO, 4, -5)
                try {
                    Log.i("PGB", "SEND Message")
                    messenger?.send(msg)
                } catch (e: RemoteException) {
                    Log.i("PGB", "REMOPTE Exception")
                    e.printStackTrace()
                }
                //val v = countService.getValue()
                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
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