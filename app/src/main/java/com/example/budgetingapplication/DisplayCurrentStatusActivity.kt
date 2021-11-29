package com.example.budgetingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.budgetingapplication.viewmodel.BudgetViewModel

/**
 * @author Kirill Parhomenco
 * this activity display the value of each category fetched from the database
 */
class DisplayCurrentStatusActivity : MenuActivity() {

    private lateinit var budgetViewModel: BudgetViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        budgetViewModel = ViewModelProvider(this).get(BudgetViewModel::class.java)
        setContentView(R.layout.activity_display_current_status)

        // setup text views
        val transportation = findViewById<TextView>(R.id.transportation)
        val homeFood = findViewById<TextView>(R.id.homeFood)
        val junkFood = findViewById<TextView>(R.id.junkFood)
        val entertainment = findViewById<TextView>(R.id.entertainment)
        val housing = findViewById<TextView>(R.id.housing)
        val gifts = findViewById<TextView>(R.id.gifts)

        val budgets = budgetViewModel.readAll

        budgets.observe(this, {data ->
            transportation.text = data[0].spending.toString()
            homeFood.text = data[1].spending.toString()
            junkFood.text = data[2].spending.toString()
            entertainment.text = data[3].spending.toString()
            housing.text = data[4].spending.toString()
            gifts.text = data[5].spending.toString()
        })
    }
}