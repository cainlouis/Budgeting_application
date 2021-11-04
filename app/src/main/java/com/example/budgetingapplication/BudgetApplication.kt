package com.example.budgetingapplication

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BudgetApplication : Application() {
//    val applicationScope = CoroutineScope(SupervisorJob())
//    val database by lazy { AppDatabase.getInstance(this, applicationScope) }
//    val repository by lazy { BudgetRepository(database.budgetDao()) }
}