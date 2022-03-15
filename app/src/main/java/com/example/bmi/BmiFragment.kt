package com.example.bmi

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bmi.databinding.FragmentBmiBinding

class BmiFragment : Fragment() {
    private lateinit var binding: FragmentBmiBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBmiBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bBmi.setOnClickListener {
            val height = binding.edHeight.text.toString().toFloat()
            val weight = binding.edWeight.text.toString().toFloat()
            val bmi = weight/(height*height)
            binding.tvBmi.setText(bmi.toString())
            AlertDialog.Builder(requireContext())
                .setTitle("BMI")
                .setMessage("your bmi: $bmi")
                .setPositiveButton("OK", null)
                .show()
        }
    }
}