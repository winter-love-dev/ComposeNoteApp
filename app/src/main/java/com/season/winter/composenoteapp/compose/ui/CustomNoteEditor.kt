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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.season.winter.composenoteapp.compose.ui.theme.ComposeNoteAppTheme

@Composable
@ExperimentalComposeUiApi
fun CustomNoteEditor(
    modifier: Modifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .padding(16.dp)
    ,
    keyboardController: SoftwareKeyboardController? =
        LocalSoftwareKeyboardController.current,
    defaultValue: String = "",
//    isEditMode: Boolean = false,
//    editValue: String = "",
//    onEditSubmit: (String) -> Unit = { },
//    onClickCancelEdit: (String) -> Unit = { },
    hideKeyboardToSubmit: Boolean = false,
    onSubmit: (String) -> Unit = { },
) {
    val (inputValue, setInputValue) = remember {
        mutableStateOf(defaultValue)
    }
//    var setEditValue by remember {
//        mutableStateOf(false)
//    }
//    if (isEditMode && setEditValue.not()) {
//        setEditValue = true
//        setInputValue(editValue)
//    }
    Card(
        modifier = modifier,
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
//                                if (isEditMode)
//                                    onEditSubmit(inputValue)
//                                else
                                    onSubmit(inputValue)
                                setInputValue("")
                            }
                        }
                    ) {
                        Icon(
                            imageVector =
//                                if (isEditMode)
//                                    Icons.Default.Edit
//                                else
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
                IconButton(
                    onClick = { keyboardController?.hide() }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "keyboard down button"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {
                        if (inputValue.isNotEmpty())
                            setInputValue("")
                    }
                ) {
                    Icon(
                        imageVector =
//                            if (isEditMode)
//                                Icons.Default.Close
//                            else
                                Icons.Default.Delete,
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
