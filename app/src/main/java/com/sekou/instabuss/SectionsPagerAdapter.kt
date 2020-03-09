package com.example.instabus

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm , FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private  val mFragmentList : MutableList<Fragment> = mutableListOf()
    private  val mFragmentTitleList : MutableList<String> = mutableListOf()

    fun addFragment(fragment: Fragment , title: String)
    {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
    override fun getItem(position: Int): Fragment {
        return  mFragmentList.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return  mFragmentTitleList.get(position)
    }

    override fun getCount(): Int {
        return 2
    }
}