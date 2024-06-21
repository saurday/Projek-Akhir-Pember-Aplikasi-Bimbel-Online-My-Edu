package com.example.myedu

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.data.ApiConfig
import com.example.myedu.data.Mapel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Kelas11 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var mapelAdapter: MapelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kelas11)

        recyclerView = findViewById(R.id.rv_item)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getAllMapel()
    }

    private fun getAllMapel() {
        val client = ApiConfig.getApiService().getAllMapel()
        client.enqueue(object : Callback<List<Mapel>> {
            override fun onResponse(call: Call<List<Mapel>>, response: Response<List<Mapel>>) {
                if (response.isSuccessful) {
                    val mapelList = response.body() ?: emptyList()
                    mapelAdapter = MapelAdapter(this@Kelas11, mapelList)
                    recyclerView.adapter = mapelAdapter
                } else {
                    Log.e("API Response", "Response not successful: ${response.code()}")
                    Toast.makeText(this@Kelas11, "Gagal mendapatkan data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Mapel>>, t: Throwable) {
                Log.e("API Request", "Gagal terhubung ke server", t)
                Toast.makeText(this@Kelas11, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
