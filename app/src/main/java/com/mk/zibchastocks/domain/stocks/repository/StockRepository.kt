package com.mk.zibchastocks.domain.stocks.repository

import com.mk.zibchastocks.domain.stocks.model.Stock
import com.mk.zibchastocks.util.Result

interface StockRepository {
    suspend fun getStockList(): Result<List<Stock>>
}