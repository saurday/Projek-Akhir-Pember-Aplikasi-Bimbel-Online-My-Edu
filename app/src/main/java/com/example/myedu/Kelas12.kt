package com.example.myedu

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.kelas12.Kelas12Adapter
import com.example.myedu.kelas12.kls12List
import com.example.myedu.kelas12.Kelas12Data

class Kelas12 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var kelas12Adapter: Kelas12Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelas12)

        recyclerView = findViewById(R.id.rv_item)

        kelas12Adapter = Kelas12Adapter(kls12List.kls12DataValue)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = kelas12Adapter

        kelas12Adapter.setOnItemClickCallback(object : Kelas12Adapter.OnItemClickCallback {
            override fun onItemClicked(data: Kelas12Data) {
                // Check if the clicked item is the first item
                if (data.nama == "Matematika Wajib dan Minat") {
                    val intent = Intent(this@Kelas12, ChildKelas12::class.java)
                    startActivity(intent)
                }

                if (data.nama == "Bahasa Inggris") {
                    val intent = Intent(this@Kelas12, Binggris::class.java)
                    startActivity(intent)
                }

                if (data.nama == "Bahasa Indonesia") {
                    val intent = Intent(this@Kelas12, Bindonesia::class.java)
                    startActivity(intent)
                }

                if (data.nama == "PKN") {
                    val intent = Intent(this@Kelas12, PKN::class.java)
                    startActivity(intent)
                }

                if (data.nama == "Kimia") {
                    val intent = Intent(this@Kelas12, Kimia::class.java)
                    startActivity(intent)
                }

                else {
                    Toast.makeText(this@Kelas12, "Clicked: ${data.nama}", Toast.LENGTH_SHORT).show()
                }
            }

        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
