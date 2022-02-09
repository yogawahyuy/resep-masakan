package com.snystudio.resepmasakanharian.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    var fragmentArrayList = ArrayList<Fragment>()
    override fun getCount(): Int {
        return fragmentArrayList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentArrayList.get(position)
    }

    fun addFragments(fragment: Fragment){
        fragmentArrayList.add(fragment)
    }

}