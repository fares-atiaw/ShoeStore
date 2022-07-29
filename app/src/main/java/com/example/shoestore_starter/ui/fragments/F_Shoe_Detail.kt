package com.example.shoestore_starter.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FShoeDetailBinding
import com.example.shoestore_starter.models.Shoe
import com.example.shoestore_starter.viewmodels.VM_Shoe

// TODO: Rename parameter arguments, choose names that match

class F_Shoe_Detail : Fragment() {
    private lateinit var binding: FShoeDetailBinding
    private val viewModel by viewModels<VM_Shoe>({ requireActivity() })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.f_shoe_detail, container, false)

//        binding.x = viewModel
        binding.x = Shoe("", 0.0 , "", "")
        binding.lifecycleOwner = viewLifecycleOwner

        binding.apply {

            btnCancel.setOnClickListener { findNavController().popBackStack() }

            btnSave.setOnClickListener {
                if(etShoeName.text.isEmpty()
                    || etShoeCompany.text.isEmpty()
                    || etShoeSize.text.isNullOrEmpty() || etShoeSize.text.toString().equals("0") || etShoeSize.text.toString().equals("0.0") //|| etShoeSize.text.contains("0.0") || etShoeSize.text.contains("0")
                    || etShoeDescription.text.isEmpty())
                {
                    Log.w("hhhh11", "etShoeSize.text => ${etShoeSize.text}")
                    Toast.makeText(context, "Fill the whole data", Toast.LENGTH_SHORT)
                }
                else{
//                    Log.w("hhhh", "viewModel.single_shoe.value => ${viewModel}")
                    viewModel.addShoe(binding.x!!)
                    findNavController().navigate(F_Shoe_DetailDirections.actionFShoeDetailToFShoeList())
                }
                Log.w("hhhh22", "etShoeSize.text => ${etShoeSize.text}")
            }

        }
        return binding.root
    }


}

//                findNavController().popBackStack()

/*
//    private lateinit var watcher: TextWatcher
//    private lateinit var name: String
//    private lateinit var company: String
//    private var size: Double = 0.0
//    private lateinit var description: String

            /*watcher = object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if(!(etShoeName.text.isEmpty()
                                || etShoeCompany.text.isEmpty()
                                || etShoeSize.text.isEmpty()
                                || etShoeDescription.text.isEmpty()))
                        btnSave.isEnabled = true
                }
            }*/


            binding.btnSave.isEnabled = false

            etShoeName.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) { name = s.toString() }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                    btnSave.isEnabled = etShoeName.text.isNotEmpty()
                    if(!(etShoeName.text.isEmpty()
                                || etShoeCompany.text.isEmpty()
                                || etShoeSize.text.isEmpty()
                                || etShoeDescription.text.isEmpty()))
                        btnSave.isEnabled = true
                }
            })
            etShoeCompany.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) { company = s.toString() }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                    btnSave.isEnabled = etShoeCompany.text.isNotEmpty()
                    if(!(etShoeName.text.isEmpty()
                                || etShoeCompany.text.isEmpty()
                                || etShoeSize.text.isEmpty()
                                || etShoeDescription.text.isEmpty()))
                        btnSave.isEnabled = true
                }
            })
            etShoeDescription.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) { description = s.toString() }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                    btnSave.isEnabled = etShoeDescription.text.isNotEmpty()
                    if(!(etShoeName.text.isEmpty()
                                || etShoeCompany.text.isEmpty()
                                || etShoeSize.text.isEmpty()
                                || etShoeDescription.text.isEmpty()))
                        btnSave.isEnabled = true
                }
            })
            etShoeSize.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                    btnSave.isEnabled = etShoeSize.text.isNotEmpty()
                    try {
                        size = s?.toString()?.toDouble() ?: 0.0
                    }catch (e :Exception){
                        Log.w("hhhh", "yes")
                        size = 0.0
                    }
                    if(!(etShoeName.text.isEmpty()
                                || etShoeCompany.text.isEmpty()
                                || etShoeSize.text.isEmpty()
                                || etShoeDescription.text.isEmpty()))
                        btnSave.isEnabled = true
                }
            })
 */