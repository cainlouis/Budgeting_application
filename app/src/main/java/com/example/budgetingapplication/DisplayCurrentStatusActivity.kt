package com.example.budgetingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * @author Kirill Parhomenco
 * this activity display the value of each category fetched from the database
 */
class DisplayCurrentStatusActivity : MenuActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_current_status)
    }
}