package com.example.memorytron

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import kotlin.random.Random

class Juego : AppCompatActivity() {

    lateinit var imgs :MutableList<Int>
    lateinit var booleans:MutableList<Boolean>
    override fun onCreate(savedInstanceState: Bundle?) {
        println("sigo vivo")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        imgs= mutableListOf(R.drawable.pinguino, R.drawable.mono, R.drawable.medusa,
            R.drawable.gato, R.drawable.doberman, R.drawable.cerdo, R.drawable.pinguino, R.drawable.mono, R.drawable.medusa,
            R.drawable.gato, R.drawable.doberman, R.drawable.cerdo)

        booleans= mutableListOf(false,false,false,false,false,false,false,false,false,false,false,false)
    }


    fun pulsado(view: View) {
        when(view.id) {
                R.id.ct1img1 -> {
                    var imagen = findViewById<ImageView>(R.id.ct1img1)

                    if(!booleans[0]) {
                        var img = imgs.random()
                        imgs.remove(img)
                        imagen.setImageResource(img)
                        booleans[0]=true
                    }
                }

                R.id.ct1img2 ->{
                    var imagen = findViewById<ImageView>(R.id.ct1img2)
                    if(!booleans[1]) {
                        var img = imgs.random()
                        imgs.remove(img)
                        imagen.setImageResource(img)
                        booleans[1]=true
                    }
                }
            R.id.ct1img3 ->{
                var imagen = findViewById<ImageView>(R.id.ct1img3)
                if(!booleans[2]) {
                    var img = imgs.random()
                    imgs.remove(img)
                    imagen.setImageResource(img)
                    booleans[2]=true
                }
            }
            R.id.ct1img4 ->{
                var imagen = findViewById<ImageView>(R.id.ct1img4)
                if(!booleans[3]) {
                    var img = imgs.random()
                    imgs.remove(img)
                    imagen.setImageResource(img)
                    booleans[3]=true
                }
            }
            R.id.ct2img1 ->{
                var imagen = findViewById<ImageView>(R.id.ct2img1)
                if(!booleans[4]) {
                    var img = imgs.random()
                    imgs.remove(img)
                    imagen.setImageResource(img)
                    booleans[4]=true
                }
            }
            R.id.ct2img2 ->{
                var imagen = findViewById<ImageView>(R.id.ct2img2)
                if(!booleans[5]) {
                    var img = imgs.random()
                    imgs.remove(img)
                    imagen.setImageResource(img)
                    booleans[5]=true
                }
            }
            R.id.ct2img3 ->{
                var imagen = findViewById<ImageView>(R.id.ct2img3)
                if(!booleans[6]) {
                    var img = imgs.random()
                    imgs.remove(img)
                    imagen.setImageResource(img)
                    booleans[6]=true
                }
            }
            R.id.ct2img4 ->{
                var imagen = findViewById<ImageView>(R.id.ct2img4)
                if(!booleans[7]) {
                    var img = imgs.random()
                    imgs.remove(img)
                    imagen.setImageResource(img)
                    booleans[7]=true
                }
            }
            R.id.ct3img1 ->{
                var imagen = findViewById<ImageView>(R.id.ct3img1)
                if(!booleans[8]) {
                    var img = imgs.random()
                    imgs.remove(img)
                    imagen.setImageResource(img)
                    booleans[8]=true
                }
            }
            R.id.ct3img2 ->{
                var imagen = findViewById<ImageView>(R.id.ct3img2)
                if(!booleans[9]) {
                    var img = imgs.random()
                    imgs.remove(img)
                    imagen.setImageResource(img)
                    booleans[9]=true
                }
            }
            R.id.ct3img3 ->{
                var imagen = findViewById<ImageView>(R.id.ct3img3)
                if(!booleans[10]) {
                    var img = imgs.random()
                    imgs.remove(img)
                    imagen.setImageResource(img)
                    booleans[10]=true
                }
            }
            R.id.ct3img4 ->{
                var imagen = findViewById<ImageView>(R.id.ct3img4)
                if(!booleans[11]) {
                    var img = imgs.random()
                    imgs.remove(img)
                    imagen.setImageResource(img)
                    booleans[11]=true
                }
            }
        }
    }


}