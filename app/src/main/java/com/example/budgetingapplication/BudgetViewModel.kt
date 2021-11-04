package com.example.budgetingapplication

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


//class BudgetViewModel(private val repository: BudgetRepository) : ViewModel() {
class BudgetViewModel(application: Application) : AndroidViewModel(application) {

//    val allBudgets: LiveData<List<Budget>> = repository.allBudgets.asLiveData()

//    private val loadAll: LiveData<List<Budget>>
//    private val repository : BudgetRepository
//
//    init {
//        val spendingPerCategoryDao = AppDatabase.getInstance(application).budgetDao()
//        repository = BudgetRepository(spendingPerCategoryDao)
//        loadAll = repository.allBudgets.asLiveData()
//    }

    private val budgetDao: BudgetDao = AppDatabase.getInstance(application).budgetDao()
    private val allBudgets: LiveData<List<Budget>>

    init {
        allBudgets = budgetDao.readAll().asLiveData()
    }

//    fun insertAll(budget: List<Budget>) = viewModelScope.launch {
//        repository.insertAll(budget)
//    }
}

//class BudgetViewModelFactory(private val repository: BudgetRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(BudgetViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return BudgetViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}