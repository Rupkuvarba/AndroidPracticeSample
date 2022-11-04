package com.app.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
                MainScreen()
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
        MainScreen()
    }

    /*
    MainScreen composable is main entry point for states and state updates which happen on click
     */
    @Composable
    fun MainScreen() {
        //To manage state, keep list in mutableStateListOf
        //After recomposition we want to remember state then use remember block
        // - remember block is special block in jetpack compose
        //
        val greetingListState = remember {
            mutableStateListOf<String>("Radhe","Krishna")
        }
        val newNameStateContent = remember {
            mutableStateOf("")
        }

        Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
            GreetingList(greetingListState,
                {
                    greetingListState.add(newNameStateContent.value)
                },
                newNameStateContent.value,
                { newInput ->
                    newNameStateContent.value = newInput
                    println(" ***** * *  * * * * ** * *  $newInput")
                })
        }
    }

    /*
    Greeting list function does not know anything about state
     */
    @Composable
    fun GreetingList(namesList: List<String>,
                     buttonClick: () -> Unit,
                     textFieldValue: String,
                     textFieldValueChange: (value:String) -> Unit){

        for (name in namesList){
            println("-----------------------------------$name")
            Greeting(name = name)
        }

        val keyboardController = LocalSoftwareKeyboardController.current
        TextField(value = textFieldValue,
            onValueChange =  textFieldValueChange
                ,keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done, keyboardType = KeyboardType.Text),
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
        singleLine = true
        )

        //On click, recomposition not trigger
        Button(onClick = buttonClick) {
            println(" $  4$4 $ $ 4 4 $ $ $ $$ $  button text")
            Text(text = "Add new name")
        }
    }
}

