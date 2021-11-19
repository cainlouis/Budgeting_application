package com.example.budgetingapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetingapplication.model.Budget

class DisplayCurrentStatusAdapter: RecyclerView.Adapter<DisplayCurrentStatusAdapter.MyViewHolder>() {

    private var budgetList = emptyList<Budget>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        fun bind(text: String?) {
//            wordItemView.text = text
//        }

        companion object {
            fun create(parent: ViewGroup): MyViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_display_current_status, parent, false)
                return MyViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = budgetList[position]
        holder.itemView.
    }

    override fun getItemCount(): Int {
        return budgetList.size
    }
}