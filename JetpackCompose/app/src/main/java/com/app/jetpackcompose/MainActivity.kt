package com.app.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

val namesList:ArrayList<String> = arrayListOf(
    "Bhavin",
    "Chirag",
    "Rup",
    "mital",
    "Ganpati")

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

    @Composable
    fun MainScreen() {
        //Text(text = "Hello $name!")
        Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally) {
           for (name in namesList){
               Greeting(name = name)
           }
            //On click, recomposition not trigger
            Button(onClick = { namesList.add("new name") }) {
              Text(text = "Add new name")
            }
        }
    }
}

