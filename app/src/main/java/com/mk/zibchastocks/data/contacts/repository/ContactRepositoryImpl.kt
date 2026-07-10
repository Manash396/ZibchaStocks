package com.mk.zibchastocks.data.contacts.repository

import com.mk.zibchastocks.data.contacts.remote.datasource.ContactRemoteDataSource
import com.mk.zibchastocks.domain.contacts.repository.ContactRepository

class ContactRepositoryImpl(
    private val dataSource: ContactRemoteDataSource
) : ContactRepository{

}