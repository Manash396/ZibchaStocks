package com.mk.zibchastocks.di

import com.mk.zibchastocks.data.contacts.repository.ContactRepositoryImpl
import com.mk.zibchastocks.domain.contacts.repository.ContactRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ContactModule {

    @Binds
    abstract fun bindContactRepository(
        impl: ContactRepositoryImpl
    ): ContactRepository   // single binding
}