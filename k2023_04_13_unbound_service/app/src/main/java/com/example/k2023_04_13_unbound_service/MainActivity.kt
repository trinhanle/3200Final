package com.example.k2023_04_13_unbound_service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.k2023_04_13_unbound_service.databinding.ActivityMainBinding
import com.example.k2023_04_13_unbound_service.services.RadioService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.onRadioSvcButton.setOnClickListener {
            Log.i("PGB", "Start service")
            startService(Intent(this, RadioService::class.java))
        }

        binding.offRadioSvcButton.setOnClickListener {
            stopService(Intent(this, RadioService::class.java))
        }

       /*  */
    }
}
