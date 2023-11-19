package com.tugasMobile.listmahasiswa

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter (private val listMahasiswa:ArrayList<Mahasiswa>):RecyclerView.Adapter<ListAdapter.ListViewHolder>(){
    class ListViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val imgPhoto: ImageView = view.findViewById(R.id.img_item_photo)
        val tvnama: TextView = view.findViewById(R.id.textNamaMahasiswa)
        val tvnim: TextView = view.findViewById(R.id.textNIM)
        val tvprodi: TextView = view.findViewById(R.id.textProgramStudi)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int =listMahasiswa.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo,nama,nim,prodi)=listMahasiswa[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvnama.text ="Nama  :$nama"
        holder.tvnim.text  ="Nim       :$nim"
        holder.tvprodi.text="Prodi     :$prodi"
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMahasiswa::class.java)
            intentDetail.putExtra("data", listMahasiswa[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}