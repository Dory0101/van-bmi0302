package com.example.bmi

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//database store class
@Entity
class Transaction (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val account: String,
    @ColumnInfo(name= "CreateAt")
    val date: String,// @Ignore not to save
    @ColumnInfo(name = "amount")
    val amount: Int,
    val type: Int) {

}