package com.example.lib

fun main() {
//    println("Hello world")
    val p = Person()
    p.hello()
    val age:Int = 18
    println(age)
    val weight:Float = 64.5f
    val height = 1.7f
    val bmi = weight/(height*height)
    println(bmi)
    val isAdult = true
    //
    var name:String? = null //name 可為null
    //name = "Hank"
    //name?.uppercase() //當不是null uppercase
    println(name?.uppercase())
}