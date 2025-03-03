package com.example.myapplication

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val imageSoundMap = mapOf(
            R.id.trex to R.raw.trex,
            R.id.flydino to R.raw.dino,
            R.id.snek to R.raw.snake,
            R.id.geko to R.raw.tuko,
            R.id.frog to R.raw.frog,
            R.id.croc to R.raw.cric
        )


        imageSoundMap.forEach { (imageId, soundId) ->
            findViewById<ImageView>(imageId).setOnClickListener {
                playSound(soundId)
            }
        }
    }

    private fun playSound(soundResId: Int) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(this, soundResId)
        mediaPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}

