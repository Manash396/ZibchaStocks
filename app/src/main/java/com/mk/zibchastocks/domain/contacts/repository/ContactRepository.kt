package com.mk.zibchastocks.domain.contacts.repository

import com.mk.zibchastocks.domain.contacts.model.Contact
import com.mk.zibchastocks.util.Result

interface ContactRepository {

    suspend fun getContactList() : Result<List<Contact>>

}