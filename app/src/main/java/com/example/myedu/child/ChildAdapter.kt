package com.example.myedu.child

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.R

class ChildAdapter(private val childList: List<ChildData>) : RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ChildData)
    }

    class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val childImage: ImageView = itemView.findViewById(R.id.img_child)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_child_mapel, parent, false)
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val data = childList[position]
        holder.childImage.setImageResource(data.gambar)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(childList[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = childList.size
}
