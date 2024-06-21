package com.example.myedu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.adapter.NotesAdapter
import com.example.myedu.room.NotesEntity
import com.example.myedu.room.NotesViewModel
import com.example.myedu.room.NotesViewModelFactory

class NotesActivity : AppCompatActivity() {

    private lateinit var notesViewModel: NotesViewModel
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notes)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val factory = NotesViewModelFactory.getInstance(this)
        notesViewModel = ViewModelProvider(this, factory)[NotesViewModel::class.java]
        recyclerView = findViewById(R.id.rv_notes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        notesViewModel.getAllPost().observe(this) { postData ->
            if (postData != null) {
                notesAdapter = NotesAdapter(postData)
                recyclerView.adapter = notesAdapter

                notesAdapter.setOnItemClickCallback(object : NotesAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: NotesEntity) {
                        val intent = Intent(this@NotesActivity, UpdateActivity::class.java)
                        intent.putExtra("user", data)
                        startActivity(intent)
                    }
                })
            }
        }
    }

    fun toAddPost(view: View) {
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }
}
