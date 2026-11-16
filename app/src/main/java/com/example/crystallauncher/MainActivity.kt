package com.example.crystallauncher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import kotlin.also
import android.content.Context



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context: Context = this

        enableEdgeToEdge()
        setContent {
            ComposeApp(context)
        }
    }
}

@Composable
fun ComposeApp(context: Context){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){
        AppCard(
            "Firefox",
            Intent(Intent.ACTION_MAIN).also{
                it.`package` = "org.mozilla.firefox"
            },
            context
        )
        AppCard(
            "Chrome",
            Intent(Intent.ACTION_MAIN).also{
                it.`package` = "com.android.chrome"
            },
            context
        )
        AppCard(
            "YouTube",
            Intent(Intent.ACTION_MAIN).also{
                it.`package` = "com.google.android.youtube"
            },
            context
        )
    }
}

@Composable
fun AppCard(appName: String, intent: Intent, context: Context){
    Settings()
    Text(
        text = appName,
        Modifier
            .padding(16.dp)
            .clickable(onClick = {
                startActivity(context, intent, null)
            }),
        fontSize = 30.sp
    )
}