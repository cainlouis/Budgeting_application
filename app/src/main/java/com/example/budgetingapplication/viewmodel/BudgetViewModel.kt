package com.example.budgetingapplication.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.budgetingapplication.data.AppDatabase
import com.example.budgetingapplication.repository.BudgetRepository
import com.example.budgetingapplication.model.Budget
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

/**
 * @author Zacharie Makeen and Nael Louis
 * This contains all the function that interact with the dao that will later interact with the queries for the db
 */
class BudgetViewModel(application: Application) : AndroidViewModel(application) {

    //Instantiate the variable that will later be used
    val readAll: LiveData<List<Budget>>
    private val repository : BudgetRepository

    //Initialize the dao and the variables
    init {
        val budgetDao = AppDatabase.getDatabase(application).budgetDao()
        repository = BudgetRepository(budgetDao)
        readAll = repository.readAll.asLiveData()
    }

    //Used to insert into the db all the categories
    fun insertAll(budgets: List<Budget>) = viewModelScope.launch {
        repository.insertAll(budgets)
    }

    //Used in add spending, update the value of a category
    fun update(budget: Budget) = viewModelScope.launch {
        repository.update(budget)
    }

    //Used in clear all entries, update all categories
    fun updateAll(budgets: List<Budget>) = viewModelScope.launch {
        repository.updateAll(budgets)
    }
}