package com.mk.zibchastocks.presentation.stocks

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mk.zibchastocks.databinding.FragmentStockBinding
import com.mk.zibchastocks.domain.export.model.ExportType
import com.mk.zibchastocks.util.AppConstant.exportOptions
import com.mk.zibchastocks.util.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockFragment : Fragment() {

    private var _binding: FragmentStockBinding? = null
    private val binding get() = _binding!!

    private val viewModel: StockViewModel by viewModels()

    private lateinit var adapter: StockAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStockBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
        setUpOnClick()
        setObserver()

        viewModel.loadStocks()
    }


    private fun setUpAdapter() {

        adapter = StockAdapter()

        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }


    private fun setUpOnClick() {

        binding.btn.setOnClickListener {
            showExportDialog()
        }
    }


    private fun setObserver() {

        viewModel.stocks.observe(viewLifecycleOwner) { result ->

            when (result) {

                is Result.Success -> {

                    val data = result.data

                    adapter.submitList(data)

                    viewModel.savedStocks = data

                    binding.progressBar.visibility = View.INVISIBLE
                }


                is Result.Error -> {

                    binding.progressBar.visibility = View.INVISIBLE

                    // show error message if needed
                }


                is Result.Loading -> {

                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        }
    }


    private fun showExportDialog() {

        AlertDialog.Builder(requireContext())
            .setTitle("Export Stocks")
            .setItems(exportOptions) { _, which ->

                when (which) {

                    0 -> viewModel.exportStocks(ExportType.CSV)

                    1 -> viewModel.exportStocks(ExportType.PDF)

                    2 -> viewModel.exportStocks(ExportType.JSON)
                }
            }
            .show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}