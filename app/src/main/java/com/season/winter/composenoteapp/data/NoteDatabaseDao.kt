package com.season.winter.composenoteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.season.winter.composenoteapp.model.NoteEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDatabaseDao {

    @Query("SELECT * FROM note_entity ORDER BY id DESC")
    fun getNotes(): Flow<List<NoteEntity>>

    @Insert
    suspend fun addNote(note: NoteEntity)

    @Query("UPDATE note_entity SET content = :noteContent WHERE id =:id")
    suspend fun editNote(id: Long, noteContent: String)

    @Delete
    suspend fun removeNote(note: NoteEntity)

    @Query("DELETE FROM note_entity")
    suspend fun removeAllNote()
}