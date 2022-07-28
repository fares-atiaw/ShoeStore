package com.example.shoestore_starter.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FInstructionBinding
// TODO: Rename parameter arguments, choose names that match

class F_Instruction : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FInstructionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.f_instruction, container, false)

        binding.btnGo.setOnClickListener {
            findNavController().navigate(F_InstructionDirections.actionFInstructionToFShoeList())
        }

        return binding.root
    }

}