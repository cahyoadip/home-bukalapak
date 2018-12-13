package com.adi.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adi.home.R
import com.adi.home.model.Banner
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_promo.view.*

class PromoAdapter(val list: MutableList<Banner>, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_promo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Glide.with(context).load(list[position].image).into(holder.itemView.imageView)
        holder.itemView.textView8.text = list[position].description
        holder.itemView.textView9.text = "2 Hari lagi"
    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView)

}