package com.season.winter.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.season.winter.ui.theme.ComposeNoteAppTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CardNoteContent(
    modifier: Modifier = Modifier,
    content: String,
    onClickItem: () -> Unit = { },
    onClickDelete: () -> Unit = { }
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 7.dp
        ),
        onClick = { onClickItem() },
        modifier = modifier
            .padding(
                vertical = 6.dp,
            )
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {
            Text(
                text = content
            )
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = { onClickDelete() }
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "DeleteButton"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun PreviewCardNoteContent() {
    ComposeNoteAppTheme {
        val text = "aasda aasda aasda aasda sd asd asd asda sd asd a asa as as a aasa s as  asa s"
        CardNoteContent(content = text)
    }
}
