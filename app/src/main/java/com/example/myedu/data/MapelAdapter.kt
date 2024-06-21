package com.example.myedu

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myedu.data.Mapel
import com.example.myedu.DetailMapel

class MapelAdapter(private val context: Context, private val mapelList: List<Mapel>) :
    RecyclerView.Adapter<MapelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_mapel, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mapel = mapelList[position]

        Glide.with(context)
            .load(mapel.gambar)
            .into(holder.imgMapel)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailMapel::class.java).apply {
                putExtra("mapel", mapel.mapel)
                putExtra("deskripsi", mapel.deskripsi)
                putExtra("gambar", mapel.gambar)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mapelList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMapel: ImageView = itemView.findViewById(R.id.img_mapel)
    }
}
