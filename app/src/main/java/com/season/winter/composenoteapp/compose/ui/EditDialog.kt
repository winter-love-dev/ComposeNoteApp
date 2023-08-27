package com.season.winter.composenoteapp.compose.ui

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun EditDialog(
    dialogTitle: String = "EditNote",
    icon: ImageVector,
    noteContent: String,
    onEdit: (noteContent: String) -> Unit,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            CustomNoteEditor(
                isEditMode = true,
                defaultValue = noteContent,
                onSubmit = { onEdit(it) },
            )
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = { },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}
