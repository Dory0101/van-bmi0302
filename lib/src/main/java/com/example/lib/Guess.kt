package com.example.lib

import kotlin.random.Random

/*fun main() {
    while (true) {
        val secret = Random.nextInt(10) + 1
        println(secret)
        while (true) {
            println("please enter a number(1-10):")
            val s = readLine()
            val number = s!!.toInt()
            println(number)
            if (number > secret) {
                println("Smaller")
            } else if (number < secret) {
                println("Bigger")
            } else {
                println("you got it")
                break;
            }
        }
    }
}*/

fun main() {
    val secret = Random.nextInt(10)+1
    println(secret)
    var num = 0
    while (num != secret) {
        println("Please enter a numer(1-10):")
        num = readLine()!!.toInt()
        if (num > secret) {
            println("smaller")
        } else if (num < secret) {
            println("Bigger")
        } else {
            println("you got it")
        }
    }
}


class Guess {
}