package com.app.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

/*val namesList:ArrayList<String> = arrayListOf(
    "Bhavin",
    "Chirag",
    "Rup",
    "mital",
    "Ganpati")*/

@OptIn(ExperimentalComposeUiApi::class)
class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*setContentView(R.layout.activity_main)
        val greeting = findViewById<ComposeView>(R.id.greeting)
        greeting.setContent {
            MaterialTheme {
                Greeting(name = "compose")
            }
        }*/
        setContent {
            Column() {
                /*MaterialTheme {
                    Greeting(name = "Hi Rup!!\n\nWelcome on the board")
                    // Greeting()
                }*/
                MainScreen(viewModel)
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!",
        style = MaterialTheme.typography.h4)
        /*Text(name,
            Modifier
                .padding(10.dp)
                .border(2.dp, Color.Green, RoundedCornerShape(50))
                .padding(50.dp)
                .border(2.dp, Color.Red)
                .padding(50.dp)
        )*/
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreviewMainActivity() {
        /*MaterialTheme {
            Greeting( "SiddhaRajsinh !")
        }*/
        MainScreen(viewModel)
    }

    /*
    MainScreen composable is main entry point for states and state updates which happen on click
     */
    @Composable
    fun MainScreen(viewModel: MainViewModel) {
        //To manage state, keep list in mutableStateListOf
        //After recomposition we want to remember state then use remember block
        // - remember block is special block in jetpack compose
        //
        val newNameStateContent = viewModel.textFieldState.observeAsState("Hiomt")
        println(" $  4$4 $ $ 4 4 $ $ $ $$ $  MainScreen newNameStateContent $newNameStateContent")

        Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
            GreetingMessage(
                newNameStateContent.value
            ) { newInput ->
                println(" ***** * *  * * * * ** * *  $newInput")
                viewModel.onTextChanged(newInput)
            }
        }
    }

    /*
    Greeting list function does not know anything about state
     */
    @Composable
    fun GreetingMessage(textFieldValue: String,
                        textFieldValueChange: (value:String) -> Unit){

        println(" $  4$4 $ $ 4 4 $ $ $ $$ $  GreetingMessage $textFieldValue")
        /*val keyboardController = LocalSoftwareKeyboardController.current
        TextField(value = textFieldValue,
            onValueChange =  textFieldValueChange
                ,keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Text),
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
        singleLine = true
        )*/

        TextField(value = textFieldValue,
            onValueChange =  textFieldValueChange)

        //On click, recomposition not trigger
        Button(onClick = {}) {
           // println(" $  4$4 $ $ 4 4 $ $ $ $$ $  button text")
            Text(textFieldValue)
        }
    }
}

