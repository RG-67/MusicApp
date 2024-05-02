package com.project.musicapp.adapter.searchAdapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.musicapp.databinding.BrowseItemsBinding
import com.project.musicapp.model.searchModel.BrowseModel

class BrowseAdapter(
    private val browseModelList: ArrayList<BrowseModel> = ArrayList(),
    private val context: Context
): RecyclerView.Adapter<BrowseAdapter.ViewHolder>() {

    class ViewHolder(val binding: BrowseItemsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            BrowseItemsBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.brImg.setImageResource(browseModelList[position].img)
        holder.binding.title.text = browseModelList[position].title
        holder.binding.brCard.setCardBackgroundColor(Color.parseColor(browseModelList[position].backColor))
    }

    override fun getItemCount(): Int {
        return browseModelList.size
    }
}