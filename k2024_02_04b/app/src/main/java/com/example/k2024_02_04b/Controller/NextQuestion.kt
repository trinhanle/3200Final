package com.example.k2024_02_04b.Controller

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.k2024_02_04b.model.AllQuestions
import kotlin.random.Random
import kotlin.random.asJavaRandom

class NextQuestion {

    private val myQuestions = AllQuestions()
    private val totalQuestions = myQuestions.totalQuestions()
    private val lstQuestions = myQuestions.getAllQuestions();

    companion object {
        private var question: Int = 0
    }

    public fun linearNextQuestion(): Int {
        question = (question+1) % totalQuestions
        return question
    }

    public fun pseudoRandomNextQuestion(): Int {
        question = (0..totalQuestions).random()

        return question
    }


}