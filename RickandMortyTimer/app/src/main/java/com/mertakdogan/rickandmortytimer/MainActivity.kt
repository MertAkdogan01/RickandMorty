package com.mertakdogan.rickandmortytimer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import com.mertakdogan.rickandmortytimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mplayer : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var zamaniDurdur : Long = 0
        binding.btnStart.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()+zamaniDurdur
            binding.kronometre.start()
            binding.btnStart.visibility = View.GONE
            binding.btnPause.visibility = View.VISIBLE

        }

        binding.btnPause.setOnClickListener {
            zamaniDurdur = binding.kronometre.base - SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE
            mplayer = MediaPlayer.create(applicationContext, R.raw.dubdub)
            mplayer.start()

        }

        binding.btnReset.setOnClickListener {
            binding.kronometre.base = SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.btnPause.visibility = View.GONE
            binding.btnStart.visibility = View.VISIBLE

        }


    }
}