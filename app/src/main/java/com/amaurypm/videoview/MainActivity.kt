package com.amaurypm.videoview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.amaurypm.videoview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Cargando un archivo local en almacenamiento interno
        binding.vvVideo.setVideoPath("android.resource://${packageName}/${R.raw.maverick}")

        val mc = MediaController(this)
        mc.setAnchorView(binding.vvVideo) //anclamos el videoview al mediacontroller
        binding.vvVideo.setMediaController(mc) //agrega el mediacontroller al videoview

        binding.vvVideo.start()
    }
}