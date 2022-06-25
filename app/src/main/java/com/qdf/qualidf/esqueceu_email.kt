package com.qdf.qualidf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class esqueceu_email : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_esqueceu_email)



        val back = findViewById(R.id.back) as ImageView

        back.setOnClickListener {
            finish()
        }
    }
}