package com.example.shoestore_starter.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FWelcomeBinding

// TODO: Rename parameter arguments, choose names that match

class F_Welcome : Fragment() {
    private lateinit var binding: FWelcomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.f_welcome, container, false)

        binding.btnGo.setOnClickListener {
            findNavController().navigate(F_WelcomeDirections.actionFWelcomeToFInstruction())
        }

        return binding.root
    }

}