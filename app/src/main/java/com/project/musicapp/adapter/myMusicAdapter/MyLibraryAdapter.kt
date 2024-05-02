package com.project.musicapp.adapter.myMusicAdapter

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.project.musicapp.R
import com.project.musicapp.clickListener.AdapterClickListener
import com.project.musicapp.databinding.MyLibItemBinding
import com.project.musicapp.model.myMusicModel.myLibraryModel.MyLibraryModel

class MyLibraryAdapter(
    private val myLibList: ArrayList<MyLibraryModel> = ArrayList(),
    private val context: Context,
    private val viewType: String
) : RecyclerView.Adapter<MyLibraryAdapter.ViewHolder>() {

    private var adapterClickListener: AdapterClickListener? = null

    class ViewHolder(val binding: MyLibItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MyLibItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (viewType) {
            "Linear" -> {
                when (myLibList[position].viewType) {
                    "Artist" -> {
                        holder.binding.linearRoundImg.setImageResource(myLibList[position].img)
                        holder.binding.linearLin.visibility = View.GONE
                        holder.binding.linSqImg.visibility = View.GONE
                        holder.binding.linPin.visibility = View.GONE
                        holder.binding.linearRoundImg.visibility = View.VISIBLE
                        holder.binding.linearDesc.visibility = View.VISIBLE
                    }

                    "Lib" -> {
                        when (myLibList[position].name) {
                            "Your Episodes" -> {
                                holder.binding.linearLin.setBackgroundColor(
                                    ContextCompat.getColor(
                                        context,
                                        R.color.bottom_item_color
                                    )
                                )
                            }

                            "Local Files" -> {
                                holder.binding.linearLin.setBackgroundColor(
                                    ContextCompat.getColor(
                                        context,
                                        R.color.deep_blue
                                    )
                                )
                            }

                            else -> {
                                holder.binding.linearLin.dividerDrawable =
                                    ContextCompat.getDrawable(context, R.drawable.my_item_bg)
                            }
                        }
                        holder.binding.linSqImg.setImageResource(myLibList[position].img)
                        holder.binding.linSqImg.setColorFilter(
                            ContextCompat.getColor(
                                context,
                                R.color.light_blue
                            ), android.graphics.PorterDuff.Mode.MULTIPLY
                        )
                        holder.binding.linearRoundImg.visibility = View.GONE
                        holder.binding.linPin.visibility = View.VISIBLE
                        holder.binding.linearLin.visibility = View.VISIBLE
                        holder.binding.linSqImg.visibility = View.VISIBLE
                        holder.binding.linearDesc.visibility = View.VISIBLE
                    }

                    else -> {
                        holder.binding.linearLin.setBackgroundColor(
                            ContextCompat.getColor(
                                context,
                                R.color.grey
                            )
                        )
                        holder.binding.linSqImg.setImageResource(myLibList[position].img)
                        holder.binding.linSqImg.setColorFilter(
                            ContextCompat.getColor(
                                context,
                                R.color.light_grey
                            ), android.graphics.PorterDuff.Mode.MULTIPLY
                        )
                        holder.binding.linearDesc.visibility = View.GONE
                        holder.binding.linPin.visibility = View.GONE
                    }
                }
                holder.binding.gridView.visibility = View.GONE
                holder.binding.linView.visibility = View.VISIBLE
                holder.binding.linearLibName.text = myLibList[position].name
                holder.binding.linearDesc.text = myLibList[position].desc
            }

            "Grid" -> {
                when (myLibList[position].viewType) {
                    "Artist" -> {
                        holder.binding.gridRoundImg.setImageResource(myLibList[position].img)
                        holder.binding.gridPin.visibility = View.GONE
                        holder.binding.gridLin.visibility = View.GONE
                        holder.binding.gridSqImg.visibility = View.GONE
                        holder.binding.gridRoundImg.visibility = View.VISIBLE
                        holder.binding.gridLibDesc.visibility = View.VISIBLE
                    }

                    "Lib" -> {
                        holder.binding.gridSqImg.setColorFilter(
                            R.color.light_blue,
                            android.graphics.PorterDuff.Mode.MULTIPLY
                        )
                        holder.binding.gridSqImg.setImageResource(myLibList[position].img)
                        holder.binding.gridLin.dividerDrawable =
                            ContextCompat.getDrawable(context, R.drawable.my_item_bg)
                        holder.binding.gridRoundImg.visibility = View.GONE
                        holder.binding.gridPin.visibility = View.VISIBLE
                        holder.binding.gridLin.visibility = View.VISIBLE
                        holder.binding.gridSqImg.visibility = View.VISIBLE
                        holder.binding.gridLibDesc.visibility = View.VISIBLE
                    }

                    else -> {
                        holder.binding.gridLin.setBackgroundColor(
                            ContextCompat.getColor(
                                context,
                                R.color.grey
                            )
                        )
                        holder.binding.gridSqImg.setImageResource(myLibList[position].img)
                        holder.binding.gridSqImg.setColorFilter(
                            ContextCompat.getColor(
                                context,
                                R.color.light_grey
                            ), android.graphics.PorterDuff.Mode.MULTIPLY
                        )
                        holder.binding.gridPin.visibility = View.GONE
                        holder.binding.gridLibDesc.visibility = View.GONE
                        holder.binding.linPin.visibility = View.GONE
                    }
                }
                holder.binding.linView.visibility = View.GONE
                holder.binding.gridView.visibility = View.VISIBLE
                holder.binding.gridLibName.text = myLibList[position].name
                holder.binding.gridLibDesc.text = myLibList[position].desc
            }
        }
        holder.itemView.setOnClickListener {
            if (myLibList[position].name == "Liked Songs") {
                adapterClickListener?.onClick()
            } else {
                Snackbar.make(it, "Songs not available", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return myLibList.size
    }

    fun setAdapterOnclick(listener: AdapterClickListener) {
        this.adapterClickListener = listener
    }

}