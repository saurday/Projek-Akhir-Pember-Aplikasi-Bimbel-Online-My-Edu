package com.example.myedu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterGrid (private val mapelList: List<MapelData>) : RecyclerView.Adapter<AdapterGrid.MapelViewHolder>() {
    // Deklarasi variabel untuk callback ketika item diklik
    private lateinit var onItemClickCallback: OnItemClickCallback

    // Fungsi untuk mengatur callback ketika item diklik
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    // Interface untuk callback ketika item diklik
    interface OnItemClickCallback {
        fun onItemClicked(data: MapelData)
    }

    // Kelas ViewHolder untuk menyimpan referensi view yang digunakan dalam RecyclerView
    class MapelViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mapelName: TextView = itemView.findViewById(R.id.namaPelajaran2)
        val mapelImage: ImageView = itemView.findViewById(R.id.gambarPelajaran2)
        val txt_see: TextView = itemView.findViewById(R.id.txt_see2)
        val see: ImageView = itemView.findViewById(R.id.see2)
        val txt_download: TextView = itemView.findViewById(R.id.txt_download2)
        val download: ImageView = itemView.findViewById(R.id.download2)
    }

    // Fungsi untuk membuat ViewHolder (Melakukan setting untuk XML yang akan kita gunakan untuk menampilkan data)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MapelViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.rv_grid, parent, false)
        return MapelViewHolder(view)
    }

    // Fungsi untuk mengikat data dengan ViewHolder (memasukkan data yang kita miliki ke dalam XML ViewHolder)
    override fun onBindViewHolder(holder: MapelViewHolder, position: Int) {
        val data = mapelList[position]

        holder.mapelName.text = data.name
        holder.mapelImage.setImageResource(data.image)
        holder.txt_see.text = data.txt_see
        holder.see.setImageResource(data.see)
        holder.txt_download.text = data.txt_download
        holder.download.setImageResource(data.download)

        // Mengatur aksi ketika item diklik
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(mapelList[holder.adapterPosition]) }
    }

    // Fungsi untuk mendapatkan jumlah item
    override fun getItemCount(): Int = mapelList.size

    // Fungsi untuk memendekkan teks jika melebihi panjang maksimum
    private fun String.shorten(maxLength: Int): String {
        return if (this.length <= maxLength) this else "${this.substring(0, maxLength)}..."
    }
}