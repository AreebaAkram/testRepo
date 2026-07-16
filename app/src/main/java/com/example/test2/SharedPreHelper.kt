package com.example.test2

import android.content.Context

class SharedPreHelper(context : Context) {
    private val sharedPreferences = context.getSharedPreferences("userPrefs", Context.MODE_PRIVATE)

    companion object {
        private const val Key_Username = "username"
        private const val Key_Password = "password"
        private const val Key_Login = "login"
    }

    fun saveUsername(username: String) {
        sharedPreferences.edit().putString(Key_Username, username).apply()
    }

    fun getUsername(): String {
        return sharedPreferences.getString(Key_Username, "") ?: ""
    }

    fun saveLoginStatus(status : Boolean){
        sharedPreferences.edit().putBoolean(Key_Login, status).apply()
    }

    fun isLoggedIn(): Boolean{
        return sharedPreferences.getBoolean(Key_Login, false)
    }

    fun logout(){
        sharedPreferences.edit().clear().apply()
    }
}