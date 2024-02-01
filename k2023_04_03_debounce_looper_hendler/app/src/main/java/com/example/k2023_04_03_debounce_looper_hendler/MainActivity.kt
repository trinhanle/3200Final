package com.example.k2023_04_03_debounce_looper_hendler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import com.example.k2023_04_03_debounce_looper_hendler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myLooperThread: LooperThread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myLooperThread = LooperThread()
        myLooperThread.start()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* */
        var msg = Message()
        msg.obj = binding.viewText
        val MSG_NUMBER = 9
        msg.what = MSG_NUMBER

        /* */
        var count = 0

        binding.message1Button.setOnClickListener {

            msg.arg1 += -9

            myLooperThread.mHandler.handleMessage(msg)
        }

        binding.message2Button.setOnClickListener {

            count += 100
            msg.arg1 = count

            val message = Message.obtain(msg)
            message.what = MSG_NUMBER +1
            myLooperThread.mHandler.removeMessages(MSG_NUMBER)

            message.what = MSG_NUMBER
            //myLooperThread.mHandler.handleMessage(msg)
            myLooperThread.mHandler.sendMessageDelayed(message,1000)
            Log.i("PGB", "Asynch")
        }

        /*
         count += 100
            msg.arg1 = count
            val msg_new = Message.obtain(msg)
            msg_new.what = MSG_NUMBER+1
            myLooperThread.mHandler.removeMessages(MSG_NUMBER)
            msg_new.what = MSG_NUMBER
            val message = myLooperThread.mHandler.obtainMessage(MSG_NUMBER)
            //myLooperThread.mHandler.handleMessage(msg)
            myLooperThread.mHandler.sendMessageDelayed(message,1000)
            Log.i("PGB", "Asynch")
         */

    }
}