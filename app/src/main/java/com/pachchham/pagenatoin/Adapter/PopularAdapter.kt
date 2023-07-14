package com.pachchham.pagenatoin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.pachchham.pagenatoin.Client.ApiClient
import com.pachchham.pagenatoin.Modal.ResultsItem
import com.pachchham.pagenatoin.databinding.MovieItemBinding

class PopularAdapter : Adapter<PopularAdapter.PopularHoder>() {

    lateinit var popularList: List<ResultsItem?>
    lateinit var context: Context

    class PopularHoder(itemView: MovieItemBinding) : ViewHolder(itemView.root) {
        var binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularHoder {
        context = parent.context
        var binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularHoder(binding)
    }

    override fun getItemCount(): Int {
        return popularList.size
    }

    override fun onBindViewHolder(holder: PopularHoder, position: Int) {
        holder.binding.apply {

            popularList.get(position)?.apply {

                Glide.with(context).load(ApiClient.Image_Base_Url+posterPath).into(imgPoster)
                txtTitel.text = originalTitle
                txtDescription.text = overview

            }
        }
    }

    fun setListing(popularList: List<ResultsItem?>?) {
        this.popularList = popularList as List<ResultsItem?>
    }


}