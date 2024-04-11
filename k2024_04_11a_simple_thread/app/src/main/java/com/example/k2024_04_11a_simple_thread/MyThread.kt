package com.example.k2024_04_11a_simple_thread

import android.util.Log

class MyThread : Thread()  {
    public override fun run() {
        val time_start = System.currentTimeMillis()
        Thread.sleep(10*1000)
        val time_end = System.currentTimeMillis()
        val delta_time = time_end - time_start
        val threadName = name.toString()
        Log.i( "PGB In THREAD: " + threadName,
            "Run thread delay in ms:: " + delta_time.toString()
        )
    }
}
