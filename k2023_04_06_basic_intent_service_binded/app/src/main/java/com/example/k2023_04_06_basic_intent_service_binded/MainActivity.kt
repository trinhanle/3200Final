package com.example.k2023_04_06_basic_intent_service_binded

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.PersistableBundle
import android.widget.Button
import android.widget.Toast
import com.example.k2023_04_06_basic_intent_service_binded.services.CountService

class MainActivity : AppCompatActivity() {

    private lateinit var countService: CountService
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)

        button.setOnClickListener {
            val v = countService.getValue()
            Toast.makeText(this, "Hello $v", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, CountService::class.java)
        bindService(intent, connection, BIND_AUTO_CREATE)
    }


    private val connection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            val binder: CountService.LocalServiceBinder = service as CountService.LocalServiceBinder
            countService = binder.getServiceBinder()
        }
        override fun onServiceDisconnected(p0: ComponentName?) {
        }
    }
}