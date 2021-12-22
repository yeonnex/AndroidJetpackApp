package com.yeonnex.jetpackapp.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.yeonnex.jetpackapp.R
import com.yeonnex.jetpackapp.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object { //
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val resultObserver = Observer<Float>{
            result -> binding.tvResult.text = result.toString()
        }
        viewModel.getResult().observe(viewLifecycleOwner, resultObserver)

        binding.btConvert.setOnClickListener {
            if (binding.etColor.text.isNotEmpty()) {
                viewModel.setAmount(binding.etColor.text.toString())
            }else{
                binding.tvResult.text = "No Value"
            }
        }
    }

}