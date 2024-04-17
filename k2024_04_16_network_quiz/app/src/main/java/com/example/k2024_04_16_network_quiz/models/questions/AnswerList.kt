package com.example.k2024_04_16_network_quiz.models.questions

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