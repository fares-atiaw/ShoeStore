package com.example.shoestore_starter.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FLoginBinding
import com.example.shoestore_starter.viewmodels.VM_Login
import com.example.shoestore_starter.viewmodels.VM_Shoe

class F_Login : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FLoginBinding
    private val viewModel by viewModels<VM_Login>{ defaultViewModelProviderFactory }
    private lateinit var watcher: TextWatcher

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
//        @Suppress("UNUSED_VARIABLE")
        binding = DataBindingUtil.inflate(inflater, R.layout.f_login, container, false)

        binding.x = viewModel
        binding.lifecycleOwner = this

        binding.btnLogin.isEnabled = false
        watcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.btnLogin.isEnabled = !(binding.etEmail.text.isEmpty() || binding.etPassword.text.isEmpty())
//                Log.w("email and password => \n", "${viewModel.email.value}\n${viewModel.password.value}")
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etEmail.addTextChangedListener(watcher)
        binding.etPassword.addTextChangedListener(watcher)

        binding.btnLogin.setOnClickListener(
            Navigation.createNavigateOnClickListener(F_LoginDirections.actionFLoginToFWelcome())
        )
        binding.btnRegister.setOnClickListener(
            Navigation.createNavigateOnClickListener(F_LoginDirections.actionFLoginToFWelcome())
        )

    }
}

//        return inflater.inflate(R.layout.f_login, container, false)
