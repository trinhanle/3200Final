package com.example.k2024_04_16_volley_quiz_server

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.volley.Request
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.k2024_04_16_volley_quiz_server.databinding.ActivityMainBinding
import com.example.k2024_04_16_volley_quiz_server.models.questions.Question
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var getDataButton: Button
    private lateinit var getImageButton: Button
    private lateinit var basicQuestionView: TextView
    private lateinit var imageView: ImageView

    private var gson = Gson()

    val urlJSON = "http://192.168.163.1:8080/questions";
    val urlIMAGE = "http://192.168.163.1:8080/static/stamford_harbor.jpg";

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val queue = Volley.newRequestQueue(this)

        getDataButton = findViewById(R.id.get_data_button)
        getImageButton = findViewById(R.id.image_button)
        basicQuestionView = findViewById(R.id.basic_question_view)
        imageView = findViewById(R.id.imageView)

        getDataButton.setOnClickListener {
            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                urlJSON,
                null,
                { response ->
                    // Display the first 500 characters of the response string.
                    basicQuestionView.setText("Response is: ${response}")

                    var questionList: List<Question> = gson.fromJson(response.toString(), Array<Question>::class.java ).toList()
                },
                { error ->  basicQuestionView.text = "Error: ${error}" })

            queue.add(jsonArrayRequest)
        }

        getImageButton.setOnClickListener {

            val imageRequest = ImageRequest(
                urlIMAGE,
                { response: Bitmap ->
                    // Display the first 500 characters of the response string.
                    imageView.setImageBitmap(response)
                },
                0,0,
                ImageView.ScaleType.CENTER_CROP, Bitmap.Config.RGB_565,

                { error ->  basicQuestionView.text = "Error: ${error}" })

            queue.add(imageRequest)
        }
    }
}
