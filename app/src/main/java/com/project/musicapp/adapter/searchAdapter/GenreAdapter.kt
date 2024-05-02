package com.project.musicapp.adapter.searchAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.musicapp.databinding.GenreItemBinding
import com.project.musicapp.model.searchModel.GenreModel

class GenreAdapter(
    private val genreModelList: ArrayList<GenreModel> = ArrayList(),
    private val context: Context
): RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    class ViewHolder(val binding: GenreItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            GenreItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.gnrImg.setImageResource(genreModelList[position].img)
        holder.binding.title.text = genreModelList[position].title
    }

    override fun getItemCount(): Int {
        return genreModelList.size
    }
}