package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceControl
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.bmi.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityMainBinding
    val fragements = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) { //override覆寫 跟父類別方法一樣才能執行
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragments() //help setup fragments
        binding.bottomNavBar.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.action_guess -> {
                    supportFragmentManager.beginTransaction().run {
                        replace(R.id.my_container, fragements[0])
                        commit()
                    }
                    true
                }
                R.id.action_bmi -> {
                    supportFragmentManager.beginTransaction().run {
                        replace(R.id.my_container, fragements[1])
                        commit()
                    }
                    false
                }
                R.id.action_camera -> {
                    supportFragmentManager.beginTransaction().run {
                        replace(R.id.my_container, fragements[2])
                    }
                    true
                }
                else -> true
            }
        }
        val t1 = Transaction(1, "hank", "20220315", 3000, 1)
        val database = Room.databaseBuilder(this,
            TranDatabase::class.java, "trans.db")
            .build()
        thread {
            database.transactionDao().insert(t1)
        }
    }

    private fun initFragments() {
        fragements.add(0, GuessFragment())
        fragements.add(1, BmiFragment())
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.my_container, guess1to10Fragment)  //.replace() remove last one add new fragment
//        transaction.commit()
        
        //kotlin way
        supportFragmentManager.beginTransaction().run {
            add(R.id.my_container, fragements[0])
            commit()
            //run{} after run, gone.
            //apply{} after apply, can get things.
        }
    }
}