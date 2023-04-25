package com.example.k2023_04_23_boundservicetextview.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.view.View
import android.widget.TextView
import java.util.*

class TextViewService  : Service() {
    private val binder = LocalBinder()
    private var myText: String = "Start"

    private val mGenerator = Random()

    val randomNumber: Int
        get() = mGenerator.nextInt(100)

    fun updateText(newText: String) {
        myText = newText
    }
    fun setView(myView: TextView) {
        myView.text = myText
    }

    inner class LocalBinder : Binder() {
        fun getService(): TextViewService = this@TextViewService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }
}