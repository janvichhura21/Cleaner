package com.example.cleaner.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cleaner.R
import com.example.cleaner.model.Category
import de.hdodenhof.circleimageview.CircleImageView

class HomeAdapter(val context: Context,val arrayList: ArrayList<Category>):RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    class HomeViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val image=itemView.findViewById<CircleImageView>(R.id.imageView)
        val txt=itemView.findViewById<TextView>(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
       val layoutInflater=LayoutInflater.from(parent.context).inflate(R.layout.category_list,parent,false)
        return HomeViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val i=arrayList[position]
        holder.txt.text=i.title
        Glide.with(context)
            .load(i.image)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}