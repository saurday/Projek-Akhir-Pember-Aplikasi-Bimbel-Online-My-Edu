package com.example.myedu.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myedu.R

class RetrofitActivity(
    private val mapelList: List<Mapel>,
    private val onItemClickCallback: OnItemClickCallback
) : RecyclerView.Adapter<RetrofitActivity.MapelViewHolder>() {

    interface OnItemClickCallback {
        fun onItemClicked(data: Mapel)
    }

    class MapelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gambarMapel: ImageView = itemView.findViewById(R.id.img_mapel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapelViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mapel, parent, false)
        return MapelViewHolder(view)
    }

    override fun onBindViewHolder(holder: MapelViewHolder, position: Int) {
        val data = mapelList[position]
        Glide.with(holder.gambarMapel.context)
            .load(data.gambar)
            .into(holder.gambarMapel)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(mapelList[position])
        }
    }

    override fun getItemCount(): Int = mapelList.size
}
