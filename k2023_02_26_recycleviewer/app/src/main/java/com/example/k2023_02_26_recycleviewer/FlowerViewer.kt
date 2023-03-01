package com.example.k2023_02_26_recycleviewer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class FlowerViewer(private val flower_array: Array<String>)  : RecyclerView.Adapter<FlowerViewer.FlowerViewHolder>() {

    class FlowerViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val flowerTextHolder: TextView = itemView.findViewById(R.id.flower_text)

        init { itemView.setOnClickListener(this) }

        fun bind(word: String) {
            flowerTextHolder.text = word
        }

        override fun onClick(v: View?) {
            v?.setOnClickListener{
                Toast.makeText(itemView.context,"Clicked: " + flowerTextHolder.text.toString(),
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.flower_layout, parent, false)

        return FlowerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return flower_array.size
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.bind(flower_array[position])
    }
}