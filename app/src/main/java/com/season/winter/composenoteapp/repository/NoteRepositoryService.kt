package com.season.winter.composenoteapp.repository

import com.season.winter.composenoteapp.model.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepositoryService {
    fun getNotes(): Flow<List<NoteEntity>>

    suspend fun addNote(note: NoteEntity)

    suspend fun removeNote(note: NoteEntity)

    suspend fun editNote(id: Long, noteContent: String)

    suspend fun removeAllNote()
}