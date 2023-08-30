package com.season.winter.core.data.main.repository.note

import android.util.Log
import com.season.winter.core.data.main.database.note.NoteDatabaseDao
import com.season.winter.core.data.main.database.note.NoteEntity
import com.season.winter.core.main.NoteRepository
import com.season.winter.core.main.model.NoteInfoEntity
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

class NoteRepositoryImpl @Inject constructor(
    private val noteDatabaseDao: NoteDatabaseDao,
): NoteRepository {

    override fun flowNotes(): Flow<List<NoteInfoEntity>> =
        noteDatabaseDao.getNotes()
            .onEach {
                Log.w("TEMP", "aaa ${Thread.currentThread()}")
            }
            .map {
                it.map {
                    NoteInfoEntity(
                        id = it.id,
                        content = it.content,
                    )
                }
            }

    override suspend fun addNote(note: NoteInfoEntity) {
        noteDatabaseDao.addNote(
            NoteEntity(
                content = note.content
            )
        )
    }

    override suspend fun removeNote(id: Long) {
        noteDatabaseDao.removeNote(id = id)
    }

    override suspend fun editNote(id: Long, noteContent: String) {
        noteDatabaseDao.editNote(id, noteContent)
    }

    override suspend fun removeAllNote() {
        noteDatabaseDao.removeAllNote()
    }
}