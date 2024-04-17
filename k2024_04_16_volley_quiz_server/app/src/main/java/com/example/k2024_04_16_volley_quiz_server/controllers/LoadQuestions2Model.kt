package com.example.k2024_04_16_volley_quiz_server.controllers


import com.example.k2024_04_16_volley_quiz_server.models.questions.AllQuestions
import com.example.k2024_04_16_volley_quiz_server.models.questions.Question
import com.google.gson.Gson

class LoadQuestion2Model(question: Question) {

    var gson: Gson = Gson()



    var allQuestions: AllQuestions = AllQuestions()

}