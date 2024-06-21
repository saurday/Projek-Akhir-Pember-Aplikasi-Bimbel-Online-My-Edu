package com.example.myedu

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.binggris.BingAdapter
import com.example.myedu.binggris.BingData
import com.example.myedu.binggris.BingList
import com.example.myedu.pkn.PKNAdapter
import com.example.myedu.pkn.PKNData
import com.example.myedu.pkn.PKNList

class PKN : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var pknAdapter: PKNAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pkn)

        recyclerView = findViewById(R.id.rv_item_pkn)

        pknAdapter = PKNAdapter(this, PKNList.PKNDataValue)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = pknAdapter

        pknAdapter.setOnItemClickCallback(object : PKNAdapter.OnItemClickCallback {
            override fun onItemClicked(data: PKNData) {
                Toast.makeText(this@PKN, "Clicked: ${data.nama}", Toast.LENGTH_SHORT).show()
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}