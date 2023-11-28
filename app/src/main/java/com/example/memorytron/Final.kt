package com.example.memorytron

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Final : AppCompatActivity() {

    var mediaPlayer:MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        var resultado=intent.getStringExtra("resultado").toString()

        var fondo = findViewById<ConstraintLayout>(R.id.background)

        var texto=findViewById<TextView>(R.id.texto)

        var nombrePaquete = getApplicationContext().getPackageName()
        mediaPlayer= MediaPlayer.create(this,R.raw.ganador)
        if (resultado.equals("Eres Admin")){
            fondo.setBackgroundResource(R.drawable.admin)
            texto.text="Eres Admin"
            mediaPlayer?.start()

        }else{
            fondo.setBackgroundResource(R.drawable.perdiste)
            texto.text="Cagaste"
        }
    }
}