package com.example.myedu.kimia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.R
import com.example.myedu.binggris.BingAdapter
import com.example.myedu.binggris.BingData

class KimiaAdapter(private val context: Context, private val kimiaList: List<KimiaData>) : RecyclerView.Adapter<KimiaAdapter.KimiaViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: KimiaData)
    }

    inner class KimiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val kimiaImage: ImageView = itemView.findViewById(R.id.img_kimia)

        init {
            itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(kimiaList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KimiaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_kimia, parent, false)
        return KimiaViewHolder(view)
    }

    override fun onBindViewHolder(holder: KimiaViewHolder, position: Int) {
        val data = kimiaList[position]
        holder.kimiaImage.setImageResource(data.gambar)
    }

    override fun getItemCount(): Int = kimiaList.size
}