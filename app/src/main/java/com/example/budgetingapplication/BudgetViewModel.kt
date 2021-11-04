package com.example.budgetingapplication

import androidx.lifecycle.*
import kotlinx.coroutines.launch


class BudgetViewModel(private val repository: BudgetRepository) : ViewModel() {

    val allBudgets: LiveData<List<Budget>> = repository.allBudgets.asLiveData()

    fun insertAll(budget: List<Budget>) = viewModelScope.launch {
        repository.insertAll(budget)
    }
}

class BudgetViewModelFactory(private val repository: BudgetRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BudgetViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BudgetViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}