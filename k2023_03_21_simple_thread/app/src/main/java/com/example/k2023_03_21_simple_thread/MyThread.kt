package com.example.k2023_03_21_simple_thread

import android.util.Log

class MyThread: Thread() {
    public override fun run() {
        val time_start = System.currentTimeMillis()
        Thread.sleep(1000)
        val time_end = System.currentTimeMillis()
        val delta_time = time_end - time_start
        val threadName = name.toString()
        Log.i("In THREAD: " + threadName,
            "Run thread delay in ms:: " + delta_time.toString() )
    }
}
