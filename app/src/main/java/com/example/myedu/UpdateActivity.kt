package com.example.myedu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.myedu.room.NotesEntity
import com.example.myedu.room.NotesViewModel
import com.example.myedu.room.NotesViewModelFactory

class UpdateActivity : AppCompatActivity() {

    private lateinit var title: EditText
    private lateinit var description: EditText
    private lateinit var getDataUser: NotesEntity
    private lateinit var notesViewModel: NotesViewModel

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update)

        // Mendapatkan data user dari intent
        getDataUser = intent.getParcelableExtra("user") ?: return

        val factory = NotesViewModelFactory.getInstance(this)
        notesViewModel = ViewModelProvider(this, factory)[NotesViewModel::class.java]

        title = findViewById(R.id.title)
        description = findViewById(R.id.description)

        title.setText(getDataUser.title)
        description.setText(getDataUser.description)

        onClick()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun onClick() {
        val savedBtn = findViewById<ImageButton>(R.id.btn_change)
        savedBtn.setOnClickListener {
            if (validateInput()) {
                savedData()
            }
        }

        val btnDelete = findViewById<ImageButton>(R.id.btn_delete)
        btnDelete.setOnClickListener {
            notesViewModel.deletePost(getDataUser)
            Toast.makeText(this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validateInput(): Boolean {
        var error = 0

        if (title.text.toString().isEmpty()) {
            error++
            title.error = "Judul tidak boleh kosong"
        }

        if (description.text.toString().isEmpty()) {
            error++
            description.error = "Isi tidak boleh kosong"
        }

        return error == 0
    }

    private fun savedData() {
        val user = NotesEntity(
            id = getDataUser.id,
            title = title.text.toString(),
            description = description.text.toString()
        )

        Log.d("user", user.toString())

        // Memperbarui data catatan di database
        notesViewModel.updatePost(user)

        // Menampilkan pesan bahwa data catatan berhasil diubah
        Toast.makeText(
            this@UpdateActivity,
            "Data berhasil diubah",
            Toast.LENGTH_SHORT
        ).show()

        // Menutup activity
        finish()
    }
}
