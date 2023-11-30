package com.example.memorytron
import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.edit

class Final : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null
    var musica = true

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        // Recupera las victorias y derrotas almacenadas en SharedPreferences
        var victorias = sharedPreferences.getInt("victorias", 0)
        var derrotas = sharedPreferences.getInt("derrotas", 0)

        var resultado = intent.getStringExtra("resultado").toString()

        var fondo = findViewById<ConstraintLayout>(R.id.background)
        var texto = findViewById<ImageView>(R.id.texto)
        var resultados = findViewById<TextView>(R.id.info)

        resultados.visibility = View.VISIBLE

        if (resultado.equals("Eres Admin")) {
            fondo.setBackgroundResource(R.drawable.victoria)
            texto.setImageResource(R.drawable.admin)
            mediaPlayer = MediaPlayer.create(this, R.raw.ganador)
            mediaPlayer?.start()
            victorias++
        } else {
            fondo.setBackgroundResource(R.drawable.perdiste)
            texto.setImageResource(R.drawable.cagaste)
            mediaPlayer = MediaPlayer.create(this, R.raw.derrota)
            mediaPlayer?.seekTo(5000)
            mediaPlayer?.setVolume(1.0F,1.0F)
            mediaPlayer?.start()
            derrotas++
        }
        with(sharedPreferences.edit()) {
            putInt("victorias", victorias)
            putInt("derrotas", derrotas)
            apply()
        }
        resultados.text = "Victorias Totales: $victorias\nDerrotas Totales: $derrotas"

        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this)
        musica=sharedPreferences.getBoolean("musica",true)

        if(!musica) {
            mediaPlayer?.stop()
        }


    }
    override fun onBackPressed() {
        mediaPlayer?.stop()
        var intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
        super.onBackPressed()
    }

    fun animacion(view:View,tiempoX:Long,tiempoY:Long){
        val scaleXAnimator = ObjectAnimator.ofFloat(view, View.SCALE_X, 0.9f)
        val scaleYAnimator = ObjectAnimator.ofFloat(view, View.SCALE_Y, 0.9f)

        val animatorListener = object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                val scaleXAnimatorBack = ObjectAnimator.ofFloat(view, View.SCALE_X, 1.0f)
                val scaleYAnimatorBack = ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.0f)

                scaleXAnimatorBack.duration = tiempoX
                scaleYAnimatorBack.duration = tiempoY
                scaleXAnimatorBack.start()
                scaleYAnimatorBack.start()
            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }
        }

        scaleXAnimator.addListener(animatorListener)
        scaleYAnimator.addListener(animatorListener)

        scaleXAnimator.duration = tiempoX
        scaleYAnimator.duration = tiempoY

        scaleXAnimator.start()
        scaleYAnimator.start()
    }
    fun reiniciar(view: View) {
        var intent=Intent(this,Juego::class.java)
        mediaPlayer?.stop()
        animacion(view,200,200)
        view.postDelayed({startActivity(intent)},400)
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