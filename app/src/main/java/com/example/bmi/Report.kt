package com.example.bmi

import android.util.Log

interface Report {
    fun print()
}

class FinanceReport : Report { //有名類別
    override fun print() {
        println("Finance!")
    }
}

fun main() {
    val financeReport = FinanceReport()
    financeReport.print()
    //anonymous class
    object : Report {
        override fun print() {
            println("Health!!")
        }
    }.print()
}