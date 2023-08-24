package com.season.winter.composenoteapp.activity.main

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.season.winter.composenoteapp.model.NoteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel() {

    var noteList = mutableStateListOf<NoteEntity>()
        private set

    // position
    val defaultStaggeredGridSpaceCount = 10
    private val _scrollTopPosition = mutableIntStateOf(defaultStaggeredGridSpaceCount)
    val scrollTopPosition: State<Int> = _scrollTopPosition

    fun addNote(text: String) {
        val note = NoteEntity(
            content = text
        )
        noteList.add(note)
        setScrollTopPosition()
    }

    private fun setScrollTopPosition() {
        _scrollTopPosition.intValue =
            noteList.size + defaultStaggeredGridSpaceCount
    }

    fun removeNote(note: NoteEntity) {
        noteList.remove(note)
    }

    fun editNote(index: Int, text: String) {
        val note = NoteEntity(
            content = text
        )
        noteList[index] = note
    }
}