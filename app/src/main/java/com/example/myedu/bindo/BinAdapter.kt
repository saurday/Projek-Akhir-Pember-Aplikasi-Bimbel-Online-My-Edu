package com.example.myedu.bindo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.R
import com.example.myedu.binggris.BingAdapter
import com.example.myedu.binggris.BingData

class BinAdapter (private val binList: List<BinData>) : RecyclerView.Adapter<BinAdapter.BinViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: BinData)
    }

    class BinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binImage: ImageView = itemView.findViewById(R.id.img_bin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_bin, parent, false)
        return BinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BinViewHolder, position: Int) {
        val data = binList[position]
        holder.binImage.setImageResource(data.gambar)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(binList[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = binList.size
}