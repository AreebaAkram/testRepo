package com.example.test2

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.test2.Storage.SharedPreHelper

// android vm actually provides context to application

class LoginViewModel(application : Application) : AndroidViewModel(application) {

    private val helper = SharedPreHelper(application)

    var username by mutableStateOf("")
    var password by mutableStateOf("")


    fun updateUsername(name: String) {
        username = name
    }

    fun updatePassword(pass: String) {
        password = pass
    }

    fun login(){
        helper.saveUsername(username)
        helper.savePassword(password)
        helper.saveLoginStatus(true)

        println(helper.getUsername())
        println(helper.getPassword())
    }

    fun loadUser(){
        username = helper.getUsername()
        password = helper.getPassword()

        println(username)
        println(password)
    }

    fun logout(){
        helper.logout()
        username = ""
        password = ""
    }

    fun isLoggedIn(): Boolean{
        return helper.isLoggedIn()
    }
}