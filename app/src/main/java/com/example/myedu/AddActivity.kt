package com.example.myedu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.myedu.room.NotesEntity
import com.example.myedu.room.NotesViewModel
import com.example.myedu.room.NotesViewModelFactory

class AddActivity : AppCompatActivity() {

    private lateinit var notesViewModel: NotesViewModel
    private lateinit var title: EditText
    private lateinit var description: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        title = findViewById(R.id.title)
        description = findViewById(R.id.description)

        val factory = NotesViewModelFactory.getInstance(this) // Menggunakan NotesViewModelFactory
        notesViewModel = ViewModelProvider(this, factory)[NotesViewModel::class.java]

        val btnSavedPlayer = findViewById<Button>(R.id.btn_save)
        btnSavedPlayer.setOnClickListener {
            if (validateInput()) {
                savedData()
            }
        }
    }

    private fun validateInput(): Boolean {
        var error = 0

        if (title.text.toString().isEmpty()) {
            error++
            title.error = "Judul tidak boleh kosong!"
        }
        if (description.text.toString().isEmpty()) {
            error++
            description.error = "Isi tidak boleh kosong!"
        }
        return error == 0
    }

    private fun savedData() {
        val titleText = title.text.toString()
        val descriptionText = description.text.toString()

        val post = NotesEntity(
            id = 0,
            title = titleText,
            description = descriptionText
        )

        notesViewModel.insertPost(post)

        Toast.makeText(
            this@AddActivity,
            "Berhasil upload",
            Toast.LENGTH_SHORT
        ).show()

        finish()
    }

    fun toMain(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
