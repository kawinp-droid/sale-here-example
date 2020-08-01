package com.application.proxumer.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.proxumer.R
import com.application.proxumer.adapter.GoalAdapter
import com.application.proxumer.adapter.PromotionAdapter
import com.application.proxumer.model.Goal
import com.application.proxumer.model.Promotion
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.lang.reflect.Array.newInstance

class HomeFragment : Fragment() {

    private lateinit var mView: View

    private lateinit var goalAdapter: GoalAdapter
    private lateinit var goals: ArrayList<Goal>

    private lateinit var bestOfferList: ArrayList<Promotion>
    private lateinit var bestOfferAdapter: PromotionAdapter

    private lateinit var suggestList: ArrayList<Promotion>
    private lateinit var suggestAdapter: PromotionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.fragment_home, container, false)

        initUI()

        return mView
    }

    private fun initUI() {
        goals = arrayListOf()
        goalAdapter = GoalAdapter(goals)
        mView.recyclerViewAllGoal.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        mView.recyclerViewAllGoal.adapter = goalAdapter

        bestOfferList = arrayListOf()
        bestOfferAdapter = PromotionAdapter(bestOfferList)
        mView.recyclerViewBestOffer.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        mView.recyclerViewBestOffer.adapter = bestOfferAdapter

        suggestList = arrayListOf()
        suggestAdapter = PromotionAdapter(suggestList)
        mView.recyclerViewSuggestForYou.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
        mView.recyclerViewSuggestForYou.adapter = suggestAdapter

        mView.btnAddNewGoal.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.nav_host_fragment, AddGoalFragment())
                .addToBackStack(AddGoalFragment::class.simpleName)
                .commit()
        }

        mockupData()
    }

    private fun mockupData() {
        val goal1 = Goal(1, 20000, 16500, "ไปเที่ยวญี่ปุ่น", "travel", "Good", "09/13/2020")
        val goal2 = Goal(2, 6000, 500, "ซื้อกองทุนรวม", "invest", "Unhappy", "08/19/2020")
        val goal3 = Goal(3, 10000, 8700, "ไปทะเล", "travel", "Good", "08/17/2020")
        goals.add(goal3)
        goals.add(goal2)
        goals.add(goal1)
        goalAdapter.setGoalList(goals)
        mView.recyclerViewAllGoal.scrollToPosition(goals.size - 1)

        val bestOffer1 = Promotion(1, "best_1")
        val bestOffer2 = Promotion(2, "best_2")
        val bestOffer3 = Promotion(3, "best_3")
        bestOfferList.add(bestOffer1)
        bestOfferList.add(bestOffer2)
        bestOfferList.add(bestOffer3)
        bestOfferAdapter.setItemList(bestOfferList)
        mView.recyclerViewBestOffer.scrollToPosition(bestOfferList.size - 1)

        val suggest1 = Promotion(1, "suggest_1")
        val suggest2 = Promotion(2, "suggest_2")
        val suggest3 = Promotion(3, "suggest_3")
        suggestList.add(suggest1)
        suggestList.add(suggest2)
        suggestList.add(suggest3)
        suggestAdapter.setItemList(suggestList)
        mView.recyclerViewSuggestForYou.scrollToPosition(suggestList.size - 1)
    }
}