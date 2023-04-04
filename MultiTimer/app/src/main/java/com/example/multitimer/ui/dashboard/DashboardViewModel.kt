package com.example.multitimer.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private var _actual_dashboard_time = MutableLiveData<Long>().apply {
        value = System.currentTimeMillis()
    }

    private var _delta_dashboard_time = MutableLiveData<Long>().apply {
        value = System.currentTimeMillis()
    }

    val real_time: LiveData<Long> = _actual_dashboard_time
    val delta_time: LiveData<Long> = _delta_dashboard_time

    fun get_elapsed_time() : Long {
       return _actual_dashboard_time.value?.minus(_delta_dashboard_time.value!!) ?: 0
    }

    fun start_timer() {
        _delta_dashboard_time.value = System.currentTimeMillis()
    }

    fun stop_timer() {

    }
}