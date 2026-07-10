package com.mk.zibchastocks.data.stocks.repository

import com.mk.zibchastocks.data.stocks.remote.datasource.StockRemoteDataSource
import com.mk.zibchastocks.domain.stocks.repository.StockRepository

class StockRepositoryImpl(
    private val dataSource: StockRemoteDataSource
) : StockRepository{

}