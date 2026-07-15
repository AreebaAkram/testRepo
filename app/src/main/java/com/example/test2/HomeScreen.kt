package com.example.test2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    Scaffold(

        // Top App Bar
        topBar = {
            TopAppBar(
                title = {
                    Text("Home")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Add"
                        )
                    }
                }

            )
        },

        // Bottom Navigation Bar
        bottomBar = {
            NavigationBar { // just a container to hold nav bar items

                NavigationBarItem(
                    selected = true,
                    onClick = {
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    },
                    label = {
                        Text("Home")
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile"
                        )
                    },
                    label = {
                        Text("Profile")
                    }
                )

            }
        },

        // Floating Action Button
        floatingActionButton = {
            FloatingActionButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }

    ) { innerPadding ->

        // Screen Content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),

                modifier = Modifier
                    .padding(25.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())  // for small screen
                // use lazy column / row for large screens as nm of compoenents may increase

            ){
                Text(
                    text = "Hello Compose!"
                )
                var counter by remember { mutableIntStateOf(0) }
//                var counter by rememberSaveable { mutableIntStateOf(0) }
                Button(onClick = {
                    counter++
                }) {
                    Text(text = "Click me $counter")
                }
                var age by remember { mutableIntStateOf(20) }
                Text("This is me Areeba") // will nor redraw
                Text("age:  $age") // only this will be recomposed
                Button(onClick = {
                    age++
                }
                ) {
                    Text(text = "Click me")
                }
//                LoginScreen()
                LoginScreenVM()
            }
        }
    }
}

// State Hoisting + Unidirectional data flow (Compose UI architecture)
@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    // will survives recomposition
//    var username by rememberSaveable {  mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    LoginTextField(
        value = username,
        onValueChange = { username = it }

    )
//    LoginTextField(
//        value = password,
//        onValueChange = { password = it }
//    )
    PasswordTextField(value = password, onValueChange = {password = it})
    Button(
        onClick = {
            println("Username: $username")
            println("Password: $password")

        },
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(Color.Gray),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(5.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text("Login")
    }

}

@Composable
fun LoginTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Username") },
        modifier = Modifier.fillMaxWidth()
    )
}
@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )
}

// Login screen Compose with ViewModel -- Surviving configuration changes

@Composable
fun LoginScreenVM(viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(25.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        OutlinedTextField(
            value = viewModel.username,
            onValueChange = {  // callback used to handle the text updatations
                viewModel.updateUsername(it)
            },
            label = {Text("Username")},
        )
        OutlinedTextField(
            value = viewModel.password,
            onValueChange = {
                viewModel.updatePassword(it)
            },
            label = {Text("Password")},
        )
        Button(
            onClick = {
                println("Username: ${viewModel.username}")
                println("Password: ${viewModel.password}")

            },
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(Color.Gray),
            shape = androidx.compose.foundation.shape.RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}
