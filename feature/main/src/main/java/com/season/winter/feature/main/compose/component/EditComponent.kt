package com.season.winter.feature.main.compose.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.season.winter.feature.main.model.NoteItem
import com.season.winter.feature.main.viewmodel.MainViewModel
import com.season.winter.ui.theme.ComposeNoteAppTheme

@Composable
internal fun EditMode(
    viewModel: MainViewModel = viewModel(),
) {
    val item by viewModel.showEdit.collectAsStateWithLifecycle(initialValue = null)


    EditMode(
        item = item,
        onEditNote = { id, content ->
            viewModel.editNote(id, content)
        },
    )
}

@Composable
internal fun EditMode(
    item: NoteItem?,
    onEditNote: (Long, String) -> Unit = { _, _ -> },
) {
    var editNotePositionForDialog by remember(item) { mutableStateOf(item) }
    if (editNotePositionForDialog != null) {

        val content = editNotePositionForDialog!!.content
        val id = editNotePositionForDialog!!.id

        com.season.winter.ui.component.EditDialog(
            onDismissRequest = { editNotePositionForDialog = null },
            dialogTitle = "Edit Note",
            icon = Icons.Default.Info,
            noteContent = content,
            onEdit = { noteContent ->
                onEditNote(id, noteContent)
                editNotePositionForDialog = null
            }
        )
    }
}

@Preview
@Composable
internal fun PreviewEditMode() {
    ComposeNoteAppTheme {
        EditMode(
            item = NoteItem(0, "edit mode")
        )
    }
}

@Preview
@Composable
internal fun PreviewEditModeHide() {
    ComposeNoteAppTheme {
        EditMode(
            item = null,
        )
    }
}