package com.example.combinescreens

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
lateinit var btnFrag1 : Button
    lateinit var btnFrag2 : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = Screen1()
        val secondFragment = Screen2()
        btnFrag1 = findViewById(R.id.btnFrag1)
        btnFrag2 = findViewById(R.id.btnFrag2)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, firstFragment)
            commit()
        }

        btnFrag1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        btnFrag2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, secondFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}