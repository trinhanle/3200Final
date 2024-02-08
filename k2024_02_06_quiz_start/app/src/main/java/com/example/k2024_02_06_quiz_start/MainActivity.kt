package com.example.k2024_02_06_quiz_start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.k2024_02_06_quiz_start.controller.NextQuestion
import com.example.k2024_02_06_quiz_start.model.AllQuestions
import com.example.k2024_02_06_quiz_start.ui.theme.K2024_02_06_quiz_startTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            K2024_02_06_quiz_startTheme {
                Column {
                    Text("Welcome to our quiz app")
                    QuizComponent()
                }
            }
        }
    }
}

@Composable
fun QuizComponent() {
    val allQuestions = AllQuestions()
    val nextQuestion = NextQuestion()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var questionNumber by remember { mutableStateOf(0) }
        var question by remember {
            mutableStateOf(allQuestions.getQuestion(questionNumber).questionText)
        }

        Text(question)
        Row() {
            Button(onClick = { question = "True" }) {
                Text("True button")
            }
            Button(onClick = { question = "False" }) {
                Text("False button")
            }
            Button(onClick = {
                questionNumber = nextQuestion.getNextIncQuestionNumber()
                question = allQuestions.getQuestion(questionNumber).questionText
            }) {
                Text("Next question")
            }
        }
    }
}
