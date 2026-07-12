package com.example.test2



import android.os.Bundle
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
//            Greeting()
//            ProfileCard("Areeba", 20)
//            Login()
            DemoActivity()
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
            StudentList()
            FoodCategories()
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
            horizontalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            item { Text("Pizza") }
            item { Text("Burger") }
            item { Text("Pizza") }
            item { Text("Pizza") }
            item { Text("Pizza") }
            item { Text("Pizza") }
        }
    }
}
