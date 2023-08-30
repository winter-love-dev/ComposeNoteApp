package com.season.winter.composenoteapp.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.input.rotary.onRotaryScrollEvent
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.season.winter.composenoteapp.ui.theme.ComposeNoteAppTheme

@Composable
@ExperimentalComposeUiApi
fun CardNoteTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    isEditMode: Boolean = false,
    hideKeyboardToSubmit: Boolean = false,
    onValueChange: (String) -> Unit = {},
    onSubmit: (String) -> Unit = { },
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    var valueChange by remember {
        mutableStateOf(value)
    }
    val inputValueIsNotEmpty by remember {
        derivedStateOf { valueChange.isNotEmpty() }
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 7.dp,
        ),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextField(
                value = valueChange,
                onValueChange = {
                    valueChange = it
                    onValueChange(it)
                },
                trailingIcon = @Composable {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        if (inputValueIsNotEmpty) {
                            IconButton(onClick = {
                                valueChange = ""
                                onValueChange("")
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "clear",
                                )
                            }
                        }

                        IconButton(
                            enabled = inputValueIsNotEmpty,
                            onClick = {
                                if (hideKeyboardToSubmit)
                                    keyboardController?.hide()

                                if (inputValueIsNotEmpty) {
                                    onSubmit(valueChange)
                                    valueChange = ""
                                    onValueChange("")
                                }
                            }
                        ) {
                            Icon(
                                imageVector = if (isEditMode)
                                    Icons.Default.Edit
                                else
                                    Icons.Default.Send,
                                contentDescription = "submit or submit edit button"
                            )
                        }
                    }
                },
                maxLines = 10,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
@ExperimentalComposeUiApi
internal fun PreviewCardNoteTextField() {
    ComposeNoteAppTheme {
        Column {
            CardNoteTextField(
                value = "gg",
                onValueChange = {

                }
            )

            CardNoteTextField(
                value = "",
                onValueChange = {

                }
            )
        }
    }
}
