package com.example.multitoolapp.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.multitoolapp.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {
    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CalculatorViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)
        setupButtons()
        viewModel.result.observe(viewLifecycleOwner) { binding.tvResult.text = it }
        viewModel.expression.observe(viewLifecycleOwner) { binding.tvExpression.text = it }
        return binding.root
    }

    private fun setupButtons() {
        binding.btn0.setOnClickListener { viewModel.append("0") }
        binding.btn1.setOnClickListener { viewModel.append("1") }
        // ... similarly for 2-9, operators, clear, equals
        binding.btnAdd.setOnClickListener { viewModel.append("+") }
        binding.btnSub.setOnClickListener { viewModel.append("-") }
        binding.btnMul.setOnClickListener { viewModel.append("*") }
        binding.btnDiv.setOnClickListener { viewModel.append("/") }
        binding.btnClear.setOnClickListener { viewModel.clear() }
        binding.btnEquals.setOnClickListener { viewModel.evaluate() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
