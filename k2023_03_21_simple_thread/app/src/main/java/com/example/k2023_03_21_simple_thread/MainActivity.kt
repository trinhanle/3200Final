package com.example.k2023_03_21_simple_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.k2023_03_21_simple_thread.databinding.ActivityMainBinding
import java.lang.Thread.sleep

import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.threadButton.setOnClickListener {
            Log.i("BUTTON - start", "NOT yet in THREAD")
            val t = MyThread()
            t.start()
        }

        binding.corDebouncerButton.setOnClickListener {
            runBlocking {
                launch {
                    delay(1000L)
                    Log.i("COROUTINE", "Executing button press")
                }
                Log.i("Past COROUTINE", "After with button press")
            }
        }
    }
}