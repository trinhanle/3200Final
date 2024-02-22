package com.example.k2024_02_06_quiz_start

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.k2024_02_06_quiz_start.controller.NextQuestion
import com.example.k2024_02_06_quiz_start.controller.ScoreController
import com.example.k2024_02_06_quiz_start.model.AllQuestions
import com.example.k2024_02_06_quiz_start.model.UserIdentification
import com.example.k2024_02_06_quiz_start.ui.theme.K2024_02_06_quiz_startTheme
import com.example.k2024_02_06_quiz_start.ui.theme.Pink40

class MainActivity : ComponentActivity() {

    val name = UserIdentification()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name.setName("Alan Turing")
        setContent {
            K2024_02_06_quiz_startTheme {
                Column {
                    Text("Welcome to our quiz app")
                    QuizComponent(name.getName())
                }
            }
        }
    }
}

val cardShape = RoundedCornerShape(size = 32.dp)

@Composable
fun QuizComponent(name: String?) {
    val allQuestions = AllQuestions()
    val nextQuestion = NextQuestion()
    val score = ScoreController(name!!)

    Card(
        modifier = Modifier
            .wrapContentSize()
            .border(
                width = 2.dp,
                color = Pink40,
                shape = cardShape,
            )
            .clip(cardShape),
        colors = CardDefaults.cardColors(

        ),
    )  {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            var questionNumber by remember { mutableStateOf(0) }
            var question by remember {
                mutableStateOf(allQuestions.getQuestion(questionNumber).questionText)
            }
            var answer: Boolean by remember {
                mutableStateOf(allQuestions.getQuestion(questionNumber).answer)
            }

            Text(text = question, fontSize = 22.sp, modifier = Modifier.padding(5.dp))
            Row() {
                Button(onClick = {
                    if (answer) score.incrementScore(allQuestions.getQuestion(questionNumber).difficulty)
                }) {
                    Text("True button")
                }
                Button(onClick = { if (!answer) score.incrementScore(allQuestions.getQuestion(questionNumber).difficulty) }) {
                    Text("False button")
                }
                Button(onClick = {
                    questionNumber = nextQuestion.getNextIncQuestionNumber()
                    question = allQuestions.getQuestion(questionNumber).questionText
                }) {
                    Text("Next question")
                }
            }
            Text("Score: ${score.getScore().toString()}")
        }
    }
}

