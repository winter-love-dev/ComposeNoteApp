package com.season.winter.composenoteapp.activity.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
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
import com.season.winter.composenoteapp.compose.ui.CustomTextField
import com.season.winter.composenoteapp.compose.ui.theme.ComposeNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                content = { scaffoldPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(scaffoldPadding)
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        CustomTextField {
                            // add list ...
                        }
                    }
                }
            )
        }
    }
}


/**
 * 학습 했던거 잠깐 기록 용으로 남겨두는 주석들
 */

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