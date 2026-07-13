package com.mk.zibchastocks.di

import com.mk.zibchastocks.data.contacts.repository.ContactRepositoryImpl
import com.mk.zibchastocks.data.stocks.repository.StockRepositoryImpl
import com.mk.zibchastocks.domain.contacts.repository.ContactRepository
import com.mk.zibchastocks.domain.stocks.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StockModule {

    @Binds
    abstract fun bindStockRepository(
        impl: StockRepositoryImpl
    ): StockRepository   // single binding
}