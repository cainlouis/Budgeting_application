package com.example.budgetingapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetingapplication.model.Budget

class DisplayCurrentStatusAdapter: RecyclerView.Adapter<DisplayCurrentStatusAdapter.MyViewHolder>() {

    private var budgetList = emptyList<Budget>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val category: TextView = itemView.findViewById(R.id.category)
        private val spending: TextView = itemView.findViewById(R.id.spending)

        fun bind(categoryText: String?, spendingText: String?) {
            category.text = categoryText
            spending.text = spendingText
        }

        companion object {
            fun create(parent: ViewGroup): MyViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return MyViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = budgetList[position]
        holder.bind(currentItem.category, currentItem.spending.toString())
    }

    override fun getItemCount(): Int {
        return budgetList.size
    }

    fun setData(budget: List<Budget>) {
        this.budgetList = budget
        notifyDataSetChanged()
    }
}