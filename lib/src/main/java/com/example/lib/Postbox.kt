package com.example.lib

import kotlin.math.max
import kotlin.math.min

class Postbox constructor(var name:String, var length: Int, var width: Int, var height: Int, var price: Int) {
    fun print() {
        println("$name, box size:$length,$width,$height,$$price")
    }
}

fun main() {
    val box1 = Postbox("Box1",10,10,10,50)
    val box2 = Postbox("Box2", 10, 10,15,60)
    val box3 = Postbox("Box3",10,15,15,70)

    while (true) {
        println("Please enter your stuff length:")
        var clength = readLine()!!.toInt()
        println("Please enter your stuff width:")
        var cwidth = readLine()!!.toInt()
        println("Please enter your stuff height:")
        var cheight = readLine()!!.toInt()
        
        var cmax = max(clength, cwidth)
        cmax = max(cmax,cheight)
//        println("max: $cmax")
        var cmin = min(clength, cwidth)
        cmin = min(cmin, cheight)
//    val cbox = Postbox("cbox",clength,cwidth,cheight)
        if (cmax <= 10) {
            box1.print()
        } else if (cmax > 10 && cmax <= 15 && cmin <= 10) {
            if (clength > 10 && cwidth >10 || clength > 10 && cheight > 10 || cwidth > 10 && cheight > 10) {
                box3.print()
            } else {
                box2.print()
            }
        } else {
            println("out of range")
        }
    }
}