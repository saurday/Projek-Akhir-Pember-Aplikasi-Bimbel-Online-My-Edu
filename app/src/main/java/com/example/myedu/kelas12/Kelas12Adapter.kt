package com.example.myedu.kelas12

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myedu.R

class Kelas12Adapter(private val kelas12List: List<Kelas12Data>) : RecyclerView.Adapter<Kelas12Adapter.Kelas12ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Kelas12Data)
    }

    class Kelas12ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mapelKls12: ImageView = itemView.findViewById(R.id.img_list_mapel)
        val mapelNama: TextView = itemView.findViewById(R.id.tv_mapel_nama)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Kelas12ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_mapel, parent, false)
        return Kelas12ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Kelas12ViewHolder, position: Int) {
        val data = kelas12List[position]
        holder.mapelKls12.setImageResource(data.gambar)
        holder.mapelNama.text = data.nama

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(kelas12List[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = kelas12List.size
}
