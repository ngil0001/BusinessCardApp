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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
