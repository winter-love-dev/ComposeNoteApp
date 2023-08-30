package com.season.winter.composenoteapp.features.main.model

import androidx.compose.runtime.Immutable

@Immutable
data class NoteItem(
    val id: Long,
    val content: String,
)