package com.example.budgetingapplication.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.budgetingapplication.data.AppDatabase
import com.example.budgetingapplication.repository.BudgetRepository
import com.example.budgetingapplication.model.Budget
import kotlinx.coroutines.launch

class BudgetViewModel(application: Application) : AndroidViewModel(application) {

    val loadAll: LiveData<List<Budget>>
    private val repository : BudgetRepository

    init {
        val budgetDao = AppDatabase.getDatabase(application).budgetDao()
        repository = BudgetRepository(budgetDao)
        loadAll = repository.readAll.asLiveData()
    }

    fun insertAll(budgets: List<Budget>) = viewModelScope.launch {
        repository.insertAll(budgets)
    }
}