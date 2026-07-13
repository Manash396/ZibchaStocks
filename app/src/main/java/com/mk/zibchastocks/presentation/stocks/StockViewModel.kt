package com.mk.zibchastocks.presentation.stocks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mk.zibchastocks.data.stocks.mapper.StockExportMapper
import com.mk.zibchastocks.domain.export.model.ExportType
import com.mk.zibchastocks.domain.export.usecase.ExportDataUseCase
import com.mk.zibchastocks.domain.stocks.model.Stock
import com.mk.zibchastocks.domain.stocks.usecase.GetStocksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.mk.zibchastocks.util.Result

@HiltViewModel
class StockViewModel @Inject constructor(
    private val getStocksUseCase: GetStocksUseCase,
    private val exportDataUseCase: ExportDataUseCase
) : ViewModel() {


    private val _stocks = MutableLiveData<Result<List<Stock>>>()
    val stocks: LiveData<Result<List<Stock>>> = _stocks


    var savedStocks = emptyList<Stock>()


    fun loadStocks() {

        viewModelScope.launch {

            _stocks.value = Result.Loading

            val result = getStocksUseCase()

            delay(2000)

            _stocks.value = result
        }

    }


    fun exportStocks(exportType: ExportType) {

        exportDataUseCase.execute(
            savedStocks,
            StockExportMapper(),
            exportType,
            "Stocks${exportType}"
        )

    }
}