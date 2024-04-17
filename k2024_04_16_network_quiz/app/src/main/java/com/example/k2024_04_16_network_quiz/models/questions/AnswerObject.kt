package com.example.k2024_04_16_network_quiz.models.questions

class AnswerObject(var answerString: String, var isAnswerTrue: String) {

    private var answer = ""
    private var isTrue = ""

    fun setAnswer(aString: String) {
        answer = aString
    }
    fun getAnswer() : String {
        return answer
    }

    fun setIsTrue(bValue: String) {
        isTrue = bValue
    }
    fun getIsTrue(): String {
        return isTrue
    }

}