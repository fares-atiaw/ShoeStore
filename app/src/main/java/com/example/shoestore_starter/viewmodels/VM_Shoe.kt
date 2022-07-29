package com.example.shoestore_starter.viewmodels

import android.text.Editable
import android.util.Log
import android.widget.EditText
import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore_starter.models.Shoe

class VM_Shoe : ViewModel() {

//    private var _single_shoe = MutableLiveData<Shoe>()
//    val single_shoe: LiveData<Shoe>
//        get() = _single_shoe

    private var _single_name = MutableLiveData<String>()
    val single_name: LiveData<String>
        get() = _single_name
//    fun updateName(s: Editable) {
//        _single_name.value = s.toString() }

    private var _single_company = MutableLiveData<String>()
    val single_company: LiveData<String>
        get() = _single_company
//    fun updateCompany(s: Editable) {
//        _single_company.value = s.toString() }

    private var _single_size = MutableLiveData<Double>()
        val single_size: LiveData<Double>
            get() = _single_size
    /*fun updateSize(s: Editable) {
//        if(s.equals(null))
//            _single_size.value = 0.0
//        else {
//            if(s.contains('.'))
//            _single_size.value = s.toString().plus('.').toDouble()
//            Log.w("_single_size.value => ", "${ _single_size.value}")
//        }
    }*/

    private var _single_description = MutableLiveData<String>()
    val single_description: LiveData<String>
        get() = _single_description
//    fun updateDescription(s: Editable) {
//        _single_description.value = s.toString() }

    private val _l_shoes = MutableLiveData<ArrayList<Shoe>>(arrayListOf())
    val l_shoes: LiveData<ArrayList<Shoe>>
        get() = _l_shoes



    fun addShoe(){
        Log.w("12345", "${_single_name.value}")       // null ?!
        _l_shoes.value?.add(Shoe(_single_name.value!!, _single_size.value?:0.0, _single_company.value!!, _single_description.value!!))
        Log.w("hhhh added", l_shoes.value.toString())
    }

}

//().default(Shoe("s","l",11,"k"))
//    Shoe("s",1.1,"l","k")