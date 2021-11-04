package com.example.budgetingapplication.repository

import com.example.budgetingapplication.data.BudgetDao
import com.example.budgetingapplication.model.Budget
import kotlinx.coroutines.flow.Flow

class BudgetRepository(private val budgetDao: BudgetDao) {
    val readAll: Flow<List<Budget>> = budgetDao.readAll()

    suspend fun insertAll(budgets: List<Budget>) {
        budgetDao.insertAll(budgets)
    }
}