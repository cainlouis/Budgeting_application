package com.example.budgetingapplication


import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import androidx.lifecycle.ViewModelProvider
import com.example.budgetingapplication.model.Budget
import com.example.budgetingapplication.viewmodel.BudgetViewModel

class ClearAllEntriesActivity : MenuActivity() {
    private lateinit var button: Button
    private lateinit var budgetViewModel: BudgetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clear_all_entries)

        button = findViewById(R.id.reset_btn)
        budgetViewModel = ViewModelProvider(this).get(BudgetViewModel::class.java)

        button.setOnClickListener {
            createDialog()
        }
    }

    /**
     * @author Alec Phan
     *
     * This method will create a confirmation dialog and asks the users' confirmation
     */
    private fun createDialog() {
        val confirmationDialog = AlertDialog.Builder(this)
            .setTitle("Confirmation")
            .setMessage("Are you sure to reset all categories?")
            .setPositiveButton(R.string.yes) { _, _ ->
                resetData()
                Toast.makeText(this, "All categories have been reset", Toast.LENGTH_SHORT).show() // _, _ are anonymous value parameter
            }
            .setNegativeButton(R.string.no) { _, _ ->
                Toast.makeText(this, "All categories were not reset", Toast.LENGTH_SHORT).show()
            }.create()
        confirmationDialog.show() // show the dialog
    }

    /**
     * @author Alec Phan
     *
     * This method will set all the categories back to 0
     */
    private fun resetData() {
        val clearBudgetList = listOf(
            Budget("Transportation", 0.0),
            Budget("Home food", 0.0),
            Budget("Junk food", 0.0),
            Budget("Entertainment", 0.0),
            Budget("Housing", 0.0),
            Budget("Gifts", 0.0))

        budgetViewModel.updateAll(clearBudgetList)
    }
}