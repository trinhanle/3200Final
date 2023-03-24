package com.example.k2023_03_23_timer_debouncer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.k2023_03_23_timer_debouncer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var millisecondsFromLastClick: Long = 0
    private var millisecondsBetweenClicks: Long = 10000
    private var currentMilliseconds: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.timeDebouncedButton.setOnClickListener {

            currentMilliseconds = System.currentTimeMillis()

            var tempDelta = currentMilliseconds - millisecondsFromLastClick
            if (currentMilliseconds - millisecondsFromLastClick > millisecondsBetweenClicks) {
                millisecondsFromLastClick = currentMilliseconds
                Log.i("DEBOUNCER", "Button action: " + tempDelta.toString())
            } else {
                Log.i("BOUNCED", "Button BOUNCE: " + tempDelta.toString() + " should be less than: " +
                        millisecondsBetweenClicks.toString())
            }

        }
    }
}