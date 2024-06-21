package com.example.myedu.data

import com.google.gson.annotations.SerializedName

data class Mapel(
    @SerializedName("mapel") val mapel: String,
    @SerializedName("deskripsi") val deskripsi: String,
    @SerializedName("gambar") val gambar: String,
    @SerializedName("id") val id: String
)
