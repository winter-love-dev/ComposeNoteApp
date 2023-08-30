package com.season.winter.feature.main.model

import androidx.compose.runtime.Immutable

@Immutable
data class NoteItem(
    val id: Long,
    val content: String,
)