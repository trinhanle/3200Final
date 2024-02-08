package com.example.k2024_02_04b.model

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
