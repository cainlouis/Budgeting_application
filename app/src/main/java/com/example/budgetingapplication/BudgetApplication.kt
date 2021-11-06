package com.example.budgetingapplication

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * @author Zacharie Makeen
 * This was supposed to be the application but was unneeded for phase 1
 * will stay in case we need it for later phases
 */
class BudgetApplication : Application() {
//    val applicationScope = CoroutineScope(SupervisorJob())
//    val database by lazy { AppDatabase.getInstance(this, applicationScope) }
//    val repository by lazy { BudgetRepository(database.budgetDao()) }
}