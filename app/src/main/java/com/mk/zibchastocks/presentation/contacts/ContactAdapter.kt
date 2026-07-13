package com.mk.zibchastocks.presentation.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mk.zibchastocks.databinding.ContactItemBinding
import com.mk.zibchastocks.domain.contacts.model.Contact

class ContactAdapter : ListAdapter<Contact, ContactAdapter.ContactViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): ContactViewHolder {
        val itemBinding = ContactItemBinding.inflate(LayoutInflater.from(p0.context),p0,false)
        return ContactViewHolder(itemBinding)
    }

    override fun onBindViewHolder(
        p0: ContactViewHolder,
        p1: Int
    ) {
        p0.bind(getItem(p1))
    }

    inner class ContactViewHolder(
        private val itemBinding: ContactItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(contact : Contact){
            itemBinding.tvName.text = contact.name
            itemBinding.tvPhone.text = contact.phone
            itemBinding.tvAvatar.text = contact.name[0].toString()
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Contact>() {
            override fun areItemsTheSame(
                p0: Contact,
                p1: Contact
            ): Boolean {
                return p0.phone == p1.phone
            }

            override fun areContentsTheSame(
                p0: Contact,
                p1: Contact
            ): Boolean {
                return p0 == p1
            }


        }
    }
}