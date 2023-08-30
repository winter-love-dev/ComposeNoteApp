package com.season.winter.feature.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.season.winter.core.main.NoteRepository
import com.season.winter.feature.main.model.NoteItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
) : ViewModel() {

    val noteListFlow: Flow<List<NoteItem>> =
        noteRepository.flowNotes()
            .flowOn(Dispatchers.Main.immediate)
            .onEach {
                Log.w("TEMP", "... ${Thread.currentThread()}")
            }
            .onEach {
                Log.i("TEMP", "it ${Thread.currentThread()}")
            }
            .flowOn(Dispatchers.Default)
            .onEach {
                Log.w("TEMP", "... ${Thread.currentThread()}")
            }
            .map {
                it.map {
                    NoteItem(
                        id = it.id,
                        content = it.content,
                    )
                }
            }

    private val _showEdit = MutableSharedFlow<NoteItem>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val showEdit: SharedFlow<NoteItem> get() = _showEdit.asSharedFlow()

    fun addNote(text: String) = viewModelScope.launch {
        val note = com.season.winter.core.main.model.NoteInfoEntity(
            content = text,
            id = -1,
        )
        noteRepository.addNote(note)
    }

    fun removeNote(note: NoteItem) = viewModelScope.launch {
        noteRepository.removeNote(note.id)
    }

    fun removeAllNote() = viewModelScope.launch {
        noteRepository.removeAllNote()
    }

    fun editNote(id: Long, text: String) = viewModelScope.launch {
        noteRepository.editNote(id, text)
    }

    fun showEdit(item: NoteItem) {
        _showEdit.tryEmit(item)
    }
}