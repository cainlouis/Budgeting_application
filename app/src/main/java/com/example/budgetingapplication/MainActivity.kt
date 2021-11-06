package com.example.budgetingapplication

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.budgetingapplication.model.Budget
import com.example.budgetingapplication.viewmodel.BudgetViewModel

class MainActivity : MenuActivity() {

//    private val budgetViewModel: BudgetViewModel by viewModels {
//        BudgetViewModelFactory((application as BudgetApplication).repository)
//    }

    private lateinit var budgetViewModel: BudgetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        budgetViewModel = ViewModelProvider(this).get(BudgetViewModel::class.java)
        val spendingPerCategory = listOf(Budget("Books"), Budget("Magazines"))
        budgetViewModel.insertAll(spendingPerCategory)
    }
}