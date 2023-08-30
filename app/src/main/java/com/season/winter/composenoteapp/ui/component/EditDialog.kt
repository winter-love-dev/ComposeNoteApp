package com.season.winter.composenoteapp.ui.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
) {
    var valueChange by remember {
        mutableStateOf(noteContent)
    }
    val diffValue by remember {
        derivedStateOf { valueChange != noteContent }
    }

    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            CardNoteTextField(
                isEditMode = true,
                value = valueChange,
                onValueChange = {
                    valueChange = it
                },
                onSubmit = { onEdit(it) },
            )
        },
        confirmButton = {
            TextButton(
                enabled = diffValue,
                onClick = {
                    onEdit(valueChange)
                }
            ) {
                Text("Update")
            }
        },
        onDismissRequest = {
            onDismissRequest()
        },
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
