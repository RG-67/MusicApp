package com.project.musicapp.fragment.mainFragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.musicapp.R
import com.project.musicapp.adapter.searchAdapter.BrowseAdapter
import com.project.musicapp.adapter.searchAdapter.GenreAdapter
import com.project.musicapp.databinding.FragmentSearchBinding
import com.project.musicapp.model.searchModel.BrowseModel
import com.project.musicapp.model.searchModel.GenreModel

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var ctx: Context
    private var genreAdapter: GenreAdapter? =null
    private var browseAdapter: BrowseAdapter? =null
    private val gnrList: ArrayList<GenreModel> = ArrayList()
    private val brList: ArrayList<BrowseModel> = ArrayList()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        setAdapter()
        return binding.root
    }

    private fun setAdapter() {
        gnrList.add(GenreModel("#electronic songs", R.drawable.artist))
        gnrList.add(GenreModel("#jazz songs", R.drawable.hnd_artist))
        gnrList.add(GenreModel("#pop songs", R.drawable.album3))
        gnrList.add(GenreModel("#rock songs", R.drawable.album1))
        gnrList.add(GenreModel("#hip hop songs", R.drawable.album4))
        genreAdapter = GenreAdapter(gnrList, ctx)
        binding.genreRecycler.adapter = genreAdapter

        brList.add(BrowseModel("Music", R.drawable.top_chart, "#FF5722"))
        brList.add(BrowseModel("Podcast", R.drawable.album1, "#FFD700"))
        brList.add(BrowseModel("Live Events", R.drawable.album3, "#053E1E"))
        brList.add(BrowseModel("New Release", R.drawable.album2, "#A2ACE3"))
        brList.add(BrowseModel("Podcast Charts", R.drawable.album4, "#FF5722"))
        brList.add(BrowseModel("Music", R.drawable.top_chart, "#FF5722"))
        brList.add(BrowseModel("Podcast", R.drawable.album1, "#FFD700"))
        brList.add(BrowseModel("Live Events", R.drawable.album3, "#053E1E"))
        brList.add(BrowseModel("New Release", R.drawable.album2, "#A2ACE3"))
        brList.add(BrowseModel("Podcast Charts", R.drawable.album4, "#FF5722"))
        browseAdapter = BrowseAdapter(brList, ctx)
        binding.browseRecycler.adapter = browseAdapter
    }

}