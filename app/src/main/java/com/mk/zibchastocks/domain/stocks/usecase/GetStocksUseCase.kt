package com.mk.zibchastocks.domain.stocks.usecase

import com.mk.zibchastocks.domain.stocks.model.Stock
import com.mk.zibchastocks.domain.stocks.repository.StockRepository
import com.mk.zibchastocks.util.Result
import javax.inject.Inject

class GetStocksUseCase @Inject constructor(
    private val repository: StockRepository
) {

    suspend operator fun invoke(): Result<List<Stock>> {
        return repository.getStockList()
    }

}