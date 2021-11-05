package com.example.budgetingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.budgetingapplication.model.Budget
import com.example.budgetingapplication.viewmodel.BudgetViewModel

class AddSpendingActivity : MenuActivity() {

    private lateinit var budgetViewModel: BudgetViewModel
    lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_spending)

        budgetViewModel = ViewModelProvider(this).get(BudgetViewModel::class.java)

        spinner = findViewById(R.id.categorySpinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.categories_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        lateinit var  category: String
        lateinit var  categoryIndex: String

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                category = resources.getStringArray(R.array.categories_array)[p2].toString()
                categoryIndex = p2.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }


        val budgets1 = budgetViewModel.readAll
        budgets1.observe(this, Observer { budgets ->
            //
        })


        val updateButton = findViewById<Button>(R.id.updateButton)

        updateButton.setOnClickListener {
            val moneySpent = findViewById<EditText>(R.id.moneySpentInput).text.toString().toDouble()
            val moneySpentCleaned = String.format(resources.getString(R.string.format), moneySpent).toDouble()

            val budgets = budgetViewModel.readAll
            var currentMoneySpent: Double = 0.0
            budgets.observe(this, Observer { budgets2 ->
                currentMoneySpent = budgets2[categoryIndex.toInt()].spending
            })

            val budget = Budget(category, moneySpentCleaned + currentMoneySpent)
            budgetViewModel.update(budget)


           Toast.makeText(this, resources.getString(R.string.onAddSpending), Toast.LENGTH_LONG).show()
        }
    }
}