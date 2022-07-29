package com.example.shoestore_starter.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore_starter.R
import com.example.shoestore_starter.databinding.FShoeListBinding
import com.example.shoestore_starter.databinding.ItemShoeBinding
import com.example.shoestore_starter.viewmodels.VM_Shoe

// TODO: Rename parameter arguments, choose names that match

class F_Shoe_List : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FShoeListBinding
    private val viewModel by viewModels<VM_Shoe>({ requireActivity() })
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.f_shoe_list, container, false)
        navController = requireActivity().findNavController(R.id.myNavHostFragment)
        setHasOptionsMenu(true)

//        val itemBinding = ItemShoeBinding.inflate(LayoutInflater.from(requireContext()))

        val view = inflater.inflate(R.layout.item_shoe, container, false)

        if (viewModel.l_shoes.value!!.isNotEmpty())
        {
            for(v in viewModel.l_shoes.value!!){
                /*view.findViewById<TextView>(R.id.tv_name).append(viewModel.single_shoe.value?.name)
               view.findViewById<TextView>(R.id.tv_Company).append(viewModel.single_shoe.value?.company)
               view.findViewById<TextView>(R.id.tv_size).append(viewModel.single_shoe.value?.size.toString())
               view.findViewById<TextView>(R.id.tv_description).append(viewModel.single_shoe.value?.description)*/
                /*view.findViewById<TextView>(R.id.tv_name).append(viewModel.single_name.value)
                view.findViewById<TextView>(R.id.tv_Company).append(viewModel.single_company.value)
                view.findViewById<TextView>(R.id.tv_size).append(viewModel.single_size.value?.toString() ?:" Not set yet")
                view.findViewById<TextView>(R.id.tv_description).append(viewModel.single_description.value)*/
                view.findViewById<TextView>(R.id.tv_name).append(v.name)
                view.findViewById<TextView>(R.id.tv_Company).append(v.company)
                view.findViewById<TextView>(R.id.tv_size).append(v.size.toString() ?:" Not set yet")
                view.findViewById<TextView>(R.id.tv_description).append(v.description)
                binding.llList.addView(view)
            }

        }

        binding.fab.setOnClickListener {
            findNavController().navigate(F_Shoe_ListDirections.actionFShoeListToFShoeDetail())
        }

        return binding.root
    }

    // Inflating the menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_mainu, menu)

    }
    // Then select it's own action
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        navController.popBackStack(R.id.f_Welcome, true)
//        navController.navigate(F_Shoe_ListDirections.actionFShoeListToFLogin())
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item)
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
