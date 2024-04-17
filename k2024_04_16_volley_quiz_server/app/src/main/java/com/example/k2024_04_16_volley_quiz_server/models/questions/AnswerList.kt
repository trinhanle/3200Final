package com.example.k2024_04_16_volley_quiz_server.models.questions

class AnswerList(lst: List<AnswerObject>) {
    private var answerList = mutableListOf<AnswerObject>()

    fun numberOfAnswers() : Int {
        return answerList.size
    }

    fun setAnswerList(aList: List<AnswerObject>) {
        answerList = aList.toMutableList()
    }

    fun addAnswer(answerString: String, isTrue: String) {
        answerList.add(AnswerObject(answerString,isTrue))
    }
}