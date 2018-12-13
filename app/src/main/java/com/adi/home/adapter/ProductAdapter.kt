package com.adi.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adi.home.R
import com.adi.home.model.Product
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_home.view.*
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

class ProductAdapter(var list: List<Product>, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_home, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.txt0.text = list[position].name
        Glide.with(context).load(list[position].images[0]).into(holder.itemView.ic_product)
        holder.itemView.txt0.text = list[position].name
        holder.itemView.txt3.text = convertMoney(list[position].price)
        holder.itemView.ratingBar2.rating = list[position].rating.average_rate.toFloat()
        holder.itemView.ratingBar2.rating = list[position].rating.average_rate.toFloat()
        holder.itemView.tv_rating_num.text = "(${list[position].rating.user_count})"
    }

    private fun convertMoney (price : Int) : String {
        val kurs = DecimalFormat.getCurrencyInstance() as DecimalFormat
        val format = DecimalFormatSymbols()

        format.currencySymbol = "Rp "
        format.monetaryDecimalSeparator = ','
        format.groupingSeparator = '.'

        kurs.decimalFormatSymbols = format
        return kurs.format(price)
    }

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView)
}