package com.example.budgetingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

open class MenuActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.budgeting_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.about -> {
                newAbout()
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

    private fun newAbout() {
//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
//        val message = editText.text.toString()
        val message = "HelloWorld"
        val intent = Intent(this, AboutActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)

    }
}