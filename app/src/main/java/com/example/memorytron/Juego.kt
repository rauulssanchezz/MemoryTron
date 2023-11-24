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
    lateinit var ultimg: ImageView
    var primerclick = false
    lateinit var imageViews: MutableList<ImageView>
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
    }

    fun segundaparte(pos: Int) {
        if (primerclick) {
            var iguales=comprobar(imageViews[pos], ultimg)
            if (!iguales){
                imageViews[pos].setImageResource(R.drawable.parteatras)
                ultimg.setImageResource(R.drawable.parteatras)
            }
        } else {
            primerclick = true
        }
        ultimg = imageViews[pos]
    }

    fun pulsado(view: View) {


        when (view.id) {
            R.id.ct1img1 -> {

                primeraparte(0)

                view.postDelayed({ segundaparte(0) }, 500)
            }

            R.id.ct1img2 -> {

                primeraparte(1)

                view.postDelayed({ segundaparte(1) }, 500)
            }

            R.id.ct1img3 -> {
                primeraparte(2)

                view.postDelayed({ segundaparte(2) }, 500)
            }

            R.id.ct1img4 -> {
                primeraparte(3)

                view.postDelayed({ segundaparte(3) }, 500)
            }

            R.id.ct2img1 -> {
                primeraparte(4)

                view.postDelayed({ segundaparte(4) }, 500)
            }

            R.id.ct2img2 -> {
                primeraparte(5)

                view.postDelayed({ segundaparte(5) }, 500)
            }

            R.id.ct2img3 -> {
                primeraparte(6)

                view.postDelayed({ segundaparte(6) }, 500)
            }

            R.id.ct2img4 -> {
                primeraparte(7)

                view.postDelayed({ segundaparte(7) }, 500)
            }

            R.id.ct3img1 -> {
                primeraparte(8)

                view.postDelayed({ segundaparte(8) }, 500)
            }

            R.id.ct3img2 -> {
                primeraparte(9)

                view.postDelayed({ segundaparte(9) }, 500)
            }

            R.id.ct3img3 -> {
                primeraparte(10)

                view.postDelayed({ segundaparte(10) }, 500)
            }

            R.id.ct3img4 -> {
                primeraparte(11)

                view.postDelayed({ segundaparte(11) }, 500)
            }

        }


    }
}



