package com.example.myedu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterHorizontal(private val mapelList: List<MapelData>) : RecyclerView.Adapter<AdapterHorizontal.MapelViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MapelData)
    }

    class MapelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mapelName: TextView = itemView.findViewById(R.id.namaPelajaran1)
        val mapelImage: ImageView = itemView.findViewById(R.id.gambarPelajaran1)
        val txt_see: TextView = itemView.findViewById(R.id.txt_see1)
        val see: ImageView = itemView.findViewById(R.id.see1)
        val txt_download: TextView = itemView.findViewById(R.id.txt_download1)
        val download: ImageView = itemView.findViewById(R.id.download1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapelViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.rv_horizontal, parent, false)
        return MapelViewHolder(view)
    }

    override fun getItemCount(): Int = mapelList.size

    override fun onBindViewHolder(holder: MapelViewHolder, position: Int) {
        val data = mapelList[position]

        holder.mapelName.text = data.name
        holder.mapelImage.setImageResource(data.image)
        holder.txt_see.text = data.txt_see
        holder.see.setImageResource(data.see)
        holder.txt_download.text = data.txt_download
        holder.download.setImageResource(data.download)

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(mapelList[holder.adapterPosition]) }
    }
}
