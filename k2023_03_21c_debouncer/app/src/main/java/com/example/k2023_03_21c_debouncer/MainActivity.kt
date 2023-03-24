package com.example.k2023_03_21c_debouncer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.k2023_03_21c_debouncer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var intervalInMilliseconds: Long = 1500
    private var millisecondsLastClick = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.debouncedButton.setOnClickListener {
            var time = System.currentTimeMillis()

            if (time - millisecondsLastClick > intervalInMilliseconds) {
                millisecondsLastClick = time
                Log.i("BUTTON", "CLICK RECOGNIZED")
                //Toast.makeText(this,"BUTTON selection noticed", Toast.LENGTH_SHORT).show()
            }
        }

        binding.debounce2Button.setOnClickListener {
            var looperThread = LooperThread()

        }

    }
}