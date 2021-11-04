package com.example.budgetingapplication.data

import androidx.room.*
import com.example.budgetingapplication.model.Budget
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(categories: List<Budget>)

    @Update
    suspend fun update(category: Budget)

    @Update
    suspend fun updateAll(category: List<Budget>)

    @Query("SELECT * FROM budget")
    fun readAll(): Flow<List<Budget>>
}