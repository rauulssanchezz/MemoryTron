package com.example.memorytron

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        if (resultado.equals("Eres Admin")){
            fondo.setBackgroundResource(R.drawable.admin)
            texto.text="Eres Admin"
            mediaPlayer= MediaPlayer.create(this,R.raw.ganador)
            mediaPlayer?.start()

        }else{
            fondo.setBackgroundResource(R.drawable.perdiste)
            texto.text="Cagaste"
            mediaPlayer= MediaPlayer.create(this,R.raw.perdiste)
            mediaPlayer?.start()
        }
        var resultados=findViewById<TextView>(R.id.info)
        Thread.sleep(200)
        resultados.visibility=View.VISIBLE
    }
    override fun onBackPressed() {
        mediaPlayer?.stop()
        var intent=Intent(this,Juego::class.java)
        startActivity(intent)
        super.onBackPressed()
    }

    fun reiniciar(view: View) {
        var intent=Intent(this,Juego::class.java)
        mediaPlayer?.stop()
        startActivity(intent)
    }
    override fun onStop() {
        mediaPlayer?.stop()
        super.onStop()
    }

}