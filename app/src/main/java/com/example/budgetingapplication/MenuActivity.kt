package com.example.budgetingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

const val EXTRA_MESSAGE = "com.example.budgetingapplication.MESSAGE"

/**
 * @author Zacharie Makeen
 * this class creates the option menu and allows the user to change activity accordingly
 */
open class MenuActivity : AppCompatActivity() {
    /**
     * receive the menu and 'inflates' it then return true once it's done
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        //get the menu object from resources
        inflater.inflate(R.menu.budgeting_menu, menu)
        return true
    }

    /**
     * Switch case which call a function linked to any activity that is selected and returns true
     */
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

    /**
     * set the intent to the home activity and start it
     */
    private fun showHome() {
        val message = "HelloWorld"
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    /**
     * set the intent to the about activity and start it
     */
    private fun showAbout() {
        val message = "HelloWorld"
        val intent = Intent(this, AboutActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    /**
     * set the intent to the add-Spending activity and start it
     */
    private fun showAddSpending() {
        val message = "HelloWorld"
        val intent = Intent(this, AddSpendingActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    /**
     * set the intent to the clear-all-entries activity and start it
     */
    private fun showClearAllEntries() {
        val message = "HelloWorld"
        val intent = Intent(this, ClearAllEntriesActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    /**
     * set the intent to the display-current-status activity and start it
     */
    private fun showDisplayCurrentStatus() {
        val message = "HelloWorld"
        val intent = Intent(this, DisplayCurrentStatusActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}