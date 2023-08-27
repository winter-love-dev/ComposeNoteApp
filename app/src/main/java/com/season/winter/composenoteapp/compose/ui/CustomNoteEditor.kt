package com.season.winter.composenoteapp.compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.season.winter.composenoteapp.compose.ui.theme.ComposeNoteAppTheme

@Composable
@ExperimentalComposeUiApi
fun CustomNoteEditor(
    modifier: Modifier = Modifier,
    defaultValue: String = "",
    isEditMode: Boolean = false,
    hideKeyboardToSubmit: Boolean = false,
    onDeleteAll: () -> Unit = { },
    onSubmit: (String) -> Unit = { },
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val (inputValue, setInputValue) = remember {
        mutableStateOf(defaultValue)
    }
    Card(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 7.dp
        ),
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(16.dp)
            ,
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = inputValue,
                onValueChange = setInputValue,
                trailingIcon = @Composable {
                    IconButton(
                        onClick = {
                            if (hideKeyboardToSubmit)
                                keyboardController?.hide()

                            if (inputValue.isNotEmpty()) {
                                    onSubmit(inputValue)
                                setInputValue("")
                            }
                        }
                    ) {
                        Icon(
                            imageVector =
                                if (isEditMode)
                                    Icons.Default.Edit
                                else
                                    Icons.Default.Send,
                            contentDescription = "submit or submit edit button"
                        )
                    }
                },
                maxLines = 10
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                if (isEditMode) {
                    Spacer(modifier = Modifier)
                }
                else {
                    Button(
                        onClick = {
                            if (inputValue.isNotEmpty())
                                setInputValue("")
                            onDeleteAll()
                        }
                    ) {
                        Text(
                            "Delete All"
                        )
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = { keyboardController?.hide() }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "keyboard down button"
                    )
                }
                IconButton(
                    onClick = {
                        if (inputValue.isNotEmpty())
                            setInputValue("")
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "text clear button"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
@ExperimentalComposeUiApi
fun CustomNoteEditorPreview() {
    ComposeNoteAppTheme {
        CustomNoteEditor()
    }
}
