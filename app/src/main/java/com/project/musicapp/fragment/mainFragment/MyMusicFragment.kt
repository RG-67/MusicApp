package com.project.musicapp.fragment.mainFragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.musicapp.R
import com.project.musicapp.adapter.myMusicAdapter.MyLibraryAdapter
import com.project.musicapp.databinding.FragmentMyMusicBinding
import com.project.musicapp.model.myMusicModel.myLibraryModel.MyLibraryModel

class MyMusicFragment : Fragment() {

    private lateinit var binding: FragmentMyMusicBinding
    private lateinit var ctx: Context
    private var myLibraryAdapter: MyLibraryAdapter? = null
    private val myLibList: ArrayList<MyLibraryModel> = ArrayList()
    private var type = 1

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyMusicBinding.inflate(layoutInflater)
        setClickMethod()
        setAdapter("Linear")
        return binding.root
    }

    private fun setClickMethod() {
        binding.viewTypeBtn.setOnClickListener {
            type = if (type == 1) {
                binding.viewTypeBtn.setImageResource(R.drawable.line_dots)
                setAdapter("Grid")
                2
            } else {
                binding.viewTypeBtn.setImageResource(R.drawable.dots)
                setAdapter("Linear")
                1
            }
        }
    }

    private fun setAdapter(type: String) {
        myLibList.clear()
        myLibList.add(MyLibraryModel(R.drawable.like, "Liked Songs", "Playlist . 12 songs", "Lib"))
        myLibList.add(MyLibraryModel(R.drawable.like, "Liked Songs", "Playlist . 12 songs", "Lib"))
        myLibList.add(MyLibraryModel(R.drawable.like, "Liked Songs", "Playlist . 12 songs", "Lib"))
        myLibList.add(MyLibraryModel(R.drawable.like, "Liked Songs", "Playlist . 12 songs", "Lib"))
        myLibList.add(MyLibraryModel(R.drawable.like, "Liked Songs", "Playlist . 12 songs", "Lib"))
        myLibList.add(MyLibraryModel(R.drawable.top_chart, "Taylor Swift", "Artist", "Artist"))
        myLibList.add(MyLibraryModel(R.drawable.top_chart, "Taylor Swift", "Artist", "Artist"))
        myLibList.add(MyLibraryModel(R.drawable.top_chart, "Taylor Swift", "Artist", "Artist"))
        myLibList.add(MyLibraryModel(R.drawable.add, "Add artists", "", ""))
        myLibList.add(MyLibraryModel(R.drawable.add, "Add podcasts", "", ""))
        if (type == "Linear") {
            binding.myLibRecycler.layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
        } else {
            binding.myLibRecycler.layoutManager = GridLayoutManager(ctx, 3)
        }
        myLibraryAdapter = MyLibraryAdapter(myLibList, ctx, type)
        binding.myLibRecycler.adapter = myLibraryAdapter
    }

}