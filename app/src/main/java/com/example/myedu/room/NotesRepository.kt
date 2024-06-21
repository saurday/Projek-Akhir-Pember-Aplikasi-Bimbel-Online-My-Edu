package com.example.myedu.room

import androidx.lifecycle.LiveData
import com.example.myedu.utils.AppExecutors

class NotesRepository private constructor(
    // Variabel appDao adalah instance dari PeopleDao yang akan digunakan untuk mengakses database.
    private val notesDao: NotesDao,
    // Variabel appExecutors adalah instance dari AppExecutors yang akan digunakan untuk menjalankan operasi database di thread yang berbeda dari thread UI.
    private val appExecutors: AppExecutors
) {

    // Fungsi getAllPeople digunakan untuk mendapatkan semua data orang dari database.
    // Fungsi ini mengembalikan LiveData yang berisi daftar semua orang.
    fun getAllPost(): LiveData<List<NotesEntity>> = notesDao.getAllPost()

    // Fungsi insertPlayer digunakan untuk memasukkan data orang ke dalam database.
    // Fungsi ini menjalankan operasi insert di thread yang berbeda dari thread UI menggunakan AppExecutors.
    fun insertPost(notesEntity: NotesEntity) {
        appExecutors.diskIO().execute { notesDao.insertPost(notesEntity) }
    }

    fun updatePost(notesEntity: NotesEntity) {
        appExecutors.diskIO().execute { notesDao.updatePost(notesEntity) }
    }

    fun deletePost(notesEntity: NotesEntity) {
        appExecutors.diskIO().execute { notesDao.deletePost(notesEntity) }
    }

    // Ini adalah objek companion yang berisi fungsi getInstance.
    // Fungsi getInstance digunakan untuk mendapatkan instance dari PeopleRepository.
    // Jika instance sudah ada, fungsi ini akan mengembalikan instance tersebut.
    // Jika instance belum ada, fungsi ini akan membuat instance baru.
    companion object {
        @Volatile
        private var instance: NotesRepository? = null

        fun getInstance(
            notesDao: NotesDao,
            appExecutors: AppExecutors
        ): NotesRepository =
        // Jika instance sudah ada, kembalikan instance tersebut.
            // Jika instance belum ada, buat instance baru.
            instance ?: synchronized(this) {
                instance ?: NotesRepository(notesDao, appExecutors)
            }.also { instance = it }

    }
}