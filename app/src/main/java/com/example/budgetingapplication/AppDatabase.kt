package com.example.budgetingapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Budget::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun budgetDao(): BudgetDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context, scope: CoroutineScope): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context, scope).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "budget_database")
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            instance?.let { database ->
                                scope.launch(Dispatchers.IO) {
                                    populateDatabase(database.budgetDao())
                                }
                            }
                        }
                    }
                )
                .build()
        }

        suspend fun populateDatabase(budgetDao: BudgetDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            budgetDao.deleteAll()

            val budget = listOf(Budget("Transportation"), Budget("Home food"), Budget("Junk food"), Budget("Entertainment"), Budget("Housing"), Budget("Gifts"))
            budgetDao.insertAll(budget)
        }
    }
}