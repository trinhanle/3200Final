package com.example.k2024_02_06_quiz_start.controller

import com.example.k2024_02_06_quiz_start.model.Difficulty
import com.example.k2024_02_06_quiz_start.model.Score

class ScoreController(val name: String) {

    private val score = Score()
    fun incrementScore(difficulty: Difficulty) {
        var changeScore : Double = 0.0
        when(difficulty) {
            Difficulty.EASY -> changeScore = changeScore+1
            Difficulty.MEDIUM -> changeScore = changeScore+2
            else ->
                changeScore = changeScore+3
        }
        score.incrementScore(changeScore)
    }

    fun getScore(): Double {
        return score.getScore()
    }
}
