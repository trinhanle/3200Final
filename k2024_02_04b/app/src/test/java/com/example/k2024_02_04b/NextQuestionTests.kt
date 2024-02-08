package com.example.k2024_02_04b

import com.example.k2024_02_04b.Controller.NextQuestion
import com.example.k2024_02_04b.model.AllQuestions
import org.junit.Assert
import org.junit.Test

class NextQuestionTests {

    @Test
    fun countQuestions() {
        val myQuestions = AllQuestions()
        val totalQuestions = myQuestions.totalQuestions()
        val lstQuestions = myQuestions.getAllQuestions();

        Assert.assertEquals(totalQuestions, 6)
    }

    @Test
    fun testPseudoRandomTest1() {
        val nextQuestion : NextQuestion  = NextQuestion()
        val myQuestions = AllQuestions()
        val totalQuestions =  myQuestions.totalQuestions()
        val isInDomain = nextQuestion.pseudoRandomNextQuestion()
        Assert.assertTrue(isInDomain in 0..totalQuestions);
    }

}