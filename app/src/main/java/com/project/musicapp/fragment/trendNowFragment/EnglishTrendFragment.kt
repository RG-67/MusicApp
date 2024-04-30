package com.project.musicapp.fragment.trendNowFragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.musicapp.R
import com.project.musicapp.adapter.homeAdapter.TrendingNowAdapter
import com.project.musicapp.databinding.FragmentEnglishTrendBinding
import com.project.musicapp.databinding.FragmentHindiTrendBinding
import com.project.musicapp.model.homeModel.trendingNow.TrendingNowModel


class EnglishTrendFragment : Fragment() {

    private lateinit var binding: FragmentEnglishTrendBinding
    private lateinit var ctx: Context
    private var trNowAdapter: TrendingNowAdapter? = null
    private var trList: ArrayList<TrendingNowModel> = ArrayList()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEnglishTrendBinding.inflate(layoutInflater)
        setAdapter()
        return binding.root
    }

    private fun setAdapter() {
        for (i in 0 until 5) {
            trList.add(TrendingNowModel(R.drawable.artist, "Brazil waving flag", "Brazilian artist"))
        }
        trNowAdapter = TrendingNowAdapter(trList, ctx)
        binding.brTrendrecycler.adapter = trNowAdapter
    }

}