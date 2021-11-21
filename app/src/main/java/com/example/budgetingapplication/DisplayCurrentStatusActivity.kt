package com.example.budgetingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetingapplication.adapter.BudgetListAdapter
import com.example.budgetingapplication.viewmodel.BudgetViewModel

/**
 * @author Kirill Parhomenco
 * this activity display the value of each category fetched from the database
 */
class DisplayCurrentStatusActivity : MenuActivity() {

    private lateinit var budgetViewModel: BudgetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_current_status)

        //get the view model that will be used to interact with db
        budgetViewModel = ViewModelProvider(this).get(BudgetViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = BudgetListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        budgetViewModel.readAll.observe(this, Observer { budgets ->
            adapter.submitList(budgets)
        })
    }
}