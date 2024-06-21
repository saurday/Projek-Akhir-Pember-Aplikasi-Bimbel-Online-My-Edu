package com.example.myedu.binggris

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.R

class BingAdapter(private val context: Context, private val bingList: List<BingData>) : RecyclerView.Adapter<BingAdapter.BingViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: BingData)
    }

    inner class BingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bingImage: ImageView = itemView.findViewById(R.id.img_bing)

        init {
            itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(bingList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BingViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_bing, parent, false)
        return BingViewHolder(view)
    }

    override fun onBindViewHolder(holder: BingViewHolder, position: Int) {
        val data = bingList[position]
        holder.bingImage.setImageResource(data.gambar)
    }

    override fun getItemCount(): Int = bingList.size
}
