package com.example.lib
//constructor 可以省略
open class Student constructor(var name: String, var english: Int, var math: Int) {
    companion object {
        var pass = 60
        fun test() {

        }
    }
    constructor() : this("", 0, 0){
        println("Hi")
    }
    constructor(name: String) : this(name, 0,0) {
        println("Hi $name, please enter your scores")
    }
    //Fields屬性
//    var name: String? = null
//    var english = 0
//    var math = 0

    //Method
    fun print() {
        print("$name\t$english\t$math\t${average()}")
        if (average() < pass) println("*") else println()
    }
    fun average() = (english+math)/2
    fun max(a: Int, b: Int) = if (a > b) a else b
    //a method named 'highest' can return one highest score of all courses
    fun highest() = if (english > math) english else math
    fun grading() = when (average()/10) {
            in 9..10 -> 'A'
            8 -> 'B'
            7 -> 'C'
            6 -> 'D'
            else -> 'F'
        }
}

fun main() {
    val hank = Student("Hank", 40, 60)
    val jack = Student("Jack",85, 65)
    val kui = Student("Kui", 90, 60)
    Student.pass = 50
    hank.print()
    jack.print()
    kui.print()
}