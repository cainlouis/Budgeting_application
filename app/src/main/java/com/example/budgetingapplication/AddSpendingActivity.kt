package com.example.budgetingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.budgetingapplication.model.Budget
import com.example.budgetingapplication.viewmodel.BudgetViewModel

/**
 * @author Zacharie Makeen and Nael Louis
 * This class allows the user to add money to each category
 */
class AddSpendingActivity : MenuActivity() {

    //Initialize the variables that will later be used
    private lateinit var budgetViewModel: BudgetViewModel
    lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_spending)

        //get the view model that will be used to interact with db
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

        //Set the values in the spinner from the array in string.xml
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                category = resources.getStringArray(R.array.categories_array)[p2].toString()
                categoryIndex = p2.toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        //Initiate budget1 as the readAll which returns a liveData list
        val budgets1 = budgetViewModel.readAll
        budgets1.observe(this, Observer { budgets ->
            //For testing
        })


        val updateButton = findViewById<Button>(R.id.updateButton)
        //on click
        updateButton.setOnClickListener {
            //get the user input
            val moneySpent = findViewById<EditText>(R.id.moneySpentInput).text.toString().toDouble()
            //format it before setting into db
            val moneySpentCleaned = String.format(resources.getString(R.string.format), moneySpent).toDouble()

            //Get the list of categories and their values from db
            val budgets = budgetViewModel.readAll
            var currentMoneySpent: Double = 0.0
            //set the value from the db
            budgets.observe(this, Observer { budgets2 ->
                currentMoneySpent = budgets2[categoryIndex.toInt()].spending
            })
            //add to existing values and insert into db
            val budget = Budget(category, moneySpentCleaned + currentMoneySpent)
            budgetViewModel.update(budget)

            //notify the user that it was successfully added
           Toast.makeText(this, resources.getString(R.string.onAddSpending), Toast.LENGTH_LONG).show()
        }
    }
}