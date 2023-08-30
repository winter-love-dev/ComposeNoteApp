package com.season.winter.composenoteapp.features.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.season.winter.composenoteapp.features.main.compose.MainActivityScreen
import dagger.hilt.android.AndroidEntryPoint
import tech.thdev.compose.extensions.keyboard.state.MutableExKeyboardStateSource
import tech.thdev.compose.extensions.keyboard.state.foundation.removeFocusWhenKeyboardIsHidden
import tech.thdev.compose.extensions.keyboard.state.localowners.LocalMutableExKeyboardStateSourceOwner

@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val noteList by viewModel.noteListFlow.collectAsStateWithLifecycle(
                initialValue = emptyList()
            )
            val noteIsNotEmpty by remember(noteList.size) {
                mutableStateOf(noteList.isNotEmpty())
            }

            CompositionLocalProvider(
                LocalMutableExKeyboardStateSourceOwner provides MutableExKeyboardStateSource(),
            ) {
                Scaffold(
                    floatingActionButton = {
                        Button(
                            enabled = noteIsNotEmpty,
                            onClick = {
                                viewModel.removeAllNote()
                            },
                            modifier = Modifier
                                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                        ) {
                            Text(
                                "Clear all"
                            )
                        }
                    },
                    modifier = Modifier
                        .removeFocusWhenKeyboardIsHidden()
                ) { scaffoldPadding ->
                    Box(
                        modifier = Modifier
                            .padding(scaffoldPadding)
                    ) {
                        MainActivityScreen(
                            noteList = noteList,
                        )
                    }
                }
            }
        }
    }
}

/**
 * 학습 했던거 잠깐 기록 용으로 남겨두는 주석들
 */

/*
    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxWidth(),
        reverseLayout = true,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(viewModel.inputTextValue.size) { index ->
            CustomNoteCard(
                note = viewModel.inputTextValue[index],
                onClickItem = {
                    setEditorText(it.content)
                },
                onClickDelete = {
                    viewModel.removeNote(it)
                }
            )
        }
    }*/

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview2() {
//    ComposeNoteAppTheme {
////        ImageCard()
//    }
//}

//

//Column(
//modifier = Modifier.fillMaxSize(),
//verticalArrangement = Arrangement.Center,
//horizontalAlignment = Alignment.CenterHorizontally
//) {
//    Text(
//        text = viewModel.data.value,
//        fontSize = 30.sp
//    )
//    Button(onClick = {
//        viewModel.changeValue()
//    }) {
//        Text(text = "변경")
//    }
//}

/*@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onTabFavorite: (Boolean) -> Unit
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .padding(16.dp)
        ) {
            Image(
                modifier = Modifier.padding(16.dp),
                painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
                contentDescription = "poster",
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier.width(150.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                IconButton(
                    onClick = {
                        onTabFavorite(isFavorite.not())
                    }
                ) {
                        Icon(
                        imageVector =
                            if (isFavorite)
                                Icons.Default.Favorite
                            else
                                Icons.Default.FavoriteBorder
                        ,
                        contentDescription = "favorite"
                    )
                }
            }
        }
    }
}*/

//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContent {
//        val navController: NavHostController = rememberNavController()
//        NavHost(
//            navController = navController,
//            startDestination = "first",
//        ) {
//            composable("first") {
//                FirstScreen(navController)
//            }
//            composable("second") {
//                SecondScreen(navController)
//            }
//            composable("third/{value}") { backStackEntry ->
//                ThirdScreen(
//                    navController,
//                    backStackEntry.arguments?.getString("value") ?: "",
//                )
//            }
//        }
//    }
//}

//@Composable
//fun FirstScreen(navController: NavController) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        val (value, setValue) = remember {
//            mutableStateOf("")
//        }
//        Text(text = "첫화면")
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = {
//            navController.navigate("second")
//        }) {
//            Text(text = "두 번째")
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//        TextField(
//            value = value,
//            onValueChange = setValue
//        )
//        Button(onClick = {
//            if (value.isNotEmpty()) {
//                navController.navigate("third/$value")
//            }
//        }) {
//            Text(text = "세 번쨰")
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//    }
//}
//
//@Composable
//fun SecondScreen(navController: NavController) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "두번째 화면")
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = {
//            navController.popBackStack()
//        }) {
//            Text(text = "뒤로가기")
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//    }
//}
//
//@Composable
//fun ThirdScreen(navController: NavController, value: String) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "세 번째 화면")
//        Spacer(modifier = Modifier.height(16.dp))
//        Text(text = "value: $value")
//        Spacer(modifier = Modifier.height(16.dp))
//        Button(onClick = {
//            navController.popBackStack()
//        }) {
//            Text(text = "뒤로가기")
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//
//    }
//}

//            val (text, setValue) = remember {
//                mutableStateOf("")
//            }
//
//            val snackBarHostState = remember { SnackbarHostState() }
//            val scope = rememberCoroutineScope()
//            val keyboardController = LocalSoftwareKeyboardController.current
//
//            Scaffold(
//                snackbarHost = { SnackbarHost(snackBarHostState) },
//                content = { scaffoldPadding ->
//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(scaffoldPadding)
//                        ,
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                    ) {
//                        TextField(
//                            value = text,
//                            onValueChange = setValue
//                        )
//                        Button(
//                            onClick = {
//                                keyboardController?.hide()
//                                scope.launch {
//                                    snackBarHostState.showSnackbar(
//                                        message = text,
//                                        actionLabel = "Click me",
//                                        duration = SnackbarDuration.Short
//                                    )
//                                }
//                            }
//                        ) {
//                            Text("클릭!!")
//                        }
//                    }
//                }
//            )


//            var isFavorite by rememberSaveable {
//                mutableStateOf(false)
//            }
//            ImageCard(
//                modifier = Modifier
//                    .fillMaxWidth(0.5f)
//                    .padding(16.dp)
//                ,
//                isFavorite
//            ) { favorite ->
//                isFavorite = favorite
//            }

//            ComposeNoteAppTheme {
//                Column(
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .fillMaxSize()
//                ) {
//
//                }
//            }

//                    LazyColumn(
//                        modifier = Modifier
//                            .background(color = Color.Gray)
//                            .fillMaxWidth()
//                        ,
//                        contentPadding = PaddingValues(16.dp),
//                        verticalArrangement = Arrangement.spacedBy(16.dp)
//                    ) {
//                        item {
//                            Text(text = "header")
//                        }
//                        items(500) { index ->
//                            Text(text = "글씨: $index")
//                        }
//                        item {
//                            Text(text = "footer")
//                        }
//                    }

//                    Box(
//                        modifier = Modifier
//                            .background(color = Color.Green)
//                            .fillMaxSize()
//                    ) {
//                        Text("dasdasasdasdasdsadasd")
//                        Box(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .padding(16.dp),
//                            contentAlignment = Alignment.BottomEnd
//                        ) {
//                            Text("Hello ~~~~~~")
//                        }
//                    }

//                    Column(
//                        modifier = Modifier
//                            .fillMaxSize()
////                            .background(color = Color.)
//                            .padding(16.dp),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.SpaceBetween,
//                    ) {
//                        Greeting("hunkim")
//                    }