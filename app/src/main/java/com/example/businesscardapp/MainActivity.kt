package com.example.businesscardapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessLogo(modifier = Modifier)
                    ContactSection(modifier = Modifier)
                }
            }
        }
    }
}

//two containers; middle of the screen and the bottom of the screen


//top container

@Composable
fun WorkerName(name: String, jobRole: String, modifier: Modifier) {
    //first line of text will be slightly bigger than the second line
    Column {
        Text(text = name)
        //second line - different color / smaller
        Text(text = jobRole)
    }
}

@Composable
fun BusinessLogo(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Box {
        Image(
            painter = image,
            contentDescription = null
        )
        WorkerName(
            name = "Noah Gilkey", jobRole = "Business Intel Developer", modifier = Modifier
        )
    }
}

//bottom container
//first of three elements; Phone number, social handle, email
@Composable
fun PhoneNumber(number: String, modifier: Modifier){
    //icon
    Icon(
        imageVector = Icons.Filled.Phone,
        contentDescription = "Phone"
    )
    Text(
        text = number
    )
}
@Composable
fun SocialMedia(socialHandle: String, modifier: Modifier) {
    //icon
    Icon(
        imageVector = Icons.Filled.Share,
        contentDescription = "Share"
    )
    Text(
        text = socialHandle
    )

}
@Composable
fun Email(email: String, modifier: Modifier) {
    //icon
    Icon(
        imageVector = Icons.Filled.Email,
        contentDescription = "Home"
    )
    Text(
        text = email
    )

}
//main container for the bottom section
@Composable
fun ContactSection(modifier: Modifier){
    //these will be in a container with a column alignment
    Box {
        Column {
            PhoneNumber(number = "1111111111", modifier)
            SocialMedia(socialHandle = "@111111", modifier)
            Email(email = "1111@11111.com", modifier)
        }
    }
}