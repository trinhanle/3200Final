package com.example.k2023_02_28_program_fragments_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.commit
import com.example.k2023_02_28_program_fragments_viewmodel.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding:  ActivityMainBinding

    private var myValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container, OneFragment())
                //add<OneFragment>(R.id.fragment_one)
            }
        }

        binding.fragmentTwo.setOnClickListener {
            myValue += 1
            binding.myVarValue.setText(myValue.toString())
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container, TwoFragment())
            }
            Toast.makeText(this, "Fragment TWO", Toast.LENGTH_SHORT).show()
        }

        binding.fragmentOne.setOnClickListener {
            myValue += 1
            binding.textView.setText(myValue.toString())
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container, OneFragment())
            }
                Toast.makeText(this, "Fragment ONE", Toast.LENGTH_SHORT).show()
        }
    }
}