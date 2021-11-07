package com.example.cocinamos

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.cocinamos.addRecipeFragments.Comment
import com.example.cocinamos.addRecipeFragments.HowToCookThis
import com.example.cocinamos.addRecipeFragments.Overview

class TabsAdapter(fm: FragmentManager, var mNumOfTabs: Int) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return mNumOfTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Overview()
            }
            1 -> {
                HowToCookThis()
            }
            2 -> {
                Comment()
            }
            else -> Overview()
        }
    }
}