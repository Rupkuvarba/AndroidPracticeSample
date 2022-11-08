package com.app.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.jetpackcompose.data.model.UserProfile
import com.app.jetpackcompose.data.model.userProfileList
import com.app.jetpackcompose.ui.theme.JetNewsTheme
import com.app.jetpackcompose.ui.theme.imageBorderStroke
import com.app.jetpackcompose.ui.theme.imageBorderStrokeOffline

@OptIn(ExperimentalComposeUiApi::class)
class MainActivity : ComponentActivity() {
   // val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNewsTheme {
                MainScreen()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreviewMainActivity() {
        JetNewsTheme {
            MainScreen()
        }
    }

    /*
    MainScreen composable is main entry point for states and state updates which happen on click
     */
    @Composable
    fun MainScreen() {
       Scaffold(topBar = { TopBar() }) {
           Surface(
               modifier = Modifier
                   .fillMaxSize()
                   .padding(it)) {
               Column {
                   for(userProfile in userProfileList){
                       ProfileCard(userProfile)
                   }
               }

           }
       }
    }

    @Composable
    fun TopBar(){
        //Background color = Primary color for light theme
        TopAppBar(
            navigationIcon = { Icon( Icons.Default.Home,
                "Home",
                modifier = Modifier.padding(horizontal = 12.dp)
            ) },
            title = { Text(text = "Messaging Applications user")}
        )
    }

    @Composable
    fun ProfileCard(userProfile: UserProfile){
        Card(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp )
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.Top),
            elevation = 8.dp,
            backgroundColor = Color.White
        ) {
               Row(modifier = Modifier.fillMaxWidth(),
                   verticalAlignment = Alignment.CenterVertically,
               horizontalArrangement = Arrangement.Start) {
                ProfilePicture(userProfile.drawableId, userProfile.status)
                ProfileContent(userProfile.name, userProfile.status)
            }
        }
    }

    @Composable
    fun ProfilePicture(drawableId:Int, onlineStatus:Boolean){
       Card(shape = CircleShape,
       border = BorderStroke(width = 2.dp,
           color = if(onlineStatus)
               MaterialTheme.colors.imageBorderStroke
           else
               MaterialTheme.colors.imageBorderStrokeOffline
       ) ,
       modifier = Modifier.padding(16.dp),
       elevation = 4.dp
       ) {
           Image(
               painter = painterResource(id = drawableId),
               contentDescription = "content description",
               modifier = Modifier.size(72.dp),
               contentScale = ContentScale.Crop
           )

       }
    }

    @Composable
    fun ProfileContent(name:String, onlineStatus:Boolean){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {

            CompositionLocalProvider(
                LocalContentAlpha provides if(onlineStatus)
                    1f else ContentAlpha.medium) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h5
                )
            }

           //If you're on the Beta version of Compose, use CompositionLocalProvider instead of Providers.
           //CompositionLocalProvider helps you apply a specific alpha to all the composables used inside its scope
           CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                Text(
                    text = if(onlineStatus)
                        "Active Now"
                    else
                        "Offline",
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

