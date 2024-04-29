package com.project.musicapp.fragment.mainFragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.project.musicapp.R
import com.project.musicapp.adapter.homeAdapter.HomeAdapter
import com.project.musicapp.adapter.homeAdapter.TrendPagerAdapter
import com.project.musicapp.databinding.FragmentHomeBinding
import com.project.musicapp.model.mixArtist.MixArtistModel
import com.project.musicapp.model.newRelease.NewReleaseModel
import com.project.musicapp.model.topChart.TopChartModel
import com.project.musicapp.model.topSearch.TopSearchModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var ctx: Context
    private val topSearchList = ArrayList<TopSearchModel>()
    private val newRelList = ArrayList<NewReleaseModel>()
    private val mixArtistList = ArrayList<MixArtistModel>()
    private val topChartList = ArrayList<TopChartModel>()
    private var homeAdapter: HomeAdapter? = null
    private var trendPagerAdapter: TrendPagerAdapter? = null
    private var fragmentManager: FragmentManager? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        setAdapter()
        setTrNowTab()

        return binding.root
    }

    private fun setAdapter() {
        for (i in 0 until 5) {
            topSearchList.add(TopSearchModel(R.drawable.top_sr))
        }
        homeAdapter =
            HomeAdapter(topSearchList, newRelList, mixArtistList, topChartList, "TopSearch", ctx)
        binding.topSrRecycler.adapter = homeAdapter
        for (i in 0 until 5) {
            newRelList.add(NewReleaseModel(R.drawable.new_rel, "New English\nSongs"))
        }
        homeAdapter =
            HomeAdapter(topSearchList, newRelList, mixArtistList, topChartList, "NewRel", ctx)
        binding.newRelRecycler.adapter = homeAdapter
        for (i in 0 until 5) {
            mixArtistList.add(MixArtistModel(R.drawable.artist, "Taylor Swift"))
        }
        homeAdapter =
            HomeAdapter(topSearchList, newRelList, mixArtistList, topChartList, "MixArtist", ctx)
        binding.mixArtistRecycler.adapter = homeAdapter
        for (i in 0 until 5) {
            topChartList.add(TopChartModel(R.drawable.top_chart))
        }
        homeAdapter = HomeAdapter(topSearchList, newRelList, mixArtistList, topChartList, "", ctx)
        binding.topChartRecycler.adapter = homeAdapter
    }

    private fun setTrNowTab() {
        fragmentManager = requireActivity().supportFragmentManager
        trendPagerAdapter =
            TrendPagerAdapter(requireActivity().supportFragmentManager, requireActivity().lifecycle)
        binding.trendNowViewPager.adapter = trendPagerAdapter
        TabLayoutMediator(binding.trendNowTab, binding.trendNowViewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Bengali"
                }

                1 -> {
                    tab.text = "Hindi"
                }

                2 -> {
                    tab.text = "English"
                }
            }
        }.attach()
    }

}