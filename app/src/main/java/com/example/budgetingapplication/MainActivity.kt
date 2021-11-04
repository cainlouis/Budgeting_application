package com.example.budgetingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider

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