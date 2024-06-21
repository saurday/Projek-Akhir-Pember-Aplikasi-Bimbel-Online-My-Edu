package com.example.myedu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class DetailMapel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_mapel)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mapel1 = intent.getStringExtra("mapel")
        val gambar1 = intent.getStringExtra("gambar")
        val deskrips1 = intent.getStringExtra("deskripsi")

        val mapel = findViewById<TextView>(R.id.namaPel)
        val gambar = findViewById<ImageView>(R.id.gambarPel)
        val deskripsi = findViewById<TextView>(R.id.descPel)

        mapel.text = mapel1
        Glide.with(this).load(gambar1).into(gambar)
        deskripsi.text = deskrips1


    }
}