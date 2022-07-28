package com.example.shoestore_starter.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FShoeListBinding
import com.example.shoestore_starter.databinding.ItemShoeBinding
import com.example.shoestore_starter.viewmodels.VM_Shoe

// TODO: Rename parameter arguments, choose names that match

class F_Shoe_List : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FShoeListBinding
    private val viewModel by viewModels<VM_Shoe>({ requireActivity() })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.f_shoe_list, container, false)

//        val itemBinding = ItemShoeBinding.inflate(LayoutInflater.from(requireContext()))

        val view = inflater.inflate(R.layout.item_shoe, container, false)

        if (viewModel.l_shoes.value!!.isNotEmpty())
        {
            for(v in viewModel.l_shoes.value!!)
//                view.findViewById<TextView>(R.id.tv_name).append(viewModel.single_shoe.value?.name)
//                view.findViewById<TextView>(R.id.tv_Company).append(viewModel.single_shoe.value?.company)
//                view.findViewById<TextView>(R.id.tv_size).append(viewModel.single_shoe.value?.size.toString())
//                view.findViewById<TextView>(R.id.tv_description).append(viewModel.single_shoe.value?.description)
                view.findViewById<TextView>(R.id.tv_name).append(viewModel.single_name.value)
                view.findViewById<TextView>(R.id.tv_Company).append(viewModel.single_company.value)
                view.findViewById<TextView>(R.id.tv_size).append(viewModel.single_size.value?.toString() ?:" Not set yet")
                view.findViewById<TextView>(R.id.tv_description).append(viewModel.single_description.value)
                binding.llList.addView(view)
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(F_Shoe_ListDirections.actionFShoeListToFShoeDetail())
        }

        return binding.root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.rv.layoutManager = LinearLayoutManager(requireActivity())
        viewModel.l_shoes.observe(viewLifecycleOwner, Observer {
            if(it != null)
            {
//                val adapter = RV_Shoe_Adapter(arrayListOf(Shoe("name", 9.3, "company", "description")))   // didn't work
                val adapter = RV_Shoe_Adapter(it)
                adapter.notifyDataSetChanged()
                // Setting the Adapter with the recyclerview
                binding.rv.adapter = adapter
                binding.rv.setHasFixedSize(true)

            }
        })*/
    }*/

}
