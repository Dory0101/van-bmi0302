package com.example.lib

fun main() {
//    for (i in 2..9) {
////        println(i)
//        for (j in 1..9) {
//            if (i*j > 9) {
//                println("$i*$j= ${i*j}")
//            } else {
//                println("$i*$j=  ${i*j}")
//            }
//        }
//    }
//    for (i in 2..9) {  // teacher's method
//        for (j in 1..9) {
//            var space = if (i*j < 10) " " else ""
//            println("$i*$j=$space${i*j}")
//        }
//    }
    for (i in 2..9) {  // teacher's method
        for (j in 1..9) {
            println("$i*$j=${if (i*j <10) " " else ""}${i*j}")
        }
    }
}

class Nine {
}