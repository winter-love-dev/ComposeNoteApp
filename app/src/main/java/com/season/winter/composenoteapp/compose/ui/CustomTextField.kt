package com.season.winter.composenoteapp.compose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.season.winter.composenoteapp.compose.ui.theme.ComposeNoteAppTheme

@Composable
@ExperimentalComposeUiApi
fun CustomTextField(
    defaultValue: String = "",
    hideKeyboardToSubmit: Boolean = true,
    onSubmit: (String) -> Unit = { },
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val (value, setValue) = remember {
        mutableStateOf(defaultValue)
    }

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(16.dp)
        ,
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
                value = value,
                onValueChange = setValue
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier
                    .align(alignment = Alignment.End)
                ,
                onClick = {
                    if (hideKeyboardToSubmit)
                        keyboardController?.hide()

                    if (value.isNotEmpty()) {
                        onSubmit(value)
                        setValue("")
                    }
                }
            ) {
                Text(text = "Submit")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
@ExperimentalComposeUiApi
fun CustomTextFieldPreview() {
    ComposeNoteAppTheme {
        CustomTextField()
    }
}
