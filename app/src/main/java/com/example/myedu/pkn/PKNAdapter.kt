package com.example.myedu.pkn

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.R
import com.example.myedu.binggris.BingAdapter
import com.example.myedu.binggris.BingData

class PKNAdapter(private val context: Context, private val pknList: List<PKNData>) : RecyclerView.Adapter<PKNAdapter.PKNViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: PKNData)
    }

    inner class PKNViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pknImage: ImageView = itemView.findViewById(R.id.img_pkn)

        init {
            itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(pknList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PKNViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_pkn, parent, false)
        return PKNViewHolder(view)
    }

    override fun onBindViewHolder(holder: PKNViewHolder, position: Int) {
        val data = pknList[position]
        holder.pknImage.setImageResource(data.gambar)
    }

    override fun getItemCount(): Int = pknList.size
}
