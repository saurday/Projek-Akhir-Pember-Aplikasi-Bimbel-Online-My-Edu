package com.example.myedu

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.bindo.BinAdapter
import com.example.myedu.bindo.BinData
import com.example.myedu.bindo.BinList
import com.example.myedu.binggris.BingAdapter
import com.example.myedu.binggris.BingData
import com.example.myedu.binggris.BingList

class Bindonesia : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binAdapter: BinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bindonesia)

        recyclerView = findViewById(R.id.rv_item_bin)

        binAdapter = BinAdapter(BinList.BinDataValue)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = binAdapter

        binAdapter.setOnItemClickCallback(object : BinAdapter.OnItemClickCallback {
            override fun onItemClicked(data: BinData) {
                Toast.makeText(this@Bindonesia, "Clicked: ${data.nama}", Toast.LENGTH_SHORT).show()
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}