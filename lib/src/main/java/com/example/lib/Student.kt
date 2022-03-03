package com.example.lib
//constructor 可以省略
class Student constructor(var name: String, var english: Int, var math: Int) {
    constructor() : this("", 0, 0){
        println("Hi")
    }
    constructor(name: String) : this(name, 0,0) {
        println("Hi $name, please enter your scores")
    }
    //Fields
//    var name: String? = null
//    var english = 0
//    var math = 0
    //Method
    fun print() {
        println("$name\t$english\t$math\t${average()}")
    }
    fun average() : Int {
        return (english+math)/2
    }
}

fun main() {
    val hank = Student("Hank")
    val jack = Student("Jack",85, 65)
    val kui = Student("Kui", 90, 60)
    jack.print()
    kui.print()
}