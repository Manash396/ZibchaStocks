package com.mk.zibchastocks.data.stocks.repository

import com.mk.zibchastocks.data.stocks.remote.datasource.StockRemoteDataSource
import com.mk.zibchastocks.domain.stocks.model.Stock
import com.mk.zibchastocks.domain.stocks.repository.StockRepository
import com.mk.zibchastocks.util.Result
import javax.inject.Inject

class StockRepositoryImpl @Inject constructor(
    private val dataSource: StockRemoteDataSource
) : StockRepository{
    override suspend fun getStockList(): Result<List<Stock>> {
        return Result.Success(
            data = stockList
        )
    }


    val stockList = listOf(
        Stock(1, "Reliance Industries", "REL", "₹2950.50", "+1.25%"),
        Stock(2, "TCS", "TCS", "₹3850.20", "-0.45%"),
        Stock(3, "Infosys", "INF", "₹1500.75", "+0.80%"),
        Stock(4, "HDFC Bank", "HDF", "₹1650.10", "+0.60%"),
        Stock(5, "ICICI Bank", "ICI", "₹980.45", "-0.30%"),
        Stock(6, "Wipro", "WIP", "₹420.30", "+1.10%"),
        Stock(7, "HCL Tech", "HCL", "₹1255.60", "-0.20%"),
        Stock(8, "SBI", "SBI", "₹620.90", "+0.95%"),
        Stock(9, "Axis Bank", "AXB", "₹1020.75", "+0.40%"),
        Stock(10, "Kotak Bank", "KOT", "₹1805.25", "-0.55%"),
        Stock(11, "Adani Enterprises", "ADE", "₹3100.00", "+2.10%"),
        Stock(12, "Adani Ports", "ADP", "₹850.60", "+1.75%"),
        Stock(13, "Bajaj Finance", "BAJ", "₹7200.45", "-1.20%"),
        Stock(14, "Maruti Suzuki", "MAR", "₹10250.80", "+0.35%"),
        Stock(15, "Tata Motors", "TAT", "₹950.30", "+2.50%"),
        Stock(16, "Zomato", "ZOM", "₹210.15", "-0.80%"),
        Stock(17, "Paytm", "PAY", "₹650.25", "+1.05%"),
        Stock(18, "IRCTC", "IRC", "₹720.50", "+0.90%"),
        Stock(19, "Larsen & Toubro", "LNT", "₹3500.75", "+0.65%"),
        Stock(20, "ONGC", "ONG", "₹275.40", "-0.15%")
    )

}