package com.example.myedu

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val kls10: CardView = findViewById(R.id.cv_kls10)
        val kls11: CardView = findViewById(R.id.cv_kls11)
        val kls12: CardView = findViewById(R.id.cv_kls12)
        val notes: CardView = findViewById(R.id.cv_notes)
        val profile: ImageView = findViewById(R.id.imageView2)

        // Mengambil data nama dari intent
        val getDataName = intent.getStringExtra("name")

        // Menampilkan teks sapaan dengan nama pengguna
        val displayTitle = findViewById<TextView>(R.id.greeting_text)
        displayTitle.text = "Halo, $getDataName"


        kls10.setOnClickListener {
            var pindah1 = Intent(this, Kelas10::class.java)
            startActivity(pindah1)
        }
        kls11.setOnClickListener {
            var pindah2 = Intent(this, Kelas11::class.java)
            startActivity(pindah2)
        }
        kls12.setOnClickListener {
            var pindah3 = Intent(this, Kelas12::class.java)
            startActivity(pindah3)
        }
        notes.setOnClickListener {
            var pindah4 = Intent(this, NotesActivity::class.java)
            startActivity(pindah4)
        }
        profile.setOnClickListener {
            var pindah5 = Intent(this, ProfileActivity::class.java)
            startActivity(pindah5)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}