package com.example.myfirstactivity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MyFirstActivity: Activity() {
    lateinit var contador : TextView
    lateinit var btnContador : Button
    var i = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //En cada estado que ejecutemos, se tiene que poner este super obligatoriamente

        setContentView(R.layout.activity_my_first) //Enlaza nuestra vista (layout xml). R = recursos, layout = carpeta
        btnContador = findViewById(R.id.btnContador)
        contador = findViewById(R.id.contador)

    }

    override fun onResume() {
        super.onResume()

        // TODO mandar mensaje
        //Toast.makeText(this, "Hola", Toast.LENGTH_LONG).show()
        /**val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.google.com/")
        startActivity(intent)**/

        //val intent = Intent(this, MySecondActivity::class.java)
        //startActivity(intent
        btnContador.setOnClickListener { addNumber() }
    }

    fun addNumber(){
        i++;
        contador.setText(i.toString())
    }
}