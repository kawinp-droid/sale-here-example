package com.application.proxumer.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.application.proxumer.R
import com.application.proxumer.model.Goal
import kotlinx.android.synthetic.main.item_goal.view.*
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class GoalAdapter(private var goals: ArrayList<Goal>): RecyclerView.Adapter<GoalHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_goal, parent, false)
        return GoalHolder(view)
    }

    override fun getItemCount(): Int {
        return goals.size
    }

    override fun onBindViewHolder(holder: GoalHolder, position: Int) {
        holder.bind(goals[position])
    }

    fun setGoalList(list: ArrayList<Goal>) {
        goals = list
        notifyDataSetChanged()
    }
}

class GoalHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


    fun bind(goal: Goal) {
        if (goal.type == "travel") {
            itemView.imageViewItemGoal.setImageResource(R.drawable.ic_travel)
        } else {
            itemView.imageViewItemGoal.setImageResource(R.drawable.ic_growth)
        }

        val amountStr = "${formatNumber(goal.amount)} THB"
        itemView.textViewItemGoalAmount.text = amountStr

        val goalStr = "${formatNumber(goal.goal)} THB"
        itemView.textViewItemGoal.text = goalStr

        val progress: Double = (goal.amount.toDouble() / goal.goal.toDouble()) * 100
        Log.d("GoalAdapter", "Goal Progress: $progress")
        itemView.progressBarItemGoal.progress = progress.toInt()

        itemView.textViewItemGoalDetail.text = goal.detail
        itemView.textViewItemGoalStatus.text = goal.status
        if (goal.status == "Good") {
            itemView.layoutCardViewItem.background = ContextCompat.getDrawable(itemView.context, R.drawable.card_border_green)
            itemView.textViewItemGoalStatus.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorGood))
        } else {
            itemView.layoutCardViewItem.background = ContextCompat.getDrawable(itemView.context, R.drawable.card_border_red)
            itemView.textViewItemGoalStatus.setTextColor(ContextCompat.getColor(itemView.context, R.color.colorAccent))
        }

        itemView.textViewItemGoalDate.text = getDaysLeft(goal.date)
    }

    @SuppressLint("SimpleDateFormat")
    private fun getDaysLeft(date: String): String {
        val currentCalendar: Calendar = Calendar.getInstance()
        val day: Calendar = Calendar.getInstance()
        day.time = SimpleDateFormat("MM/dd/yyyy").parse(date)!!

        val diff = ((day.timeInMillis - currentCalendar.timeInMillis) / 1000 / 60 / 60 / 24).toInt()

        return "$diff days left"
    }

    private fun formatNumber(amount: Int): String {
        val formatter: NumberFormat = DecimalFormat("#,###")
        return formatter.format(amount)
    }
}