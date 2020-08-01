package com.application.proxumer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.proxumer.R
import com.application.proxumer.model.Achievement
import kotlinx.android.synthetic.main.item_achievement.view.*

class AchievementAdapter(private var achievements: ArrayList<Achievement>): RecyclerView.Adapter<AdminGuideHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminGuideHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_achievement, parent, false)
        return AdminGuideHolder(view)
    }

    override fun getItemCount(): Int {
        return achievements.size
    }

    override fun onBindViewHolder(holder: AdminGuideHolder, position: Int) {
        holder.bind(achievements[position])
    }

    fun setAchievementList(list: ArrayList<Achievement>) {
        achievements = list
        notifyDataSetChanged()
    }
}

class AdminGuideHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(achievement: Achievement) {
        itemView.textViewAchievementName.text = achievement.name
    }
}