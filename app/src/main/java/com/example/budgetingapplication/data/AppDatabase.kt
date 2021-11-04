package com.example.budgetingapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.budgetingapplication.model.Budget

@Database(entities = [Budget::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun budgetDao(): BudgetDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "budgeting_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

//    companion object {
//
//        // For Singleton instantiation
//        @Volatile
//        private var INSTANCE: AppDatabase? = null

//        fun getInstance(context: Context, scope: CoroutineScope): AppDatabase {
//            return instance ?: synchronized(this) {
//                instance ?: buildDatabase(context, scope).also { instance = it }
//            }
//        }
//
//        private fun buildDatabase(context: Context, scope: CoroutineScope): AppDatabase {
//            return Room.databaseBuilder(context, AppDatabase::class.java, "budget_database")
//                .addCallback(
//                    object : RoomDatabase.Callback() {
//                        override fun onCreate(db: SupportSQLiteDatabase) {
//                            super.onCreate(db)
//                            instance?.let { database ->
//                                scope.launch(Dispatchers.IO) {
//                                    populateDatabase(database.budgetDao())
//                                }
//                            }
//                        }
//                    }
//                )
//                .build()
//        }

//        @DelicateCoroutinesApi
//        fun getInstance(context: Context, ): AppDatabase {
//            if (INSTANCE == null) {
//                synchronized(AppDatabase::class.java) {
//                    if (INSTANCE == null) {
//                        INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "budgeting_database")
//                            .addCallback(object : Callback() {
//                                override fun onCreate(db: SupportSQLiteDatabase) {
//                                    super.onCreate(db)
//                                    Log.d("AppDatabase", "populating with data...")
//                                    db.execSQL("CREATE TABLE budget(category TEXT PRIMARY KEY, spending DECIMAL)")
//                                    val categories = listOf(
//                                        Budget("Transportation"),
//                                        Budget("Home food"),
//                                        Budget("Junk food"),
//                                        Budget("Entertainment"),
//                                        Budget("Housing"),
//                                        Budget("Gifts")
//                                    )
//                                    for (category in categories) {
//                                        db.execSQL("INSERT INTO budget(category, spending) VALUES (?,?)")
//                                    }
//                                }
//                            }).build()
//                    }
//                }
//            }
//
//            return INSTANCE!!
//        }

//        private class AppDatabaseCallback(
//            private val scope: CoroutineScope
//        ) : RoomDatabase.Callback() {
//            /**
//             * Override the onCreate method to populate the database.
//             */
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                // If you want to keep the data through app restarts,
//                // comment out the following line.
//                INSTANCE?.let { database ->
//                    scope.launch(Dispatchers.IO) {
//                        populateDatabase(database.budgetDao())
//                    }
//                }
//            }
//        }
//        suspend fun populateDatabase(database: AppDatabase) {
//            database?.let { db ->
//                withContext(Dispatchers.IO) {
//                    val budgetDao: BudgetDao = db.budgetDao()
//
//                    budgetDao.deleteAll()
//
//                    val categories = listOf(
//                        Budget("Transportation"),
//                        Budget("Home food"),
//                        Budget("Junk food"),
//                        Budget("Entertainment"),
//                        Budget("Housing"),
//                        Budget("Gifts")
//                    )
//                    budgetDao.insertAll(categories)
//                }
//            }
//        }
//    }
}