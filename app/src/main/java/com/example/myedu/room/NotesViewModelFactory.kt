package com.example.myedu.room

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myedu.utils.DependencyInjection

class NotesViewModelFactory private constructor(private val notesRepository: NotesRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesViewModel::class.java)) {
            return NotesViewModel(notesRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: NotesViewModelFactory? = null
        fun getInstance(context: Context): NotesViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: NotesViewModelFactory(DependencyInjection.provideRepository(context))
            }.also { instance = it }
    }
}