package com.example.test2



import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
            ProfileCard("Areeba", 20)
            Login()
        }
    }

    @Composable
    fun Greeting() {
//        Text("Hello Compose!")
        Text(
            text = "Hello Compose!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.Green)

            //order matters
//                .background(Color.Green)
//                .padding(16.dp)
        )

    }

    @Composable
    fun Login() {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
//            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .height(300.dp)
                .padding(16.dp)

        ) {
            Text(
                text = "Login",
                modifier = Modifier
                    .size(60.dp)
            )
            TextField(value = "",
                onValueChange = {},
                label = { Text("Username") })
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }
        }
    }


    @Composable
    fun ProfileCard(name: String, age: Int) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Name : $name"
            )
            Text(
                "Age : $age"

            )
        }
    }
    @Composable
   fun NotificationBadge(){
       Box(){
           Icon( imageVector = Icons.Default.Notifications, contentDescription = "Notification")
           Text("This is an image")
       }
   }
}
