package com.example.k2024_04_16_volley_quiz_server.models.questions

import android.util.Log

class Question {
    private var answers: AnswerList = AnswerList(emptyList())
    private var question: String = ""
    private var imageName: String = ""

    override fun toString(): String {
        return question + " image " + imageName
    }

    fun setAnswers(aList: AnswerList) {
        answers = aList
    }

    fun getAnswers() : AnswerList {
        return answers
    }

    fun setQuestion(qString: String) {
        question = qString
    }
    fun getQuestion() : String {
        return question
    }

    fun setImageName(iName: String) {
        imageName = iName
    }
    fun getImageName() : String {
        return imageName
    }

    fun numberOfAnswers() : Int {
        return answers.numberOfAnswers()
    }
}