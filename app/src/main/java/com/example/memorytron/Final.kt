package com.example.memorytron

import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class Final : AppCompatActivity() {

    var mediaPlayer:MediaPlayer?=null
    var musica=true
    var victorias=0
    var derrotas=0

    private lateinit var sharedPreferences : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)



        victorias=getString(R.string.victorias).toInt()
        derrotas=getString(R.string.derrotas).toInt()

        var resultado=intent.getStringExtra("resultado").toString()

        var fondo = findViewById<ConstraintLayout>(R.id.background)

        var texto=findViewById<ImageView>(R.id.texto)

        var nombrePaquete = getApplicationContext().getPackageName()
        var resultados=findViewById<TextView>(R.id.info)
        Thread.sleep(200)
        resultados.visibility=View.VISIBLE
        if (resultado.equals("Eres Admin")){
            fondo.setBackgroundResource(R.drawable.victoria)
            texto.setImageResource(R.drawable.admin)
            mediaPlayer= MediaPlayer.create(this,R.raw.ganador)
            mediaPlayer?.start()
            victorias++
            sharedPreferences.edit {
                putString(getString(R.string.victorias),victorias.toString())
            }
            resultados.text="Victorias Totales: $victorias\nDerrotas Totales: $derrotas"
        }else{
            fondo.setBackgroundResource(R.drawable.perdiste)
            //texto.setImageResource(R.drawable.cagaste)
            mediaPlayer= MediaPlayer.create(this,R.raw.perdiste)
            mediaPlayer?.setVolume(0.1F,0.1F)
            mediaPlayer?.start()
            derrotas++
            sharedPreferences.edit {
                putString(getString(R.string.derrotas),derrotas.toString())
            }
            resultados.text="Victorias Totales: $victorias\nDerrotas Totales: $derrotas"
        }

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
        mediaPlayer?.pause()
        super.onStop()
    }

    override fun onResume() {
        mediaPlayer?.start()
        super.onResume()
    }

    fun pararMusica(view: View) {
        if (musica) {
            mediaPlayer?.pause()
            musica=false
        }else{
            mediaPlayer?.start()
            musica=true
        }
    }

}