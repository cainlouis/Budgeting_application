package com.example.budgetingapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.budgetingapplication.model.Budget

/**
 * @author Zacharie Makeen and Nael Louis
 * Create the instance for the db
 */
@Database(entities = [Budget::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    //get the dao
    abstract fun budgetDao(): BudgetDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var INSTANCE: AppDatabase? = null
        //if database instance null create a new one and return instance
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "budgeting_database"
                )
//                    .fallbackToDestructiveMigration()
                    .createFromAsset("database/budgeting.db")
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}