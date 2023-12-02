package com.example.memorytron

import android.animation.Animator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Switch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var musica = true
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        musica = sharedPreferences.getBoolean("musica", true)
        mediaPlayer = MediaPlayer.create(this, R.raw.inicio)
        mediaPlayer?.setVolume(0.3F, 0.3F)
        mediaPlayer?.start()
        mediaPlayer?.isLooping=true
        if (!musica) {
            mediaPlayer?.pause()
            var switch=findViewById<Switch>(R.id.switch1)
            switch.isChecked=true
        }
    }

    fun jugar(view: View) {
        val intent = Intent(this, Juego::class.java)
        intent.putExtra("musica", musica)
        mediaPlayer?.stop()
        mediaPlayer = MediaPlayer.create(this, R.raw.boton)
        mediaPlayer?.seekTo(900)
        mediaPlayer?.start()
        mediaPlayer?.setVolume(1.0F, 1.0F)
        animacion(view, 200, 200)
        view.postDelayed({ startActivity(intent) }, 400)
    }

    override fun onStop() {
        mediaPlayer?.pause()
        super.onStop()
    }

    fun animacion(view:View,tiempoX:Long,tiempoY:Long){
        view.animate().apply {
            scaleX(0.9f)
            scaleY(0.9f)
            duration=tiempoX
        }.withEndAction {
            view.animate().apply {
                scaleX(1.0f)
                scaleY(1.0f)
                duration=tiempoY
            }
        }
    }

    override fun onStart() {
        if (musica) {
            mediaPlayer?.start()
        }else{
            var switch=findViewById<Switch>(R.id.switch1)
            switch.isChecked=true
        }

        super.onStart()
    }

    fun pararMusica(view: View) {
        if (musica) {
            mediaPlayer?.pause()
            musica = false
        } else {
            mediaPlayer?.start()
            musica = true
        }
        sharedPreferences.edit().apply {
            putBoolean("musica", musica)
            apply()
        }
    }

    fun jugar2(view: View) {
        val intent = Intent(this, Juego2::class.java)
        intent.putExtra("musica", musica)
        mediaPlayer?.stop()
        mediaPlayer = MediaPlayer.create(this, R.raw.boton)
        mediaPlayer?.seekTo(900)
        mediaPlayer?.start()
        mediaPlayer?.setVolume(1.0F, 1.0F)
        animacion(view, 200, 200)
        view.postDelayed({ startActivity(intent) }, 400)
    }
}