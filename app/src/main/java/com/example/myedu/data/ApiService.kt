package com.example.myedu.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("myedu")
    fun getAllMapel(): Call<List<Mapel>> // Mengembalikan daftar Mapel

    @GET("myedu/{id}")
    fun getDetailMapel(@Path("id") id: String): Call<Mapel> // Mengembalikan satu Mapel berdasarkan id
}
