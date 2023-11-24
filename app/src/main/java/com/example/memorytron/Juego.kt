package com.example.memorytron

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.drawable.toDrawable
import kotlin.concurrent.timer
import kotlin.random.Random

class Juego : AppCompatActivity() {

    lateinit var imgs: MutableList<Int>
    var ultimg: ImageView?=null
    var primerclick = false
    lateinit var imageViews: MutableList<ImageView>
    var pulsado:MutableList<Boolean> = MutableList(12){false}
    var posant:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        imgs = mutableListOf(
            R.drawable.pinguino,
            R.drawable.mono,
            R.drawable.medusa,
            R.drawable.gato,
            R.drawable.doberman,
            R.drawable.cerdo,
            R.drawable.pinguino,
            R.drawable.mono,
            R.drawable.medusa,
            R.drawable.gato,
            R.drawable.doberman,
            R.drawable.cerdo
        )
        imgs.shuffle()
        imageViews = mutableListOf(
            findViewById<ImageView>(R.id.ct1img1),
            findViewById<ImageView>(R.id.ct1img2),
            findViewById<ImageView>(R.id.ct1img3),
            findViewById<ImageView>(R.id.ct1img4),
            findViewById<ImageView>(R.id.ct2img1),
            findViewById<ImageView>(R.id.ct2img2),
            findViewById<ImageView>(R.id.ct2img3),
            findViewById<ImageView>(R.id.ct2img4),
            findViewById<ImageView>(R.id.ct3img1),
            findViewById<ImageView>(R.id.ct3img2),
            findViewById<ImageView>(R.id.ct3img3),
            findViewById<ImageView>(R.id.ct3img4)
        )


    }

    fun comprobar(img1: ImageView, img2: ImageView): Boolean {
        var drawable1 = img1.drawable
        var drawable2 = img2.drawable
        var bitmap1 = Bitmap.createBitmap(
            drawable1.intrinsicWidth,
            drawable1.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        var bitmap2 = Bitmap.createBitmap(
            drawable2.intrinsicWidth,
            drawable2.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        var canvas1 = android.graphics.Canvas(bitmap1)
        var canvas2 = android.graphics.Canvas(bitmap2)
        drawable1.setBounds(0, 0, canvas1.width, canvas1.height)
        drawable2.setBounds(0, 0, canvas2.width, canvas2.height)
        drawable1.draw(canvas1)
        drawable2.draw(canvas2)
        return bitmap1.sameAs(bitmap2)
    }
    fun primeraparte(pos: Int) {
        imageViews[pos].setImageResource(imgs[pos])
        pulsado[pos]=true
    }

    fun segundaparte(pos: Int) {
        var iguales=false
        if (primerclick) {
             iguales=comprobar(imageViews[pos], ultimg!!)
            if (!iguales){
                imageViews[pos].setImageResource(R.drawable.parteatras)
                ultimg!!.setImageResource(R.drawable.parteatras)
                pulsado[pos]=false
                pulsado[posant!!]=false
            }
        } else {
            primerclick = true
        }
        if (iguales){
            ultimg=null
            primerclick=false
        }else{
            ultimg=imageViews[pos]
            posant=pos
        }
    }

    fun pulsado(view: View) {


        when (view.id) {
            R.id.ct1img1 -> {
                var pos=0
                if (!pulsado[pos]) {
                    primeraparte(pos)


                        view.postDelayed({ segundaparte(pos) }, 500)

                }
            }

            R.id.ct1img2 -> {
                var pos=1
                if (!pulsado[pos]) {
                    primeraparte(pos)

                    view.postDelayed({ segundaparte(pos) }, 500)
                }
            }

            R.id.ct1img3 -> {
                var pos=2
                if (!pulsado[pos]) {
                    primeraparte(pos)

                    view.postDelayed({ segundaparte(pos) }, 500)
                }
            }

            R.id.ct1img4 -> {
                var pos=3
                if (!pulsado[pos]) {
                    primeraparte(pos)

                    view.postDelayed({ segundaparte(pos) }, 500)
                }
            }

            R.id.ct2img1 -> {
                var pos=4
                if (!pulsado[pos]) {
                    primeraparte(pos)

                    view.postDelayed({ segundaparte(pos) }, 500)
                }
            }

            R.id.ct2img2 -> {
                var pos=5
                if (!pulsado[pos]) {
                    primeraparte(pos)

                    view.postDelayed({ segundaparte(pos) }, 500)
                }
            }

            R.id.ct2img3 -> {
                var pos=6
                if (!pulsado[pos]) {
                    primeraparte(pos)

                    view.postDelayed({ segundaparte(pos) }, 500)
                }
            }

            R.id.ct2img4 -> {
                var pos=7
                if (!pulsado[pos]) {
                    primeraparte(pos)

                    view.postDelayed({ segundaparte(pos) }, 500)
                }
            }

            R.id.ct3img1 -> {
                var pos=8
                if (!pulsado[pos]) {
                    primeraparte(pos)

                    view.postDelayed({ segundaparte(pos) }, 500)
                }
            }

            R.id.ct3img2 -> {
                var pos=9
                if (!pulsado[pos]) {
                    primeraparte(pos)

                    view.postDelayed({ segundaparte(pos) }, 500)
                }
            }

            R.id.ct3img3 -> {
                var pos=10
                if (!pulsado[pos]) {
                    primeraparte(pos)

                    view.postDelayed({ segundaparte(pos) }, 500)
                }
            }

            R.id.ct3img4 -> {
                var pos=11
                if (!pulsado[pos]) {
                    primeraparte(pos)

                    view.postDelayed({ segundaparte(pos) }, 500)
                }
            }

        }


    }
}



