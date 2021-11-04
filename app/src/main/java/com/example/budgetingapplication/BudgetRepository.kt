package com.example.budgetingapplication

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class BudgetRepository(private val budgetDao: BudgetDao) {
    val allCategories: Flow<List<Budget>> = budgetDao.readAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertAll(categories: List<Budget>) {
        budgetDao.insertAll(categories)
    }
}