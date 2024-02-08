package com.example.k2024_02_06_quiz_start

import com.example.k2024_02_06_quiz_start.controller.NextQuestion
import com.example.k2024_02_06_quiz_start.model.AllQuestions
import org.junit.Assert
import org.junit.Test

class NextQuestionTests {

    @Test
    fun getNextIncQuestionNumberTest_1() {
        val allQuestions = AllQuestions()
        val currentQuestion0 = 0

        val nextQuestion = NextQuestion()

        Assert.assertEquals(nextQuestion.getNextIncQuestionNumber(), currentQuestion0 + 1)
    }

    @Test
    fun getNextIncQuestionNumberTest_2() {
        val allQuestions = AllQuestions()
        val totalNumberOfQuestions = allQuestions.getNumberOfQuestions()
        val nextQuestion = NextQuestion()

        repeat(totalNumberOfQuestions-1, { nextQuestion.getNextIncQuestionNumber() })

        Assert.assertEquals(nextQuestion.getNextIncQuestionNumber(), 0)
    }


    @Test
    fun getNextRandomQuestionNumberTest_1() {
        val allQuestions = AllQuestions()
        val totalNumberOfQuestions = allQuestions.getNumberOfQuestions()
        val nextQuestion = NextQuestion()

        Assert.assertTrue(nextQuestion.getNextRandomQuestionNumber() in (0..totalNumberOfQuestions))
    }

}