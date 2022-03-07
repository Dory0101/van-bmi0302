package com.example.lib

class GraduatedStudent constructor(name: String, english: Int, math: Int)
    : Student(name, english, math) {
    constructor(name: String) : this(name, 0,0)
    constructor() : this("",0,0)
}

fun main() {
    var jenny = GraduatedStudent("Jenny")
    jenny.print()
}