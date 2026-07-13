package com.mk.zibchastocks.presentation.contacts

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.mk.zibchastocks.databinding.FragmentContactBinding
import com.mk.zibchastocks.domain.export.model.ExportType
import com.mk.zibchastocks.util.AppConstant.exportOptions
import com.mk.zibchastocks.util.Result
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactFragment : Fragment() {


    private var _binding: FragmentContactBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ContactViewModel by viewModels()
    private lateinit var adapter : ContactAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
        setUpOnclick()
        setObserver()
        viewModel.loadContact()
    }

    private fun setUpOnclick() {
        binding.btn.setOnClickListener {
            showExportDialog()
        }
    }

    private fun setUpAdapter() {
        adapter  = ContactAdapter()
        with(binding){
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setObserver() {
        viewModel.contact.observe(viewLifecycleOwner){ result ->
            when(result){
              is  Result.Success -> {
                  val data  = result.data
                  adapter.submitList(data)
                  viewModel.savedContacts = data

                  binding.progressBar.visibility = View.INVISIBLE
                }
              is Result.Error -> {

              }
              is Result.Loading -> {
                  binding.progressBar.visibility = View.VISIBLE
              }
            }
        }
    }

    private fun showExportDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Export Contacts")
            .setItems(exportOptions) { _, which ->
                when (which) {
                    0 -> viewModel.exportContacts(ExportType.CSV)
                    1 -> viewModel.exportContacts(ExportType.PDF)
                    2 -> viewModel.exportContacts(ExportType.JSON)
                }
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}