package com.mk.zibchastocks.domain.stocks.model

data class Stock(
    val stockId : Int = 0,
    val companyName: String,
    val symbol: String,
    val currentPrice: String,
    val changePercent: String
)
