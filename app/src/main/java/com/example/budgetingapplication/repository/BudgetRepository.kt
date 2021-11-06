package com.example.budgetingapplication.repository

import com.example.budgetingapplication.data.BudgetDao
import com.example.budgetingapplication.model.Budget
import kotlinx.coroutines.flow.Flow

/**
 * @author Zacharie Makeen and Nael Louis
 * interact with the dao that directly use the queries to the db
 */
class BudgetRepository(private val budgetDao: BudgetDao) {
    //get the list for all categories
    val readAll: Flow<List<Budget>> = budgetDao.readAll()

    //call the query insert all with the list as input
    suspend fun insertAll(budgets: List<Budget>) {
        budgetDao.insertAll(budgets)
    }

    //call the query that update a category with a singular object
    suspend fun update(budget: Budget) {
        budgetDao.update(budget)
    }

    //call the query that update all category with the list as input
    suspend fun updateAll(budgets: List<Budget>) {
        budgetDao.updateAll(budgets)
    }
}