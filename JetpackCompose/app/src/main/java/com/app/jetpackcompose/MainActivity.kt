package com.app.jetpackcompose

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.tooling.LocalInspectionTables
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
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
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.Top),
            elevation = 8.dp) {
               Row(modifier = Modifier.fillMaxWidth(),
                   verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.Start) {
                ProfilePicture()
                ProfileContent()
            }
        }
    }

    @Composable
    fun ProfilePicture(){
       Card(shape = CircleShape,
       border = BorderStroke(width = 2.dp, color = Color.Green),
       modifier = Modifier.padding(16.dp),
       elevation = 4.dp
       ) {
           Image(
               painter = painterResource(id = R.drawable.profile_picture_1),
               contentDescription = "content description",
               modifier = Modifier.size(72.dp),
               contentScale = ContentScale.Crop
           )

       }
    }

    @Composable
    fun ProfileContent(){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Text(
                text = "Rup Barad",
                style = MaterialTheme.typography.h5
            )
           //If you're on the Beta version of Compose, use CompositionLocalProvider instead of Providers.
           CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                Text(
                    text = "Active Now",
                    style = MaterialTheme.typography.body2
                )
            }

        }

    }
}

