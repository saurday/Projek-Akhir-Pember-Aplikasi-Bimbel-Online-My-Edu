package com.example.myedu.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPost(notesEntity: NotesEntity)

    @Query("SELECT * FROM NotesEntity ORDER BY id DESC")
    fun getAllPost() : LiveData<List<NotesEntity>>

    @Update
    fun updatePost(notesEntity: NotesEntity)

    @Delete
    fun deletePost(notesEntity: NotesEntity)

}