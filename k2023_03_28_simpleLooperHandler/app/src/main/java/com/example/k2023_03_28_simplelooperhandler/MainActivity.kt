package com.example.k2023_03_28_simplelooperhandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var myLooperThread: LooperThread
    private lateinit var myButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myLooperThread = LooperThread()
        myLooperThread.start()

        val myEditText = findViewById<TextView>(R.id.textMessage)
        val message: Message = Message()
        message.obj = myEditText
        message.arg1 = 9
        myButton = findViewById(R.id.button)

        myButton.setOnClickListener {
            myLooperThread.mHandler.handleMessage(message)
        }
    }
}