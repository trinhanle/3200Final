package com.example.k2024_04_09_service_looper_handler

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.k2024_04_09_service_looper_handler.model.TransmissionMessages
import com.example.k2024_04_09_service_looper_handler.ui.theme.K2024_04_09_service_looper_handlerTheme

class MainActivity : ComponentActivity() {

    private var messenger: Messenger? = null
    val msg: Message = Message.obtain()

    fun myFun() {
        msg.what = TransmissionMessages.MSG_SAY_HELLO.ordinal
        messenger?.send(msg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            K2024_04_09_service_looper_handlerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", myFunction = { myFun() })
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Intent(this, CountingService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    private val connection = object: ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
            messenger = Messenger(service)
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            messenger = null
        }
    }
}

@Composable
fun Greeting(name: String, myFunction: () -> Unit, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Button(onClick = { myFunction() }) {
            Text("Push button")
        }

        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    K2024_04_09_service_looper_handlerTheme {
        //Greeting("Android")
    }
}