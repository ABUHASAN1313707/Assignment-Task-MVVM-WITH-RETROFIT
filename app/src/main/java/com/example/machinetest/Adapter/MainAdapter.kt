package com.example.machinetest.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.machinetest.DetailsPage
import com.example.machinetest.Model.Life
import com.example.machinetest.databinding.AdapterLifeBinding
import com.squareup.picasso.Picasso


class MainAdapter() : RecyclerView.Adapter<MainViewHolder>() {
    var lifes = mutableListOf<Life>()
    fun setLifeList(lifes: List<Life>) {
        this.lifes = lifes.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterLifeBinding.inflate(inflater,parent,false)
        return  MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val life = lifes[position]
        holder.binding.name.text = life.title
        Picasso.with(holder.itemView.context).load(life.thumbnailUrl).into(holder.binding.imageview)

        holder.binding.imageview.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsPage::class.java);
            intent.putExtra("title", life.title)
            intent.putExtra("thumbnailUrl", life.thumbnailUrl)
            holder.itemView.context.startActivity(intent)

        }
    }
    override fun getItemCount(): Int {
        return lifes.size
    }
}

class MainViewHolder (val binding: AdapterLifeBinding) : RecyclerView.ViewHolder(binding.root) {
}
