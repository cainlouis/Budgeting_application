package com.example.budgetingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

const val EXTRA_MESSAGE = "com.example.budgetingapplication.MESSAGE"

open class MenuActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.budgeting_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.main -> {
                showHome()
                true
            }
            R.id.about -> {
                showAbout()
                true
            }
            R.id.add_spending -> {
                showAddSpending()
                true
            }
            R.id.clear_all_entries -> {
                showClearAllEntries()
                true
            }
            R.id.display_current_status -> {
                showDisplayCurrentStatus()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showHome() {
//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
//        val message = editText.text.toString()
        val message = "HelloWorld"
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)

    }

    private fun showAbout() {
//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
//        val message = editText.text.toString()
        val message = "HelloWorld"
        val intent = Intent(this, AboutActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)

    }

    private fun showAddSpending() {
//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
//        val message = editText.text.toString()
        val message = "HelloWorld"
        val intent = Intent(this, AddSpendingActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)

    }

    private fun showClearAllEntries() {
//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
//        val message = editText.text.toString()
        val message = "HelloWorld"
        val intent = Intent(this, ClearAllEntriesActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)

    }

    private fun showDisplayCurrentStatus() {
//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
//        val message = editText.text.toString()
        // generic way to start an activity, put extra also can be used to pass data around if needed.
        val message = "HelloWorld"
        val intent = Intent(this, DisplayCurrentStatusActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)

    }
}