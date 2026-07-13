package com.mk.zibchastocks.domain.contacts.usecase

import com.mk.zibchastocks.domain.contacts.model.Contact
import com.mk.zibchastocks.domain.contacts.repository.ContactRepository
import com.mk.zibchastocks.util.Result
import javax.inject.Inject

class GetContactsUseCase @Inject constructor(
    private val repository: ContactRepository
) {
    suspend operator fun invoke(): Result<List<Contact>>{
        return repository.getContactList()
    }
}