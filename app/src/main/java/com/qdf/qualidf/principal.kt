package com.qdf.qualidf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)


        val b_estudante = findViewById(R.id.btn_estudante) as Button
        val b_professor = findViewById(R.id.btn_professor) as Button
        val b_saiba = findViewById(R.id.saiba) as TextView

        b_estudante.setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }
        b_professor.setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }
        b_saiba.setOnClickListener {
            Toast.makeText(this, "...", Toast.LENGTH_SHORT).show()
        }


        //Fim
    }


}