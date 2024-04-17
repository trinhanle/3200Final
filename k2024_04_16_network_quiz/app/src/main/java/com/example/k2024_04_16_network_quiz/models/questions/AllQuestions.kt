package com.example.k2024_04_16_network_quiz.models.questions

class AllQuestions {
    private val allQuestions = mutableListOf<Question>()

    fun addQuestion(question: Question) {
        allQuestions.add(question)
    }

    fun numberOfQuestions() : Int {
        return allQuestions.size
    }
}