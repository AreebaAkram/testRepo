package com.example.test2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){
    var username by mutableStateOf("")
    var password by mutableStateOf("")

    fun updateUsername(name : String){
        username = name
    }
    fun updatePassword(pass : String){
        password = pass
    }
}