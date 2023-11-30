package com.example.memorytron
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.edit

class Final : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null
    var musica = true

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        // Recupera las victorias y derrotas almacenadas en SharedPreferences
        var victorias = sharedPreferences.getString(getString(R.string.victorias), "0")?.toInt() ?: 0
        var derrotas = sharedPreferences.getString(getString(R.string.derrotas), "0")?.toInt() ?: 0

        var resultado = intent.getStringExtra("resultado").toString()

        var fondo = findViewById<ConstraintLayout>(R.id.background)
        var texto = findViewById<ImageView>(R.id.texto)
        var resultados = findViewById<TextView>(R.id.info)

        resultados.visibility = View.VISIBLE

        if (resultado.equals("Eres Admin")) {
            fondo.setBackgroundResource(R.drawable.victoria)
            texto.setImageResource(R.drawable.admin)
            mediaPlayer = MediaPlayer.create(this, R.raw.ganador)
            mediaPlayer?.start()
            victorias++
        } else {
            fondo.setBackgroundResource(R.drawable.perdiste)
            texto.setImageResource(R.drawable.cagaste)
            mediaPlayer = MediaPlayer.create(this, R.raw.derrota)
            mediaPlayer?.seekTo(5000)
            mediaPlayer?.setVolume(1.0F,1.0F)
            mediaPlayer?.start()
            derrotas++
        }
        with(sharedPreferences.edit()) {
            putString(getString(R.string.victorias), victorias.toString())
            putString(getString(R.string.derrotas), derrotas.toString())
            apply()
        }
        resultados.text = "Victorias Totales: $victorias\nDerrotas Totales: $derrotas"



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