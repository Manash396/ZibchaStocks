package com.mk.zibchastocks.domain.stocks.model

data class Stock(
    val companyName: String,
    val symbol: String,
    val currentPrice: String,
    val changePercent: String
)
