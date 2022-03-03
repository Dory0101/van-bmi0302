package com.example.lib

import kotlin.random.Random

/*fun main() {
    val secret = Random.nextInt(100)+1
    println(secret)

    var prens = 1
    var prenb = 100
    var n = 0
    println("Please guess a number($prens-$prenb):")
    while (n != secret) {
        readLine()?.let {
            val num = it.toInt()
        }

    //var n = readLine()!!.toInt()

        *//*if (n > secret) {
            println("smaller: $prens - $n")
            prenb = n
        } else if (n < secret) {
            println("bigger: $n - $prenb")
            prens = n
        } else {
            println("you got it is $n")
        }*//*
    }
}*/

/*fun main() {
    val secret = Random.nextInt(100)+1
    println(secret)
    var min = 1
    var max = 100
    var num = 0
    while (num!=secret){
        println("Please enter a number $min - $max")
        readLine()?.let {
            num = it.toInt()
            if (num < secret) {
               min = num
            } else if (num > secret) {
                max = num
            } else {
                println("You got the num $num")
            }
        }
    }
}*/

//challenge1 only guess 3 times
fun main() {
    val secret = Random.nextInt(100)+1
//    println("The secret number is $secret")
    var min = 1
    var max = 100
    var num = 0

    for (i in 3 downTo 1) {
        println("Please guess a number between $min to $max:")
        println("You have $i chance(s).")
        readLine()?.let { entry ->
            num = entry.toInt()
            if (num < secret) {
                min = num
            } else if (num > secret) {
                max = num
            } else {
                println("you got the num $num.")
                return
            }
        }
    }
    println("The secret number is $secret.")
}
//challenge2 out of range laugh it
//fun main() {
//    val secret = Random.nextInt(100)+1
////    println("The secret number is $secret")
//
//    var min = 1
//    var max = 100
//    var num = 1
//
//    while (num!=secret) {
//        println("Please guess a number between $min to $max:")
//        readLine()?.let {
//            num = it.toInt()
//            if (num > min && num < max){
//                if (num < secret) {
//                    min = num
//                } else if (num > secret) {
//                    max = num
//                } else {
//                    println("You got the num $num.")
//                }
//            } else {
//                println("Are you serious? Please guess a number in the range.")
//            }
//        }
//    }
//}
class Guess1To100 {
}