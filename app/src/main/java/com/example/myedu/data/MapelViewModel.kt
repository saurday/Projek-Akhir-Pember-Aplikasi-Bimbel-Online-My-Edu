package com.example.myedu.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MapelViewModel(private val mapelRepository: MapelRepository) : ViewModel() {
    val listMapel: LiveData<List<Mapel>> = mapelRepository.listMapel
    val isLoading: LiveData<Boolean> = mapelRepository.isLoading
    val mapel: LiveData<ApiResponse> = mapelRepository.mapel // Adjusted to match MapelRepository

    fun getAllMapel() {
        mapelRepository.getAllMapel()
    }

    fun getDetailMapel(id: String) {
        mapelRepository.getDetailMapel(id)
    }
}
