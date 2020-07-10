package com.example.demoproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnStart.setOnClickListener {

            startService(Intent(this, CountingService::class.java).apply {
                action = "start"
            })
        }

        btnStop.setOnClickListener {
            startService(Intent(this, CountingService::class.java).apply {
                action = "stop"
            })
        }

        btnGoToRV.setOnClickListener {
            startActivity(Intent(this, RecyclerActivity::class.java))
        }

    }
}
