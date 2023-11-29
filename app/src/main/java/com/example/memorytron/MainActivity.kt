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
}