package com.mk.zibchastocks.presentation.contacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.zibchastocks.data.contacts.mapper.ContactExportMapper
import com.mk.zibchastocks.domain.contacts.model.Contact
import com.mk.zibchastocks.domain.contacts.usecase.GetContactsUseCase
import com.mk.zibchastocks.domain.export.model.ExportType
import com.mk.zibchastocks.domain.export.usecase.ExportDataUseCase
import com.mk.zibchastocks.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val getContactsUseCase: GetContactsUseCase,
    private val exportDataUseCase: ExportDataUseCase
) : ViewModel(){

    private val _contacts = MutableLiveData<Result<List<Contact>>>()
    val contact: LiveData<Result<List<Contact>>> = _contacts
    var savedContacts = emptyList<Contact>()

    fun loadContact(){
        viewModelScope.launch {
            _contacts.value = Result.Loading

            val result = getContactsUseCase()
            delay(2000)
            _contacts.value = result
        }
    }

    fun exportContacts(exportType: ExportType){
        exportDataUseCase.execute(
            savedContacts ,
            ContactExportMapper(),
            exportType ,
            "Contacts${exportType}"
        )
    }

}