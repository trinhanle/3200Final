package com.example.k2023_03_02_fragment_programming.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ValueModel: ViewModel() {

    private var value: MutableLiveData<Int> = MutableLiveData()

    fun getValue() : LiveData<Int> {
        return value
    }

    fun setValue(v: Int) {
        value.value = v
    }
}