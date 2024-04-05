package com.example.k2024_04_04_bound_services.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.Random


class LocalService : Service() {
    // Binder given to clients.
    private val binder = LocalBinder()

    // Random number generator.
    private val mGenerator = Random()

    /** Method for clients.  */
    val randomNumber: Int
        get() = mGenerator.nextInt(100)

    /**
     * Class used for the client Binder. Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    inner class LocalBinder : Binder() {
        // Return this instance of LocalService so clients can call public methods.
        fun getService(): LocalService = this@LocalService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }
}