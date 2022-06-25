package com.qdf.qualidf

import android.webkit.WebView
import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.*
import com.squareup.picasso.Picasso
import android.view.Window
import android.webkit.WebViewClient
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.qdf.qualidf.R.id.botLayout
import com.qdf.qualidf.R.id.tvTitle
import org.jsoup.Jsoup

class perfil : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val cpf = intent.getStringExtra("cpf").toString()

        val nome = Jsoup.connect("https://appqualit.000webhostapp.com/data_consulta.php?quero=nome&key=$cpf").ignoreContentType(true).get().text().toString()
        val profileimage = Jsoup.connect("https://appqualit.000webhostapp.com/data_consulta.php?quero=profile&key=$cpf").ignoreContentType(true).get().text().toString()


        val profilelayout = findViewById(R.id.profilep) as ImageView
        Picasso.with(this).load(profileimage).resize(60, 80).centerCrop().into(profilelayout);

        val username = findViewById(R.id.NOMEUSER) as TextView
        val usercpf = findViewById(R.id.CPFUSER) as TextView
        username.text = nome
        usercpf.text = cpf

        val wv = findViewById(R.id.webviewmaps) as WebView
        wv.webViewClient = WebViewClient()
        wv.loadUrl("https://www.google.com/maps/place/Setor+Comercial+Sul+Q.+4+-+Asa+Sul,+Bras%C3%ADlia+-+DF,+70297-400/@-15.7975531,-47.8889947,19z/data=!4m5!3m4!1s0x935a3ae6e10e9889:0x503b33cda98e1cb3!8m2!3d-15.7975531!4d-47.8886078")
        wv.settings.javaScriptEnabled = true

        wv.settings.setSupportZoom(false)


        val logout = findViewById(R.id.logout_im) as ImageView


        logout.setOnClickListener {
            CustomDialogClass(this, "DESEJA SAIR?", "Clique em Sair para Deslogar!").show()

        }

        val botL = findViewById(botLayout) as BottomNavigationView
        botL.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_profile -> {
                    Toast.makeText(this, "PERFIL", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_turmas -> {

                }
                R.id.nav_home -> {

                }
                R.id.nav_calen -> {

                }
                R.id.nav_duvi -> {

                }
            }
            true
        }

    }



}









class CustomDialogClass(context: Context, titleDialog: String, messageDialog: String) : Dialog(context) {

    init {
        setCancelable(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_ok)
        val title_dialog = findViewById(tvTitle) as TextView
        title_dialog.setOnClickListener {

        }

    }



}