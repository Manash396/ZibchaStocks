package com.mk.zibchastocks.presentation.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mk.zibchastocks.presentation.ui.Tab1Fragment
import com.mk.zibchastocks.presentation.ui.Tab2Fragment

class ViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Tab1Fragment()
            1 -> Tab2Fragment()
            else -> Tab1Fragment()
        }
    }
}