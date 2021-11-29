package com.example.budgetingapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetingapplication.R
import com.example.budgetingapplication.model.Budget

class BudgetListAdapter : ListAdapter<Budget, BudgetListAdapter.BudgetViewHolder>(BUDGETS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetViewHolder {
        return BudgetViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: BudgetViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.category, current.spending.toString())
    }

    class BudgetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val category: TextView = itemView.findViewById(R.id.category)
        private val spending: TextView = itemView.findViewById(R.id.spending)

        fun bind(categoryText: String?, spendingText: String?) {
            category.text = categoryText
            spending.text = spendingText
        }

        companion object {
            fun create(parent: ViewGroup): BudgetViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return BudgetViewHolder(view)
            }
        }
    }

    companion object {
        private val BUDGETS_COMPARATOR = object : DiffUtil.ItemCallback<Budget>() {
            override fun areItemsTheSame(oldItem: Budget, newItem: Budget): Boolean {
                return oldItem.category === newItem.category
            }

            override fun areContentsTheSame(oldItem: Budget, newItem: Budget): Boolean {
                return oldItem == newItem
            }
        }
    }
}