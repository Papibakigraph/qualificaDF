package com.qdf.qualidf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.collections.List as List

class cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val layoutUnidade = findViewById(R.id.unidade_spinner_cadastro) as Spinner
        val layoutTurno = findViewById(R.id.turno_spinner_cadastro) as Spinner
        val layoutCursos = findViewById(R.id.curso_spinner_cadastro) as Spinner

        val turnos = listOf<String>("Matutino", "Vespetino", "Noturno")
        val unidade = listOf<String>("CEILANDIA", "GAMA", "GUARA II", "NÚCLEO BANDEIRANTE", "PARANOÁ", "PLANALTINA", "PLANO PILOTO", "SÃO SEBASTIÃO", "SOBRADINHO")


        val turnosArray = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            turnos
        )
        val unidadeArray = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            unidade
        )

        layoutTurno.adapter = turnosArray
        layoutUnidade.adapter = unidadeArray


        val b_back = findViewById(R.id.back
        ) as ImageView
        layoutUnidade.setOnItemClickListener { parent, view, position, id ->
            println(position)
        }



        b_back.setOnClickListener {
            startActivity(Intent(this, principal::class.java))
        }

    }


}