package com.example.k2025_02_01.model

class AllQuestions {

    public val allQuestions = arrayOf(
        Question<Boolean>("Jupiter is the largest planet in our solar system", true, Difficulty.MEDIUM),
        Question<Boolean>("Saturn is the largest planet in our solar system",false,Difficulty.MEDIUM),
        Question<Int>("What year was the United States born?",1776,Difficulty.EASY),
        Question<Int>("What year was UConn founded?",1881,Difficulty.MEDIUM),
        Question<String>("The highest award in computing is named after Alan T_____ ", "Turing", Difficulty.EASY),
        Question<String>("What is the capital of Connecticut?","Hartford", Difficulty.EASY)
    )

    fun totalQuestions() : Int {
        return allQuestions.size
    }
}