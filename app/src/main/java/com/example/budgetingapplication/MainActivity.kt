package com.example.budgetingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.budgeting_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.about -> {
//                newGame()
                true
            }
            R.id.add_spending -> {
//                showHelp()
                true
            }
            R.id.clear_all_entries -> {
//                showHelp()
                true
            }
            R.id.display_current_status -> {
//                showHelp()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}