package com.application.proxumer.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.application.proxumer.R
import com.application.proxumer.adapter.AchievementAdapter
import com.application.proxumer.model.Achievement
import kotlinx.android.synthetic.main.fragment_achievement.view.*

class AchievementFragment : Fragment() {

    private lateinit var mView: View
    private lateinit var adapter: AchievementAdapter
    private lateinit var achievements: ArrayList<Achievement>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_achievement, container, false)

        initUI()

        return mView
    }

    private fun initUI() {
        achievements = arrayListOf()
        adapter = AchievementAdapter(achievements)
        mView.recyclerViewAchievement.layoutManager = GridLayoutManager(context, 3)
        mView.recyclerViewAchievement.adapter = adapter

        mockupAchievement()
    }

    private fun mockupAchievement() {
        for (i in 1 until 10) {
            val achievement = Achievement(i, "Achievement")
            achievements.add(achievement)
        }
        adapter.setAchievementList(achievements)
    }
}