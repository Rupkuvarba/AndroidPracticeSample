package com.app.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
            MaterialTheme {
                Greeting(name = "Android \n\nHi Rup!!\n\nWelcome on the board")
               // Greeting()
            }
        }
    }


    @Composable
    fun Greeting(name: String) {
        //Text(text = "Hello $name!")
        Text(name,
            Modifier
                .padding(10.dp)
                .border(2.dp,Color.Green, RoundedCornerShape(50))
                .padding(50.dp)
                .border(2.dp, Color.Red)
                .padding(50.dp)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreviewMainActivity() {
        MaterialTheme {
            Greeting( "SiddhaRajsinh !")
        }
    }
}

