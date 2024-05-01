package com.project.musicapp.adapter.otherAdapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.musicapp.activity.PlayMusicActivity
import com.project.musicapp.databinding.MusicItemLayoutBinding
import com.project.musicapp.model.otherModel.MusicItemModel

class MusicListAdapter(
    private val musicItemList: ArrayList<MusicItemModel> = ArrayList(),
    private val context: Context
) : RecyclerView.Adapter<MusicListAdapter.ViewHolder>() {

    class ViewHolder(val binding: MusicItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MusicItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.songImg.setImageResource(musicItemList[position].img)
        holder.binding.songName.text = musicItemList[position].songName
        holder.binding.artistName.text = musicItemList[position].artistName
        holder.binding.songDetailLin.setOnClickListener {
            val intent = Intent(context, PlayMusicActivity::class.java)
            intent.putExtra("pos", position.toString())
            intent.putExtra("songName", musicItemList[position].songName)
            intent.putExtra("artistName", musicItemList[position].artistName)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return musicItemList.size
    }
}