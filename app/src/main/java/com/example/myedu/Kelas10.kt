package com.example.myedu

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Kelas10 : AppCompatActivity() {

    private lateinit var recyclerViewGrid: RecyclerView
    private lateinit var recyclerviewHorizontal: RecyclerView
    private lateinit var AdapterGrid: AdapterGrid
    private lateinit var AdapterHorizontal: AdapterHorizontal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kelas10)

        // Menghubungkan variabel dengan komponen di layout
        recyclerViewGrid = findViewById(R.id.rv_grid)
        recyclerviewHorizontal = findViewById(R.id.rv_horizontal)

        /// Menginisialisasi semua adapter dengan data
        AdapterGrid = AdapterGrid(MapelDataList.mapelDataValue)
        AdapterHorizontal = AdapterHorizontal(MapelDataList.mapelDataValue)

        // Menampilkan RecyclerView
        showRecyclerList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun showRecyclerList() {
        // Mengatur layoutManager dan adapter untuk RecyclerView
        recyclerViewGrid.layoutManager = GridLayoutManager(this, 2)
        recyclerViewGrid.adapter = AdapterGrid

        // Mengatur layoutManager dan adapter untuk RecyclerView horizontal
        recyclerviewHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerviewHorizontal.adapter = AdapterHorizontal

        AdapterGrid.setOnItemClickCallback(object : AdapterGrid.OnItemClickCallback {
            override fun onItemClicked(data: MapelData) {
            }
        })

        AdapterHorizontal.setOnItemClickCallback(object : AdapterHorizontal.OnItemClickCallback {
            override fun onItemClicked(data: MapelData) {
            }
        })
    }

}