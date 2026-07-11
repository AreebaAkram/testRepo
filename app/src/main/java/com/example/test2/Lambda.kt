package com.example.test2

import android.annotation.SuppressLint
import androidx.compose.remote.creation.dsl.square

fun main(){
    greet()
    greet2("Areeba")
    multiply(2)
    greet3
    greet4("Asi")
}

// Normal fun
fun greet(){
    print("Hello")
}

// fun with parameters
fun greet2(name: String){
    print("Hello $name")
}

//fun with return type
fun multiply(number: Int): Int{
    return number * number
}

//The same -- Lambda
val greet3 = {
    println("Here again")
}

// Lambda with parameters
val greet4 = {name : String ->   // take para name and execute the following code
    println("Hello $name")
}

