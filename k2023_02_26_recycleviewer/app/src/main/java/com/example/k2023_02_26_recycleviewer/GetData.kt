package com.example.k2023_02_26_recycleviewer

import android.content.Context

class GetData(val context: Context) {
    fun getFlowerArray() : Array<String> {
        return context.resources.getStringArray(R.array.flower_array)
    }

}