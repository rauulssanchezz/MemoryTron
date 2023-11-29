package com.example.memorytron

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var mediaPlayer:MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer= MediaPlayer.create(this,R.raw.inicio)
        mediaPlayer?.start()
    }

    fun jugar(view: View) {
        val intent=Intent(this,Juego::class.java)
        mediaPlayer?.stop()
        mediaPlayer=MediaPlayer.create(this,R.raw.boton)
        mediaPlayer?.seekTo(900)
        mediaPlayer?.start()
        mediaPlayer?.setVolume(100.0F,100.0F)
        Thread.sleep(250)
        startActivity(intent)
    }

    override fun onStop() {
        mediaPlayer?.stop()
        super.onStop()
    }

    override fun onStart() {
        mediaPlayer?.start()
        super.onStart()
    }

    fun pararMusica(view: View) {
        mediaPlayer?.stop()
    }
}