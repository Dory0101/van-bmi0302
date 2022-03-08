package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.bmi.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityMainBinding
    var game = NumberGame()
    override fun onCreate(savedInstanceState: Bundle?) { //override覆寫 跟父類別方法一樣才能執行
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun guess(view: View) {
        Log.d(TAG, "Testing: secret is ${game.secret}")
        val num = binding.number.text.toString().toInt()
        val state = game.guess(num)

        val message = when(state) {
            NumberGame.GameState.BIGGER -> getString(R.string.bigger)
            NumberGame.GameState.SMALLER -> getString(R.string.smaller)
            NumberGame.GameState.BINGO -> getString(R.string.bingo)
            else -> getString(R.string.something_go_wrong)
        }

        AlertDialog.Builder(this)
            .setTitle(getString(R.string.dialog_title))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                if (game.end) game.reset()
                updateUI()
            }
            .show()
        updateUI()
    }

    private fun updateUI() {
        binding.tvCounter.text = getString(R.string.counter_times, game.counter)
    }
}