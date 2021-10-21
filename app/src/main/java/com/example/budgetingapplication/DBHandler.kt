package com.example.budgetingapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    //Creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        //Sqlite query, where column names along with their data types is given
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " TEXT PRIMARY KEY, " +
                SPENT_COL + " TEXT," + ")")

        //Call sqlite method for executing our query
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //This method is to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addCategory(nameCategory: String, amountSpent: Double) {
        //Create a content values variable
        val values = ContentValues()

        //Insert our values in the form of key-value pair
        values.put(ID_COL, nameCategory)
        values.put(SPENT_COL, amountSpent)

        //Create a writable variable of our database as we want to insert value in our database
        val db = this.writableDatabase

        //All values are inserted into database
        db.insert(TABLE_NAME, null, values)

        //Close our database
        db.close()
    }

    fun updateCategory(nameCategory: String, amountSpent: Double) {
        //Create a content values variable
        val values = ContentValues()

        //Insert our value
        values.put(SPENT_COL, amountSpent)

        //Create a writable variable of our database as we want to insert value in our database
        val db = this.writableDatabase
        //Create the array for the update
        val whereArgs = arrayOf(nameCategory)
        
        db.update(TABLE_NAME, values, "id" + " = ?", whereArgs)
    }

    fun getSpent(): Cursor? {

        //Create a readable variable of our database to read value from it
        val db = this.readableDatabase

        //Returns a cursor to read data from the database
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    //Define variables for our database
    companion object{
        //Variable for database name
        private const val DATABASE_NAME = "BUDGETING_APP"

        //Variable for database version
        private const val DATABASE_VERSION = 1

        //Variable for table name
        const val TABLE_NAME = "Categories"

        //Variable for id column which is the category here
        const val ID_COL = "Category"

        //Variable for the amount column
        const val SPENT_COL = "Spent"
    }
}