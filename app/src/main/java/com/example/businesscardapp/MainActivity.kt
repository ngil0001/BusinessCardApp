package com.example.businesscardapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box


import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF3ddc84)
                ) {
                    MainSection(modifier = Modifier)
                    ContactSection(modifier = Modifier)
                }
            }
        }
    }
}

//two containers; middle of the screen and the bottom of the screen


//top container

@Composable
fun WorkerName(name: String, modifier: Modifier) {
    //text for persons name, align to center, bigger font sizing
        Text(
            text = name,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
}

@Composable
fun JobTitle(jobRole: String, modifier: Modifier) {
    //text for job title, align to center, smaller font sizing, green colored
    Text(
        text = jobRole,
        modifier = modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun BusinessLogo(modifier: Modifier = Modifier) {
    //image resource
    val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = "Android logo",
            modifier = modifier.size(100.dp)
        )
}

@Composable
fun MainSection(modifier: Modifier = Modifier) {
    //main container, align to center of screen
    Box(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column{
            BusinessLogo(modifier)
            WorkerName(
                name = "John Doe", modifier = Modifier
            )
            JobTitle(jobRole = "Android Developer", modifier)
        }
    }
}

//bottom container
//first of three elements; Phone number, social handle, email
@Composable
fun PhoneNumber(number: String, modifier: Modifier){
    //icon
    Row {
        Icon(
            imageVector = Icons.Filled.Phone,
            contentDescription = "Phone"
        )
        // text passed from ContactSection
        Text(
            text = number
        )
    }
}
@Composable
fun SocialMedia(socialHandle: String, modifier: Modifier) {
    //icon
    Row {
        Icon(
            imageVector = Icons.Filled.Share,
            contentDescription = "Share"
        )
        // text passed from ContactSection
        Text(
            text = socialHandle
        )
    }

}
@Composable
fun Email(email: String, modifier: Modifier) {
    //icon
    Row {
        Icon(
            imageVector = Icons.Filled.Email,
            contentDescription = "Home"
        )
        // text passed from ContactSection
        Text(
            text = email
        )
    }

}
//main container for the bottom section
@Composable
fun ContactSection(modifier: Modifier){
    //aligns the container to the bottom center
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ){
        //aligns the components in a column; each component is self aligned in a row
        Column {
            PhoneNumber(number = "+1 (123) 456 7890", modifier)
            SocialMedia(socialHandle = "@TestName", modifier)
            Email(email = "email@domain.com", modifier)
        }
    }
}