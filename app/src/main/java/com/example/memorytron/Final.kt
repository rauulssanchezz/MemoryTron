package com.example.memorytron

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Final : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)


        var resultado=intent.getStringExtra("resultado").toString()

        var fondo = findViewById<ConstraintLayout>(R.id.background)

        var texto=findViewById<TextView>(R.id.texto)

        if (resultado.equals("Eres Admin")){
            fondo.setBackgroundResource(R.drawable.admin)
            texto.text="Eres Admin"
        }else{
            fondo.setBackgroundResource(R.drawable.perdiste)
            texto.text="Cagaste"
        }
    }
}