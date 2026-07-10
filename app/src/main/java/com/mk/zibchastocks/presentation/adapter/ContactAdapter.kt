package com.mk.zibchastocks.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mk.zibchastocks.databinding.ItemContactBinding
import com.mk.zibchastocks.presentation.state.ContactState


class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private val contactList = ArrayList<ContactState>()

    fun submitList(list: List<ContactState>) {
        contactList.clear()
        contactList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ContactViewHolder(val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        val binding = ItemContactBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ContactViewHolder(binding)
    }

    override fun getItemCount() = contactList.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        val contact = contactList[position]

        holder.binding.contact = contact
        holder.binding.txtInitial.text =
            contact.name.firstOrNull()?.uppercase() ?: ""

        holder.binding.executePendingBindings()
    }
}