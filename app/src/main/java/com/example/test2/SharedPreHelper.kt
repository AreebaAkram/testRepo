package com.example.test2

import android.content.Context

class SharedPreHelper(context : Context) {
    private val sharedPreferences = context.getSharedPreferences("userPrefs", Context.MODE_PRIVATE)

    companion object {
        private const val Key_Username = "username" // every value will be stored against the same key
        private const val Key_Password = "password"
        private const val Key_Login = "login"
    }

    fun saveUsername(username: String) {   // key , value e.g., Key_Username = Areeba
        // only a sinle value is stored against each key, on updatation previous value replaced
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
        sharedPreferences.edit().clear().apply() // delete everything
    }

    fun removeUsername(entity : String){
        sharedPreferences.edit().remove(entity).apply()
    }

    fun savePassword(password : String){
        sharedPreferences.edit().putString(Key_Password, password).apply()
    }

    fun getPassword() : String{
        return sharedPreferences.getString(Key_Password, "") ?: ""
    }



}