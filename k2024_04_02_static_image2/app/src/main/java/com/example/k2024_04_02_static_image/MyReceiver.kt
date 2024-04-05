package com.example.k2024_04_02_static_image

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var actionString:String = intent.action.toString()

        String d = i.getStringExtra("me.pgb.a2021_03_16a_breceiver.SEND_MESSAGE");​

        Log.i(TAG, "onReceive: " + actionString + " and " + data);​
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        TODO("MyReceiver.onReceive() is not implemented")
    }
}