package com.example.k2024_04_04_countingservice

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.util.Log
import android.widget.Toast
import java.util.logging.Handler
import java.util.logging.LogRecord

private const val MSG_SAY_HELLO = 1
private const val MSG_SAY_BYE = 2

class CountingService : Service() {
    /** Command to the service to display a message.  */
    private val MSG_SAY_HELLO = 1


        /**
         * Target we publish for clients to send messages to IncomingHandler.
         */
        private lateinit var mMessenger: Messenger

        /**
         * Handler of incoming messages from clients.
         */
        internal class IncomingHandler(
            context: Context,
            private val applicationContext: Context = context.applicationContext
        ) : Handler() {
            fun handleMessage(msg: Message) {
                when (msg.what) {
                    MSG_SAY_HELLO ->
                        Toast.makeText(applicationContext, "hello!", Toast.LENGTH_SHORT).show()
                    else -> super.handleMessage(msg)
                }
            }

            override fun publish(p0: LogRecord?) {
                TODO("Not yet implemented")
            }

            override fun flush() {
                TODO("Not yet implemented")
            }

            override fun close() {
                TODO("Not yet implemented")
            }
        }

        /**
         * When binding to the service, we return an interface to our messenger
         * for sending messages to the service.
         */
        override fun onBind(intent: Intent): IBinder? {
            Toast.makeText(applicationContext, "binding", Toast.LENGTH_SHORT).show()
            mMessenger = Messenger(IncomingHandler(this))
            return mMessenger.binder
        }
    }

private fun Handler.handleMessage(msg: Message) {

}
