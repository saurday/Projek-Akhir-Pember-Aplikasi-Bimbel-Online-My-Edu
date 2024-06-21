package com.example.myedu.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MapelViewModelFactory private constructor(private val mapelRepository: MapelRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MapelViewModel::class.java)) {
            return MapelViewModel(mapelRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: MapelViewModelFactory? = null
        fun getInstance(): MapelViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: MapelViewModelFactory(MapelRepository())
            }.also { instance = it }
    }
}
