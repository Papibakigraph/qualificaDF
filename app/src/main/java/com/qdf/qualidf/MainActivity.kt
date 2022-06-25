package com.qdf.qualidf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splashInit()


    }

    private fun splashInit() {
        Handler().postDelayed({
            startActivity(Intent(this, principal::class.java))
        }, 5000)
    }

}