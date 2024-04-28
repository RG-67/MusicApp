package com.project.musicapp.adapter.homeAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.musicapp.databinding.HomeRecyclerLayoutBinding
import com.project.musicapp.model.topSearch.TopSearchModel

class HomeAdapter(
    private val topModelList: ArrayList<TopSearchModel> = ArrayList(),
    private val context: Context
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(binding: HomeRecyclerLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            HomeRecyclerLayoutBinding.inflate(LayoutInflater.from(context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return topModelList.size
    }
}