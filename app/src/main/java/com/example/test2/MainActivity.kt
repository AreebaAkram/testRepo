package com.example.test2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Greeting()
//            ProfileCard("Areeba", 20)
//            Login()
//            DemoActivity()
            HomeScreen()
        }
    }

    @Composable
    fun DemoActivity() {
        Column() {
//            Greeting()
//            Login()
            ProfileCard("Areeba", 20)
            NotificationBadge()
            Students()
//            StudentList()
            FoodCategories()
//            FirstCard()
            ShowUsers()
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
//            verticalArrangement = Arrangement.SpaceBetween,
//            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .height(300.dp)
                .padding(16.dp)

        ) {
            Text(
                text = "Login",
                modifier = Modifier
                    .size(60.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
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
           Icon(
               imageVector = Icons.Default.Notifications,
               contentDescription = "Notification",
               tint = Color.Blue
           )
           Text("This is an image")
       }
//        LazyColumn {
//            items(100) {
//                Text(text = "This is item $it")
//            }
//        }
   }

    @Composable
    fun Students() {
        LazyColumn {
            item {
                Text("Areeba")
            }
            item {
                Text("Alizeh")
            }
        }
    }

    @Composable
    fun StudentList() {
        val students = listOf(
            "Ali",
            "Ahmed",
            "Areeba",
            "Sara",
            "Zain"
        )
        LazyColumn(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
        ) {
            item{
                Text("Students", style = MaterialTheme.typography.headlineMedium)
            }
            // for every student in students, i'll excute the -> following code
            // items(Students) -- for every student, run this function
            items(students, key = {student -> student }) { student ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Person"
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(student)
                }
            }
            item{
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Add Student")
                }
            }
        }
    }

    @Composable
    fun FoodCategories() {
        //best practice is to enclose this in simple column (column -> text + lazy row)
        Text(
            "This is an Food categories lazy row",
            modifier = Modifier
                .padding(16.dp),
            style = MaterialTheme.typography.headlineMedium
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(19.dp)
        ) {
            item { Text("Pizza") }
            item { Text("Burger") }
            item { Text("Pizza") }
            item { Text("Pizza") }
            item { Text("Pizza") }
            item { Text("Pizza") }
            item { Text("Pizza") }
            item { Text("Pizza") }
            item { Text("Pizza") }
            item { Text("Pizza") }
        }
    }

    @Composable
    fun FirstCard() {
        Card(
            // elevation, colors, shape -> all are parameters name of function card
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Blue),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onClick = {
                Toast.makeText(this, "Card Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Areeba Akram",
                    modifier = Modifier
                        .padding(16.dp),
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    "Software Engineer",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                )
            }
        }
    }

    // card + lazy column
    data class users(val name: String, val age: Int)

    @Composable
    fun userProfileCard(user: users) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(user.name)
                Text(user.age.toString())
            }

        }
    }

    val user1: users = users("Areeba", 20)
    val user2: users = users("Alizeh", 19)
    val user3: users = users("Sara", 20)

    val userList = listOf(user1, user2, user3)

    @Composable
    fun ShowUsers() {
        LazyColumn {
            items(userList) { user ->
                userProfileCard(user)
            }
        }
    }
}




