package com.mk.zibchastocks.presentation.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mk.zibchastocks.presentation.contacts.ContactFragment
import com.mk.zibchastocks.presentation.stocks.StockFragment

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(p0: Int): Fragment {
        return if (p0 == 0) ContactFragment()
        else StockFragment()
    }

    override fun getItemCount(): Int {
        return 2
    }

}