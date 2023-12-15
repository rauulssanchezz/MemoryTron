package com.example.memorytron

import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import android.view.View
import android.widget.ImageView
import java.util.concurrent.Semaphore

class GameHard : AppCompatActivity() {
    var musica = true
    lateinit var imgs: MutableList<Int>
    var ultimg: ImageView? = null
    var primerclick = false
    lateinit var imageViews: MutableList<ImageView>
    var pulsado: MutableList<Boolean> = MutableList(18) { false }
    lateinit var vidasImageViews:Array<Int>
    var posant: Int? = null
    var cont = 0
    var semaforo = Semaphore(1)
    var gana = 0
    var vidas = 6
    var mediaPlayer: MediaPlayer? = null
    lateinit var sharedPreferences: SharedPreferences
    lateinit var  handler : Handler
    lateinit var cards: Array<Card>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego2)

        handler= Handler(Looper.getMainLooper())

        imgs = mutableListOf(
            R.drawable.pinguino,
            R.drawable.mono,
            R.drawable.medusa,
            R.drawable.gato,
            R.drawable.doberman,
            R.drawable.cerdo,
            R.drawable.aguila,
            R.drawable.caballero,
            R.drawable.pinguino,
            R.drawable.mono,
            R.drawable.medusa,
            R.drawable.gato,
            R.drawable.doberman,
            R.drawable.cerdo,
            R.drawable.aguila,
            R.drawable.caballero
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
            findViewById<ImageView>(R.id.ct3img4),
            findViewById<ImageView>(R.id.ct4img1),
            findViewById<ImageView>(R.id.ct4img2),
            findViewById<ImageView>(R.id.ct4img3),
            findViewById<ImageView>(R.id.ct4img4)
        )

        cards=Array(12){ i ->
            Card(imageViews[i],imgs[i])
        }

        vidasImageViews = arrayOf(
            R.id.vida1, R.id.vida2, R.id.vida3, R.id.vida4, R.id.vida5, R.id.vida6
        )

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this)
        musica=sharedPreferences.getBoolean("musica",true)
        mediaPlayer = MediaPlayer.create(this, R.raw.juego2)
        mediaPlayer?.setVolume(0.5F, 0.5F)
        mediaPlayer?.start()
        mediaPlayer?.isLooping=true
        if (!musica) {
            mediaPlayer?.stop()
        }
    }


    //funcion que compara
    fun primeraparte(pos: Int) {
        if (cont<2) {
            cards[pos].show()
            cont++
            if (ultimg == null) {
                primerclick = false
            } else {
                primerclick = true
            }
        }
    }

    private fun procesarResultado(pos: Int, iguales: Boolean) {
        if (iguales) {
            ultimg = null
            cont = 0
            gana++
            if (gana == 6) {
                Thread.sleep(250)
                var resultado = "Eres Admin"
                newActivity(resultado)
            }
        } else if (cont == 2) {
            Thread.sleep(400)

            for (i in listOf(pos, posant!!)) {
                Animation().animation(cards[i].imageView, 100, 150)
                cards[i].hide()
            }

            ultimg = null
            posant = null
            cont = 0

            vidas--
            vidas()
        }
    }

    fun vidas(){
        val vidasRestantes = vidas

        if (vidasRestantes >= 0 && vidasRestantes < vidasImageViews.size) {
            val imagen = findViewById<ImageView>(vidasImageViews[vidasRestantes])
            Animation().animation(imagen, 50, 150)
            imagen.setImageResource(R.drawable.roto)

            if (vidasRestantes == 0) {
                Thread.sleep(300)
                val resultado = "Cagaste"
                newActivity(resultado)
            }
        }
    }

    fun segundaparte(pos: Int) {
        semaforo.acquire()
        if (primerclick && cont==2) {
            val iguales = cards[pos].compare(ultimg!!)
            procesarResultado(pos, iguales)
        } else {
            ultimg = cards[pos].imageView
            posant = pos
        }
        semaforo.release()
    }

    fun accion(pos: Int, view: View) {
        Animation().animation(cards[pos].imageView,100,150)
        view.postDelayed({
            if (!cards[pos].pulsada) {
                Thread{
                    semaforo.acquire()
                    primeraparte(pos)
                    handler.post {
                        semaforo.release()
                        segundaparte(pos)
                    }
                }.start()
            }
        },270)
    }

    fun pulsado(view: View) {
        val pos = imageViews.indexOf(view)

        if (pos != -1) {
            accion(pos, view)
        }
    }


    fun newActivity(res: String) {
        var intent = Intent(this, End::class.java)
        intent.putExtra("resultado", res)
        intent.putExtra("musica", musica)
        intent.putExtra("modo","dificil")
        mediaPlayer?.stop()
        startActivity(intent)
    }

    fun reiniciar(view: View) {
        var intent=Intent(this,GameNormal::class.java)
        mediaPlayer?.stop()
        Animation().animation(view,200,200)
        view.postDelayed({startActivity(intent)},400)
    }

    override fun onBackPressed() {
        mediaPlayer?.stop()
        var intent=Intent(this,Start::class.java)
        startActivity(intent)
        super.onBackPressed()
    }

    override fun onStop() {
        mediaPlayer?.pause()
        super.onStop()
    }

    override fun onResume() {
        mediaPlayer?.start()
        super.onResume()
    }
}