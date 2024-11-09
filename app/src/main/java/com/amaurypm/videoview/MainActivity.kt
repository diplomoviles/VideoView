package com.amaurypm.videoview

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.MediaController
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.amaurypm.videoview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Ponemos la orientación en landscape
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        //Cargamos nuestro archivo local
        //binding.vvVideo.setVideoPath("android.resource://${packageName}/${R.raw.maverick}")
        //binding.vvVideo.start()

        //Cargamos un archivo en la red
        binding.vvVideo.setVideoPath("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4")

        //Estableciendo controles para el video.
        val mediaController = MediaController(this)
        mediaController.setAnchorView(binding.vvVideo)
        binding.vvVideo.setMediaController(mediaController)

        binding.vvVideo.start()

    }
}