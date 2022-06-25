package com.qdf.qualidf
import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import org.jsoup.Jsoup
import android.view.View
import android.widget.*
import org.json.*
class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)




        val status_login = findViewById<TextView>(R.id.status_login)

        val entrar_but = findViewById<Button>(R.id.ENVIAR_BT)
        val cpftext = findViewById<EditText>(R.id.CPF_L)
        val passwordtxt = findViewById<EditText>(R.id.SENHA_L)




        entrar_but.setOnClickListener {
            try {
                val document = Jsoup.connect("https://appqualit.000webhostapp.com/data_consulta.php?quero=password&key=${cpftext.text}").ignoreContentType(true).get()
                val password = document.text().toString()

                if(passwordtxt.text.length>1){
                    Toast.makeText(this, "$password", Toast.LENGTH_SHORT).show()
                    if(passwordtxt.text.toString()==password) {

                        intent = Intent(this, perfil::class.java)
                        val cpf = cpftext.text.toString()
                        intent.putExtra("cpf", cpf)
                        startActivity(intent)
                    }else{

                        Toast.makeText(this, "SENHA OU USUARIO INCORRETOS", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                println(e)
                Toast.makeText(this, ":$e", Toast.LENGTH_SHORT).show()
            }
        } //ONCLICK


        val esqueceu_senha = findViewById(R.id.LINKESQUECI) as TextView

        esqueceu_senha.setOnClickListener{
            startActivity(Intent(this, esqueceu_email::class.java))
        }

        val cadastrobutton = findViewById(R.id.cadastrobutton) as TextView

        cadastrobutton.setOnClickListener{
            startActivity(Intent(this, cadastro::class.java))
        }

        val back = findViewById(R.id.back) as ImageView

        back.setOnClickListener {
            finish()
        }
    }


}//APPCOMPAT







