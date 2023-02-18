package com.example.cleaner.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cleaner.R
import com.example.cleaner.model.Recommend

class RecommendedAdapter(val context: Context,val rList:ArrayList<Recommend>):RecyclerView.Adapter<RecommendedAdapter.RecommendedViewHolder>() {
    class RecommendedViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val image=itemView.findViewById<ImageView>(R.id.imageView1)
        val ofer=itemView.findViewById<TextView>(R.id.offer)
        val txt=itemView.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context).inflate(R.layout.recommended_list,parent,false)
        return RecommendedViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        val i=rList[position]
        Glide.with(context)
            .load(i.image)
            .into(holder.image)
        holder.ofer.text=i.offer
        holder.txt.text=i.title
    }

    override fun getItemCount(): Int {
        return rList.size
    }
}