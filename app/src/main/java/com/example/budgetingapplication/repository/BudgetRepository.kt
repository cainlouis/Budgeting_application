package com.example.budgetingapplication.repository

import com.example.budgetingapplication.data.BudgetDao
import com.example.budgetingapplication.model.Budget
import kotlinx.coroutines.flow.Flow

class BudgetRepository(private val budgetDao: BudgetDao) {
    val readAll: Flow<List<Budget>> = budgetDao.readAll()

    val readCategories: Flow<List<String>> = budgetDao.readCategories()

    suspend fun update(budget: Budget) {
        budgetDao.update(budget)
    }

    suspend fun insertAll(budgets: List<Budget>) {
        budgetDao.insertAll(budgets)
    }
}