package com.example.k2025_02_01.model

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
