package com.application.proxumer.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.proxumer.R
import com.application.proxumer.model.Promotion
import kotlinx.android.synthetic.main.item_promotion.view.*
import java.util.*

class PromotionAdapter(private var promotions: ArrayList<Promotion>): RecyclerView.Adapter<PromotionHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_promotion, parent, false)
        return PromotionHolder(view)
    }

    override fun getItemCount(): Int {
        return promotions.size
    }

    override fun onBindViewHolder(holder: PromotionHolder, position: Int) {
        holder.bind(promotions[position])
    }

    fun setItemList(list: ArrayList<Promotion>) {
        promotions = list
        notifyDataSetChanged()
    }
}

class PromotionHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(promotion: Promotion) {
        val resourceID: Int = itemView.context.resources.getIdentifier(promotion.image, "drawable", itemView.context.packageName)
        Log.d("PromotionAdapter", "Resource ID: $resourceID")
        itemView.imageViewItemPromotion.setImageResource(resourceID)
    }
}