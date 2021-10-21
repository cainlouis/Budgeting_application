package com.example.budgetingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddSpendingActivity : MenuActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_spending)
    }
}