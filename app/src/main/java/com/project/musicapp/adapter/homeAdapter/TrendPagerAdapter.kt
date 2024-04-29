package com.project.musicapp.adapter.homeAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.musicapp.fragment.trendNowFragment.BengaliTrendFragment
import com.project.musicapp.fragment.trendNowFragment.EnglishTrendFragment
import com.project.musicapp.fragment.trendNowFragment.HindiTrendFragment


class TrendPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                BengaliTrendFragment()
            }

            1 -> {
                HindiTrendFragment()
            }

            else -> {
                EnglishTrendFragment()
            }
        }
    }

}