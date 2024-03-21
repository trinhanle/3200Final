package com.example.k2024_03_19_longer_term_storage.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class SaveMeViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private var currentIndex: Int?
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    fun setVal(x: Int) {
        currentIndex = x
    }

    fun getVal(): Int? {
        return currentIndex
    }
}