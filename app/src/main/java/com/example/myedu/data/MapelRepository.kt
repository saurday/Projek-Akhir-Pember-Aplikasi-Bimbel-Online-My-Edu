package com.example.myedu.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapelRepository {
    private val _listMapel = MutableLiveData<List<Mapel>>()
    val listMapel: LiveData<List<Mapel>> = _listMapel

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _mapel = MutableLiveData<ApiResponse>() // Ensure this matches what MapelViewModel expects
    val mapel: LiveData<ApiResponse> = _mapel

    fun getAllMapel() {
        _isLoading.value = true
        val service = ApiConfig.getApiService().getAllMapel()
        service.enqueue(object : Callback<List<Mapel>> {
            override fun onResponse(call: Call<List<Mapel>>, response: Response<List<Mapel>>) {
                _isLoading.value = false
                if (response.isSuccessful && response.body() != null) {
                    _listMapel.value = response.body()
                } else {
                    Log.e("Error on Response", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Mapel>>, t: Throwable) {
                _isLoading.value = false
                Log.e("Error on Failure", "onFailure: ${t.message}")
            }
        })
    }

    fun getDetailMapel(id: String) {
        _isLoading.value = true
        val service = ApiConfig.getApiService().getDetailMapel(id)
        service.enqueue(object : Callback<Mapel> {
            override fun onResponse(call: Call<Mapel>, response: Response<Mapel>) {
                _isLoading.value = false
                if (response.isSuccessful && response.body() != null) {
                    // Update _mapel LiveData with ApiResponse, adjust as per your API response structure
                } else {
                    Log.e("Error on Response", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Mapel>, t: Throwable) {
                _isLoading.value = false
                Log.e("Error on Failure", "onFailure: ${t.message}")
            }
        })
    }
}
