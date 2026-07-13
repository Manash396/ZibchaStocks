package com.mk.zibchastocks.domain.contacts.usecase

import com.mk.zibchastocks.domain.contacts.repository.ContactRepository
import javax.inject.Inject

class GetContactsUseCase @Inject constructor(
    private val repository: ContactRepository
) {

}