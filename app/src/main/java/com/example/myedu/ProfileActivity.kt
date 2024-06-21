package com.example.myedu
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.google.android.material.imageview.ShapeableImageView

class ProfileActivity:AppCompatActivity()  {


        override fun onCreate(savedInstanceState: Bundle?) {
            enableEdgeToEdge()
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_profile)

            val iconBackCreator = findViewById<ShapeableImageView>(R.id.backFromCreator)
            iconBackCreator.setOnClickListener {
                finish()
            }
        }
    }
