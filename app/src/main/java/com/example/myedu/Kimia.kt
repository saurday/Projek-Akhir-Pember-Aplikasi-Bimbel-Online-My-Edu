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
import com.example.myedu.kimia.KimiaAdapter
import com.example.myedu.kimia.KimiaData
import com.example.myedu.kimia.KimiaList

class Kimia : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var kimiaAdapter: KimiaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kimia)

        recyclerView = findViewById(R.id.rv_item_kimia)

        kimiaAdapter = KimiaAdapter(this, KimiaList.KimiaDataValue)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = kimiaAdapter

        kimiaAdapter.setOnItemClickCallback(object : KimiaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: KimiaData) {
                Toast.makeText(this@Kimia, "Clicked: ${data.nama}", Toast.LENGTH_SHORT).show()
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}