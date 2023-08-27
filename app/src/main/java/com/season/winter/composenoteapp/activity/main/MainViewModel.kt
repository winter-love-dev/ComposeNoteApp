package com.season.winter.composenoteapp.activity.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.season.winter.composenoteapp.model.NoteEntity
import com.season.winter.composenoteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val noteRepository: NoteRepository
): ViewModel() {

    val noteListFlow: Flow<List<NoteEntity>> =
        noteRepository.getNotes()

    fun addNote(text: String) {
        val note = NoteEntity(
            content = text
        )
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

    fun getScrollTopPosition(
        listSize: Int,
        onPosition: (topPosition: Int) -> Unit
    ) {
        val topPosition = listSize + defaultStaggeredGridSpaceCount
        onPosition(topPosition)
    }

    fun removeNote(note: NoteEntity) {
        viewModelScope.launch {
            noteRepository.removeNote(note)
        }
    }

    fun removeAllNote() {
        viewModelScope.launch {
            noteRepository.removeAllNote()
        }
    }

    fun editNote(id: Long, text: String) {
        viewModelScope.launch {
            noteRepository.editNote(id, text)
        }
    }

    companion object {

        // position
        const val defaultStaggeredGridSpaceCount = 10
    }
}