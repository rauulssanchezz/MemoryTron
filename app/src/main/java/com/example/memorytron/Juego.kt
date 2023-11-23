package com.example.memorytron

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.drawable.toDrawable
import kotlin.concurrent.timer
import kotlin.random.Random

class Juego : AppCompatActivity() {

    lateinit var imgs :MutableList<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        imgs= mutableListOf(R.drawable.pinguino, R.drawable.mono, R.drawable.medusa,
            R.drawable.gato, R.drawable.doberman, R.drawable.cerdo, R.drawable.pinguino, R.drawable.mono, R.drawable.medusa,
            R.drawable.gato, R.drawable.doberman, R.drawable.cerdo)
        imgs.shuffle()

    }



    fun pulsado(view: View) {



        when(view.id) {
                R.id.ct1img1 -> {
                    var imagen = findViewById<ImageView>(R.id.ct1img1)

                    imagen.setImageResource(imgs[0])
                    Thread.sleep(1000)

                }

                R.id.ct1img2 -> {

                    var imagen = findViewById<ImageView>(R.id.ct1img2)

                    imagen.setImageResource(imgs[1])

                }
            R.id.ct1img3 -> {
                var imagen = findViewById<ImageView>(R.id.ct1img3)

                    imagen.setImageResource(imgs[2])

            }

            R.id.ct1img4 -> {
                var imagen = findViewById<ImageView>(R.id.ct1img4)

                imagen.setImageResource(imgs[3])

            }
            R.id.ct2img1 -> {
                var imagen = findViewById<ImageView>(R.id.ct2img1)
                imagen.setImageResource(imgs[4])

            }
            R.id.ct2img2 -> {
                var imagen = findViewById<ImageView>(R.id.ct2img2)

                imagen.setImageResource(imgs[5])

            }
            R.id.ct2img3 -> {
                var imagen = findViewById<ImageView>(R.id.ct2img3)

                imagen.setImageResource(imgs[6])

            }
            R.id.ct2img4 -> {
                var imagen = findViewById<ImageView>(R.id.ct2img4)

                imagen.setImageResource(imgs[7])

            }
            R.id.ct3img1 -> {
                var imagen = findViewById<ImageView>(R.id.ct3img1)

                imagen.setImageResource(imgs[8])

            }
            R.id.ct3img2 -> {
                var imagen = findViewById<ImageView>(R.id.ct3img2)

                imagen.setImageResource(imgs[9])

            }
            R.id.ct3img3 -> {
                var imagen = findViewById<ImageView>(R.id.ct3img3)

                imagen.setImageResource(imgs[10])

            }
            R.id.ct3img4 -> {
                var imagen = findViewById<ImageView>(R.id.ct3img4)

                    imagen.setImageResource(imgs[11])

                }
            }

            }
        }



