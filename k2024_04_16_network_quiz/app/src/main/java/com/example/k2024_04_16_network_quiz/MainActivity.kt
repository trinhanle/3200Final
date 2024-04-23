package com.example.k2024_04_16_network_quiz

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
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
import com.example.k2024_04_16_network_quiz.databinding.ActivityMainBinding
import com.example.k2024_04_16_network_quiz.models.questions.Question
import com.example.k2024_04_16_network_quiz.models.score.ScoreViewModel
import com.google.gson.Gson


var toggle: Boolean = true
var urlJSON = "http://192.168.163.1:8080/questions"
var altUrl0 = "https://images.metmuseum.org/CRDImages/ad/original/117343.jpg"
var altUrlImage = "https://images.metmuseum.org/CRDImages/ad/original/ADA3882.jpg"
var urlIMAGE = altUrlImage


class MainActivity : AppCompatActivity() {

    private lateinit var getDataButton: Button
    private lateinit var getImageButton: Button
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    private lateinit var basicQuestionView: TextView
    private lateinit var imageView: ImageView

    private var gson = Gson()





    private lateinit var binding: ActivityMainBinding

    var scoreViewModel = viewModels<ScoreViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        getDataButton = findViewById(R.id.get_data_button)
        getImageButton = findViewById(R.id.image_button)
        basicQuestionView = findViewById(R.id.basic_question_view)
        imageView = findViewById(R.id.imageView)
        trueButton = findViewById(R.id.button_true)
        falseButton = findViewById(R.id.button_false)
        nextButton = findViewById(R.id.button_next)

        val queue = Volley.newRequestQueue(this)

        getDataButton.setOnClickListener {


            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET,
                urlJSON,
                null,
                { response ->
                    // Display the first 500 characters of the response string.


                    var questionList: List<Question> = gson.fromJson(response.toString(), Array<Question>::class.java ).toList()

                    basicQuestionView.setText(questionList[1].getQuestion())
                },
                { error ->  basicQuestionView.text = "Error: ${error}" })

            queue.add(jsonArrayRequest)

        }

        getImageButton.setOnClickListener {
            if (toggle) {
                toggle = ! toggle
                urlIMAGE = altUrl0
            } else {
                urlJSON = altUrlImage
            }

            var imageRequest = ImageRequest(
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
