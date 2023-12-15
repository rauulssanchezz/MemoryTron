package com.example.memorytron

import android.graphics.Bitmap
import android.widget.ImageView

class Card(var imageView: ImageView, var image:Int) {
    var pulsada=false

    fun show(){
        pulsada=true
        imageView.setImageResource(image)
    }

    fun hide(){
        pulsada=false
        imageView.setImageResource(R.drawable.parteatras)
    }

    fun compare(imageView2: ImageView): Boolean {
        var drawable1 = imageView.drawable
        var drawable2 = imageView2.drawable
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
}