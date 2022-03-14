package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.bmi.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<GuessViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) { //override覆寫 跟父類別方法一樣才能執行
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.counter.observe(this) {
            binding.tvCounter.setText(it.toString())
        }
        viewModel.gameState.observe(this) {state ->
            val message = when(state) {
                GuessViewModel.GameState.BIGGER -> getString(R.string.bigger)
                GuessViewModel.GameState.SMALLER -> getString(R.string.smaller)
                GuessViewModel.GameState.BINGO -> getString(R.string.bingo)
                GuessViewModel.GameState.INIT -> "Start!"
                else -> getString(R.string.something_go_wrong)
            }

            AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_title))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                    if (state == GuessViewModel.GameState.BINGO)
                        viewModel.reset()
                }
                .show()
        }
    }

    fun guess(view: View) {
        val num = binding.number.text.toString().toInt()
        viewModel.guess(num)
//        binding.number.text.clear()
    }
}