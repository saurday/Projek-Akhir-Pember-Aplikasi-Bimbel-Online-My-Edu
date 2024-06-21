package com.example.myedu

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.binggris.BingAdapter
import com.example.myedu.binggris.BingData
import com.example.myedu.binggris.BingList

class Binggris : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var bingAdapter: BingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binggris)

        recyclerView = findViewById(R.id.rv_item_bing)

        bingAdapter = BingAdapter(this, BingList.BingDataValue)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = bingAdapter

        bingAdapter.setOnItemClickCallback(object : BingAdapter.OnItemClickCallback {
            override fun onItemClicked(data: BingData) {
                Toast.makeText(this@Binggris, "Clicked: ${data.nama}", Toast.LENGTH_SHORT).show()
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
