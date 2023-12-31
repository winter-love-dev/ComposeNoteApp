package com.season.winter.core.main

import com.season.winter.core.main.model.NoteInfoEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun flowNotes(): Flow<List<NoteInfoEntity>>

    suspend fun addNote(note: NoteInfoEntity)

    suspend fun removeNote(id: Long)

    suspend fun editNote(id: Long, noteContent: String)

    suspend fun removeAllNote()
}