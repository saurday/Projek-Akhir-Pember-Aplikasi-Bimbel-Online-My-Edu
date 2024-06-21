package com.example.myedu.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NotesViewModel (private val notesRepository: NotesRepository) : ViewModel() {

    // Fungsi insertPeople digunakan untuk memasukkan data orang ke dalam database.
    // Fungsi ini menerima parameter berupa objek PeopleEntity dan memanggil fungsi insertPlayer dari PeopleRepository.
    fun insertPost(notesEntity: NotesEntity) {
        notesRepository.insertPost(notesEntity)
    }


    // Fungsi getAllPeople digunakan untuk mendapatkan semua data orang dari database.
    // Fungsi ini mengembalikan LiveData yang berisi daftar semua orang.
    // LiveData adalah kelas dari Android Architecture Components yang memungkinkan kita untuk mengamati perubahan data dalam database dan secara otomatis memperbarui UI jika ada perubahan.
    fun getAllPost(): LiveData<List<NotesEntity>> {
        return notesRepository.getAllPost()
    }

    fun updatePost(notesEntity: NotesEntity) {
        notesRepository.updatePost(notesEntity)
    }

    fun deletePost(notesEntity: NotesEntity) {
        notesRepository.deletePost(notesEntity)
    }

}