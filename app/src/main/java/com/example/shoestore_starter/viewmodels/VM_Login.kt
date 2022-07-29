package com.example.shoestore_starter.viewmodels

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore_starter.models.Shoe

class VM_Login : ViewModel() {

    private var _email = MutableLiveData<String>()
    val email: LiveData<String>
        get() = _email
//    fun updateEmail(s: Editable) {
//        _email.value = s.toString() }

    private var _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password
//    fun updatePassword(s: Editable) {
//        _password.value = s.toString() }


}