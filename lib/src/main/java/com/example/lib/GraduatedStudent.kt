package com.example.lib

class GraduatedStudent constructor(name: String, english: Int, math: Int)
    : Student(name, english, math) {
}

fun main() {
    var jenny = GraduatedStudent("Jenny", 70, 90)
    jenny.print()
}