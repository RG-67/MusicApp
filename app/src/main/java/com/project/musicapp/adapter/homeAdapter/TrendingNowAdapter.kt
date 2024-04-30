package com.project.musicapp.adapter.homeAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.musicapp.databinding.TrendingRecyclerItemBinding
import com.project.musicapp.model.homeModel.trendingNow.TrendingNowModel

class TrendingNowAdapter(
    private val trModelList: ArrayList<TrendingNowModel> = ArrayList(),
    private val context: Context
) : RecyclerView.Adapter<TrendingNowAdapter.ViewHolder>() {

    class ViewHolder(val binding: TrendingRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            TrendingRecyclerItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return trModelList.size
    }
}