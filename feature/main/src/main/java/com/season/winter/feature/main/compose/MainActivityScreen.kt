package com.season.winter.feature.main.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.season.winter.feature.main.compose.component.EditMode
import com.season.winter.feature.main.model.NoteItem
import com.season.winter.feature.main.viewmodel.MainViewModel
import com.season.winter.ui.component.CardNoteContent
import com.season.winter.ui.component.CardNoteTextField
import com.season.winter.ui.theme.ComposeNoteAppTheme
import tech.thdev.compose.extensions.keyboard.state.foundation.collectIsKeyboardAsState
import tech.thdev.compose.extensions.keyboard.state.localowners.LocalMutableExKeyboardStateSourceOwner

@Composable
@ExperimentalComposeUiApi
fun MainActivityScreen(
    noteList: List<NoteItem>,
    viewModel: MainViewModel = viewModel()
) {
    MainActivityScreen(
        noteList = noteList,
        onSubmit = {
            viewModel.addNote(it)
        },
        onClickDelete = { item ->
            viewModel.removeNote(item)
        },
        onClickEdit = { item ->
            viewModel.showEdit(item)
        }
    )

    EditMode()
}

@Composable
@ExperimentalComposeUiApi
internal fun MainActivityScreen(
    noteList: List<NoteItem>,
    onSubmit: (String) -> Unit = { },
    onClickDelete: (NoteItem) -> Unit = { },
    onClickEdit: (NoteItem) -> Unit = { },
) {
    val listState = rememberLazyStaggeredGridState()
    val keyboardState = LocalMutableExKeyboardStateSourceOwner.current

    val state by keyboardState.collectIsKeyboardAsState()

    LaunchedEffect(noteList) {
        listState.animateScrollToItem(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "show keyboard".takeIf { state } ?: "hide keyboard"
        )

        CardNoteTextField(
            onSubmit = onSubmit,
            onValueChange = {
                // todo
            }
        )

        LazyVerticalStaggeredGrid(
            state = listState,
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalItemSpacing = 16.dp,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            itemsIndexed(noteList) { index, item ->
                CardNoteContent(
                    content = item.content,
                    onClickItem = {
                        onClickEdit(item)
                    },
                    onClickDelete = {
                        onClickDelete(item)
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@ExperimentalComposeUiApi
@Composable
internal fun MainActivityPreview() {
    ComposeNoteAppTheme {
        MainActivityScreen(
            noteList = listOf(
                NoteItem(-1, "content"),
            )
        )
    }
}