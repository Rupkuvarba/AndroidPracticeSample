package com.app.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
class MainActivity : ComponentActivity() {
   // val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreviewMainActivity() {
        MainScreen()
    }

    /*
    MainScreen composable is main entry point for states and state updates which happen on click
     */
    @Composable
    fun MainScreen() {
       Surface(
           modifier = Modifier.fillMaxSize(),
           color = Color.Gray) {
           ProfileCard()
       }
    }

    @Composable
    fun ProfileCard(){
        Card(modifier = Modifier.fillMaxWidth(), elevation = 8.dp) {
            Row(modifier = Modifier.wrapContentSize()) {
                ProfilePicture()
                ProfileContent()
            }
        }
    }

    @Composable
    fun ProfilePicture(){

    }

    @Composable
    fun ProfileContent(){

    }
}

