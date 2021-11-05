package com.example.budgetingapplication

import android.media.metrics.Event
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ClearAllEntriesActivity : MenuActivity() {
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clear_all_entries)

        button = findViewById(R.id.reset_btn)
        button.setOnClickListener() {
            createDialog()
        }
    }
    private fun createDialog() {
        val confirmationDialog = AlertDialog.Builder(this)
            .setTitle("Confirmation")
            .setMessage("Are you sure to reset all categories?")
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "All categories have been reset", Toast.LENGTH_SHORT).show() // _, _ are anonymous value parameter
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "All categories were not reset", Toast.LENGTH_SHORT).show()
            }.create()
        confirmationDialog.show() // show the dialog
    }
}