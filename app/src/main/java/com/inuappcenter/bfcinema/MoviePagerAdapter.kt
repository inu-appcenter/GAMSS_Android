package com.inuappcenter.bfcinema

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MoviePagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val list: ArrayList<Fragment> = ArrayList()

    init {
        list.add(FirstPageFragment())
        list.add(SecondPageFragment())
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list.get(position)
    }
}