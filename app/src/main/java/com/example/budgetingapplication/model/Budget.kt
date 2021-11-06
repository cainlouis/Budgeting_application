package com.example.budgetingapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Zacharie Makeen and Nael Louis
 * This is the entity for the db
 */
@Entity(tableName = "budget")
data class Budget(
    @PrimaryKey @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "spending") val spending: Double = 0.0
)
