package com.example.bmi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.bmi.databinding.FragmentGuessBinding

class GuessFragment :Fragment() {
    private lateinit var bindining : FragmentGuessBinding
    val viewModel by viewModels<GuessViewModel>()
    companion object {
        private val TAG = GuessFragment::class.java.simpleName
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindining = FragmentGuessBinding.inflate(inflater)
        return bindining.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) //call father class method

        val name = arguments?.getString("NAME")
        Log.d(MainActivity::class.java.simpleName, "onViewCreated: NAME: $name")
        val person = arguments?.getParcelable<Person>("PERSON")
        Log.d(MainActivity::class.java.simpleName, "onViewCreated: person ${person?.weight}")

        bindining.button.setOnClickListener {
            val num = bindining.number.text.toString().toInt()
            viewModel.guess(num)
        }
        viewModel.counter.observe(viewLifecycleOwner) {
            bindining.tvCounter.setText(it.toString())
        }
        viewModel.gameState.observe(viewLifecycleOwner) { state ->
            val message = when(state) {
                GuessViewModel.GameState.BIGGER -> getString(R.string.bigger)
                GuessViewModel.GameState.SMALLER -> getString(R.string.smaller)
                GuessViewModel.GameState.BINGO -> getString(R.string.bingo)
                GuessViewModel.GameState.INIT -> "Start!"
                else -> getString(R.string.something_go_wrong)
            }

            AlertDialog.Builder(requireContext())
                .setTitle(getString(R.string.dialog_title))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                    if (state == GuessViewModel.GameState.BINGO)
                        viewModel.reset()
                }
                .show()
        }
    }
}