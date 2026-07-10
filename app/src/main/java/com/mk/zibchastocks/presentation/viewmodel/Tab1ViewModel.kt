package com.mk.zibchastocks.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mk.zibchastocks.presentation.state.ContactState

class ContactViewModel : ViewModel() {

    private val _contacts = MutableLiveData<ArrayList<ContactState>>()
    val contacts: LiveData<ArrayList<ContactState>> = _contacts

    init {
        loadContacts()
    }

    private fun loadContacts() {

        val list = arrayListOf(
            ContactState("Avnish Yadav", "9876543210"),
            ContactState("Rahul Sharma", "9876543211"),
            ContactState("Aman Singh", "9876543212"),
            ContactState("Manash", "9876543213"),
            ContactState("Ravi Gupta", "9876543214")
        )

        _contacts.value = list
    }
}