package com.example.memorytron

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
    lateinit var booleans:MutableList<Boolean>
    lateinit var img:MutableList<Int>
    var ultimg=-1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        imgs= mutableListOf(R.drawable.pinguino, R.drawable.mono, R.drawable.medusa,
            R.drawable.gato, R.drawable.doberman, R.drawable.cerdo, R.drawable.pinguino, R.drawable.mono, R.drawable.medusa,
            R.drawable.gato, R.drawable.doberman, R.drawable.cerdo)

        booleans= mutableListOf(false,false,false,false,false,false,false,false,false,false,false,false)
        img= mutableListOf(0,0,0,0,0,0,0,0,0,0,0,0)
        img[0] = imgs.random()
        imgs.remove(img[0])
        img[1] = imgs.random()
        imgs.remove(img[1])
        img[2] = imgs.random()
        imgs.remove(img[2])
        img[3] = imgs.random()
        imgs.remove(img[3])
        img[4] = imgs.random()
        imgs.remove(img[4])
        img[5] = imgs.random()
        imgs.remove(img[5])
        img[6] = imgs.random()
        imgs.remove(img[6])
        img[7] = imgs.random()
        imgs.remove(img[7])
        img[8] = imgs.random()
        imgs.remove(img[8])
        img[9] = imgs.random()
        imgs.remove(img[9])
        img[10] = imgs.random()
        imgs.remove(img[10])
        img[11] = imgs.random()
        imgs.remove(img[11])
    }


    fun pulsado(view: View) {



        when(view.id) {
                R.id.ct1img1 -> {
                    var imagen = findViewById<ImageView>(R.id.ct1img1)

                    if (!booleans[0]) {
                        imagen.setImageResource(img[0])
                        booleans[0] = true
                    }else{
                    if (ultimg > -1) {
                        if (getDrawable(img[ultimg]) == getDrawable(img[0])) {

                        } else {
                            imagen.setImageResource(R.drawable.parteatras)
                            booleans[0]=false
                        }
                }
                }
                    ultimg=0
                }

                R.id.ct1img2 -> {


                    var imagen = findViewById<ImageView>(R.id.ct1img2)
                    if (!booleans[1]) {

                        imagen.setImageResource(img[1])
                        booleans[1] = true
                    }else{

                    imagen.setImageResource(img[1])

                    Thread.sleep(1)

                    if (ultimg > -1) {
                        if (getDrawable(img[ultimg]) == getDrawable(img[1])) {

                        } else {
                            booleans[1]=false
                            imagen.setImageResource(R.drawable.parteatras)
                        }
                    }

                }
                    ultimg=1

                }
            R.id.ct1img3 -> {
                var imagen = findViewById<ImageView>(R.id.ct1img3)
                if (!booleans[2]) {

                    imagen.setImageResource(img[2])
                    booleans[2] = true
                }else{


                imagen.setImageResource(img[2])

                Thread.sleep(1)

                if (ultimg > -1) {
                    if (getDrawable(img[ultimg]) == getDrawable(img[2])) {

                    } else {
                        booleans[2]=false
                        imagen.setImageResource(R.drawable.parteatras)
                    }

                }
            }
                ultimg=2
            }
            R.id.ct1img4 -> {
                var imagen = findViewById<ImageView>(R.id.ct1img4)
                if (!booleans[3]) {

                    imagen.setImageResource(img[3])
                    booleans[3] = true
                }else{

                imagen.setImageResource(img[3])

                Thread.sleep(1)

                if (ultimg > -1) {
                    if (getDrawable(img[ultimg]) == getDrawable(img[3])) {

                    } else {
                        booleans[3]=false
                        imagen.setImageResource(R.drawable.parteatras)
                    }
                }

            }
                ultimg=3
            }
            R.id.ct2img1 -> {
                var imagen = findViewById<ImageView>(R.id.ct2img1)
                if (!booleans[4]) {

                    imagen.setImageResource(img[4])
                    booleans[4] = true
                }else{


                imagen.setImageResource(img[4])

                Thread.sleep(1)

                if (ultimg > -1) {
                    if (getDrawable(img[ultimg]) == getDrawable(img[4])) {

                    } else {
                        booleans[4]=false
                        imagen.setImageResource(R.drawable.parteatras)
                    }

                }
            }
                ultimg=4
            }
            R.id.ct2img2 -> {
                var imagen = findViewById<ImageView>(R.id.ct2img2)
                if (!booleans[5]) {

                    imagen.setImageResource(img[5])
                    booleans[5] = true
                }else{

                imagen.setImageResource(img[5])

                Thread.sleep(1)

                if (ultimg > -1) {
                    if (getDrawable(img[ultimg]) == getDrawable(img[5])) {

                    } else {
                        booleans[5]=false
                        imagen.setImageResource(R.drawable.parteatras)
                    }

                }
            }
                ultimg=5
            }
            R.id.ct2img3 -> {
                var imagen = findViewById<ImageView>(R.id.ct2img3)
                if (!booleans[6]) {

                    imagen.setImageResource(img[6])
                    booleans[6] = true
                }else{

                imagen.setImageResource(img[6])

                Thread.sleep(1)

                if (ultimg > -1) {
                    if (getDrawable(img[ultimg]) == getDrawable(img[6])) {

                    } else {
                        booleans[6]=false
                        imagen.setImageResource(R.drawable.parteatras)
                    }
                }

            }
                ultimg=6
            }
            R.id.ct2img4 -> {
                var imagen = findViewById<ImageView>(R.id.ct2img4)
                if (!booleans[7]) {

                    imagen.setImageResource(img[7])
                    booleans[7] = true
                }else{

                imagen.setImageResource(img[7])

                Thread.sleep(1)

                if (ultimg > -1) {
                    if (getDrawable(img[ultimg]) == getDrawable(img[7])) {

                    } else {
                        booleans[7]=false
                        imagen.setImageResource(R.drawable.parteatras)
                    }
                }
            }

                ultimg=7
            }
            R.id.ct3img1 -> {
                var imagen = findViewById<ImageView>(R.id.ct3img1)
                if (!booleans[8]) {

                    imagen.setImageResource(img[8])
                    booleans[8] = true
                }else{

                imagen.setImageResource(img[8])

                Thread.sleep(1)

                if (ultimg > -1) {
                    if (getDrawable(img[ultimg]) == getDrawable(img[8])) {

                    } else {
                        booleans[8]=false
                        imagen.setImageResource(R.drawable.parteatras)
                    }
                }

            }
                ultimg=8
            }
            R.id.ct3img2 -> {
                var imagen = findViewById<ImageView>(R.id.ct3img2)
                if (!booleans[9]) {

                    imagen.setImageResource(img[9])
                    booleans[9] = true
                }else{

                imagen.setImageResource(img[9])

                Thread.sleep(1)

                if (ultimg > -1) {
                    if (getDrawable(img[ultimg]) == getDrawable(img[9])) {

                    } else {
                        booleans[9]=false
                        imagen.setImageResource(R.drawable.parteatras)
                    }
                }
            }

                ultimg=9
            }
            R.id.ct3img3 -> {
                var imagen = findViewById<ImageView>(R.id.ct3img3)
                if (!booleans[10]) {

                    imagen.setImageResource(img[10])
                    booleans[10] = true
                }else{

                imagen.setImageResource(img[10])

                Thread.sleep(1)

                if (ultimg > -1) {
                    if (getDrawable(img[ultimg]) == getDrawable(img[10])) {

                    } else {
                        booleans[10]=false
                        imagen.setImageResource(R.drawable.parteatras)
                    }
                }
            }

                ultimg=10
            }
            R.id.ct3img4 -> {
                var imagen = findViewById<ImageView>(R.id.ct3img4)
                if (!booleans[11]) {

                    imagen.setImageResource(img[11])
                    booleans[11] = true
                } else {
                    imagen.setImageResource(img[0])

                    Thread.sleep(1000)

                    if (ultimg > -1) {
                        if (getDrawable(img[ultimg]) == getDrawable(img[11])) {

                        } else {
                            booleans[11]=false
                            imagen.setImageResource(R.drawable.parteatras)
                        }
                    }
                    ultimg = 11
                }
            }

            }
        }
    }


