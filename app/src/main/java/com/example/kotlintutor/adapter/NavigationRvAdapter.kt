package com.example.kotlintutor.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintutor.R
import com.example.kotlintutor.model.NavigationItemModel

class NavigationRvAdapter (private var items: ArrayList<NavigationItemModel>, private var currentPos: Int) :RecyclerView.Adapter<NavigationRvAdapter.NavigationItemViewHolder>(){
    private lateinit var context: Context

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val navigationTitle: TextView = itemView.findViewById(R.id.navigation_title)
        val navigationIcon: ImageView = itemView.findViewById(R.id.navigation_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem = LayoutInflater.from(parent.context).inflate(R.layout.row_nav_drawer, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount() : Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        if (position == currentPos) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.kodecamp_blue_100))
            holder.navigationTitle.setTextColor(Color.WHITE)
            holder.navigationIcon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
        }else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            holder.navigationTitle.setTextColor(ContextCompat.getColor(context, R.color.kodecamp_blue_100))
            holder.navigationIcon.setColorFilter(ContextCompat.getColor(context, R.color.kodecamp_blue_100), PorterDuff.Mode.SRC_ATOP)
        }
        holder.navigationTitle.text = items[position].title
    }
}