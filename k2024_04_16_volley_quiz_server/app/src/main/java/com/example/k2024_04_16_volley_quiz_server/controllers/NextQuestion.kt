package com.example.k2024_04_16_volley_quiz_server.controllers

import java.util.*
import com.example.k2024_04_16_volley_quiz_server.models.questions.AllQuestions


class NextQuestion {

    private val allQestions: AllQuestions = AllQuestions()

    private var question: Int = 0
    //private val total_qs: Int = allQestions.size


    public fun linearNextQuestion(): Int {
        //question = (question+1) % total_qs
        //return allQestions.allQuestions[question].index
        return 1
    }

    public fun pseudoRandomNextQuestion(): Int {
        val random = Random()
        //question = random.nextInt(total_qs)

        //return allQestions.allQuestions[question].index
        return 1
    }




}