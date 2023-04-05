package com.example.k2023_03_21_simple_thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.k2023_03_21_simple_thread.databinding.ActivityMainBinding
import java.lang.Thread.sleep

import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myThread: MyThread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var myThread = MyThread()

        binding.threadButton.setOnClickListener {
            Log.i("BUTTON - start", "NOT yet in THREAD")
            if (! myThread.isAlive) {
                myThread = MyThread()
                myThread.start()
            }
        }

        /*
         * UI-thread debounce with co-routine not a good idea
         */
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