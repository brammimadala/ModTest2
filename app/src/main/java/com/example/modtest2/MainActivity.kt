package com.example.modtest2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.navmodtest.DashboardActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn =  findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            startActivity((Intent(this, DashboardActivity::class.java)))
        }
    }
}