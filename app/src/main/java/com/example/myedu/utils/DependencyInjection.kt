package com.example.myedu.utils

import android.content.Context
import com.example.myedu.room.NotesDatabase
import com.example.myedu.room.NotesRepository

object DependencyInjection {
    fun provideRepository(context: Context): NotesRepository {
        val database = NotesDatabase.getDatabase(context)
        val appExecutors = AppExecutors()
        val dao = database.notesDao()
        return NotesRepository.getInstance(dao, appExecutors)
    }
}