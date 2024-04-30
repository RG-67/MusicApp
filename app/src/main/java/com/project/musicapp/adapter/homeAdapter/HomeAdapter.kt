package com.project.musicapp.adapter.homeAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.musicapp.databinding.HomeRecyclerLayoutBinding
import com.project.musicapp.model.homeModel.mixArtist.MixArtistModel
import com.project.musicapp.model.homeModel.newRelease.NewReleaseModel
import com.project.musicapp.model.homeModel.topChart.TopChartModel
import com.project.musicapp.model.homeModel.topSearch.TopSearchModel

class HomeAdapter(
    private val topModelList: ArrayList<TopSearchModel> = ArrayList(),
    private val newRelModelList: ArrayList<NewReleaseModel> = ArrayList(),
    private val mixArtistModelList: ArrayList<MixArtistModel> = ArrayList(),
    private val topChartModelList: ArrayList<TopChartModel> = ArrayList(),
    private val adapterType: String = "",
    private val context: Context
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(val binding: HomeRecyclerLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HomeRecyclerLayoutBinding.inflate(LayoutInflater.from(context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (adapterType) {
            "TopSearch" -> {
                holder.binding.newRlseRel.visibility = View.GONE
                holder.binding.mixArtistRel.visibility = View.GONE
                holder.binding.topChartRel.visibility = View.GONE
                holder.binding.topSrRel.visibility = View.VISIBLE
            }

            "NewRel" -> {
                holder.binding.topSrRel.visibility = View.GONE
                holder.binding.mixArtistRel.visibility = View.GONE
                holder.binding.topChartRel.visibility = View.GONE
                holder.binding.newRlseRel.visibility = View.VISIBLE
            }

            "MixArtist" -> {
                holder.binding.topSrRel.visibility = View.GONE
                holder.binding.newRlseRel.visibility = View.GONE
                holder.binding.topChartRel.visibility = View.GONE
                holder.binding.mixArtistRel.visibility = View.VISIBLE
            }

            else -> {
                holder.binding.topSrRel.visibility = View.GONE
                holder.binding.newRlseRel.visibility = View.GONE
                holder.binding.mixArtistRel.visibility = View.GONE
                holder.binding.topChartRel.visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return when (adapterType) {
            "TopSearch" -> {
                topModelList.size
            }

            "NewRel" -> {
                newRelModelList.size
            }

            "MixArtist" -> {
                mixArtistModelList.size
            }

            else -> {
                topChartModelList.size
            }
        }
    }
}