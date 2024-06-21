package com.example.myedu

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.child.ChildAdapter
import com.example.myedu.child.ChildData
import com.example.myedu.child.ChildList

class ChildKelas12 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var childAdapter: ChildAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child_kelas12)

        recyclerView = findViewById(R.id.rv_item_child)

        childAdapter = ChildAdapter(ChildList.ChildDataValue)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = childAdapter

        childAdapter.setOnItemClickCallback(object : ChildAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ChildData) {
                Toast.makeText(this@ChildKelas12, "Clicked: ${data.nama}", Toast.LENGTH_SHORT).show()
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
