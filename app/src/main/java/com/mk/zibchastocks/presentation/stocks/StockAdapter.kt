package com.mk.zibchastocks.presentation.stocks

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mk.zibchastocks.domain.stocks.model.Stock
import com.mk.zibchastocks.R
import com.mk.zibchastocks.databinding.StockItemBinding

class StockAdapter : ListAdapter<Stock, StockAdapter.StockViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): StockViewHolder {
        val binding = StockItemBinding.inflate(
            LayoutInflater.from(p0.context),
            p0,
            false
        )
        return StockViewHolder(binding)
    }

    override fun onBindViewHolder(
        p0: StockViewHolder,
        p1: Int
    ) {
        p0.bind(getItem(p1))
    }

    inner class StockViewHolder(
        val binding: StockItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(stock: Stock) {
            binding.tvCompanyName.text = stock.companyName
            binding.tvSymbol.text = stock.symbol
            binding.tvPrice.text = stock.currentPrice
            binding.tvChange.text = stock.changePercent

            // Change color dynamically
            if (stock.changePercent.startsWith("-")) {
                binding.tvChange.setTextColor(Color.RED)
                binding.tvChange.setBackgroundResource(R.drawable.bg_negative)
            } else {
                binding.tvChange.setTextColor(Color.GREEN)
                binding.tvChange.setBackgroundResource(R.drawable.bg_positive)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Stock>() {

            override fun areItemsTheSame(
                p0: Stock,
                p1: Stock
            ): Boolean {
                return p0.stockId == p1.stockId
            }

            override fun areContentsTheSame(
                p0: Stock,
                p1: Stock
            ): Boolean {
                return p0 == p1
            }
        }
    }

}
