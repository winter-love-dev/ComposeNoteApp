package com.season.winter.composenoteapp.repository

import com.season.winter.composenoteapp.data.NoteDatabaseDao
import com.season.winter.composenoteapp.model.NoteEntity
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDatabaseDao: NoteDatabaseDao
): NoteRepositoryService {

    override fun getNotes() = noteDatabaseDao.getNotes()
    override suspend fun addNote(note: NoteEntity) {
        noteDatabaseDao.addNote(note)
    }

    override suspend fun removeNote(note: NoteEntity) {
        noteDatabaseDao.removeNote(note)
    }

    override suspend fun editNote(id: Long, noteContent: String) {
        noteDatabaseDao.editNote(id, noteContent)
    }

    override suspend fun removeAllNote() {
        noteDatabaseDao.removeAllNote()
    }

}