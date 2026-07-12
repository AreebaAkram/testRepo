package com.example.test2

fun main(){
    greeting("Areeba")
    doSomething {println("I am that function that is inside another function") }
    doingSomething {message -> println( message)} // passed this string to calback
    // doingSomething{println(it)}
    loadData { data -> println("Loaded data: $data") }
}

// normal function
fun greeting(name : String){
    println("Name: $name")
}

//callback
fun doSomething(firstCllBack: () -> Unit){
    //just a ref / parameter, actual one that has to be invoked is in the main
    println("Simplest Callback")
    firstCllBack.invoke()
}

fun doingSomething(anothercallback: (String) -> Unit){
    anothercallback.invoke("hi!")
}

fun loadData(loadDataCallBack: (List<String>) -> Unit){
    val data = listOf("Areeba", "Alizeh", "Sara")
    loadDataCallBack.invoke(data) //Callback with the result
}
