package com.example.budgetingapplication.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.budgetingapplication.data.AppDatabase
import com.example.budgetingapplication.repository.BudgetRepository
import com.example.budgetingapplication.model.Budget
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class BudgetViewModel(application: Application) : AndroidViewModel(application) {

    val readAll: LiveData<List<Budget>>
    private val repository : BudgetRepository

    init {
        val budgetDao = AppDatabase.getDatabase(application).budgetDao()
        repository = BudgetRepository(budgetDao)
        readAll = repository.readAll.asLiveData()
    }

    fun insertAll(budgets: List<Budget>) = viewModelScope.launch {
        repository.insertAll(budgets)
    }

    fun update(budget: Budget) = viewModelScope.launch {
        repository.update(budget)
    }

    fun updateAll(budgets: List<Budget>) = viewModelScope.launch {
        repository.updateAll(budgets)
    }
}