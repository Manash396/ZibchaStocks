package com.mk.zibchastocks.data.stocks.mapper

import com.mk.zibchastocks.domain.export.mapper.ExportMapper
import com.mk.zibchastocks.domain.export.model.ExportRow
import com.mk.zibchastocks.domain.stocks.model.Stock
import com.mk.zibchastocks.util.AppConstant
import javax.inject.Inject

class StockExportMapper @Inject constructor() : ExportMapper<Stock> {
    override fun map(data: Stock): ExportRow {
        return ExportRow(
            mapOf(
                AppConstant.Stock.COMPANY_NAME to data.companyName,
                AppConstant.Stock.SYMBOL to data.symbol,
                AppConstant.Stock.PRICE to data.currentPrice,
                AppConstant.Stock.CHANGE_PERCENT to data.changePercent
            )
        )
    }

}