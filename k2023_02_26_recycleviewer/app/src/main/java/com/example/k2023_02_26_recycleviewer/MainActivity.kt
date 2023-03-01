package com.example.k2023_02_26_recycleviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.k2023_02_26_recycleviewer.R.id.recycle_viewer


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(/* layoutResID = */ R.layout.activity_main)

        val flower_array = GetData(this).getFlowerArray()
        val recyclerViewer: RecyclerView = findViewById(R.id.recycle_viewer)
        recyclerViewer.layoutManager = LinearLayoutManager(this)
        recyclerViewer.adapter = FlowerViewer(flower_array)
    }
}