package com.example.budgetingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * @author Zacharie Makeen
 * This is to display the team members information and the version of the app
 */
class AboutActivity : MenuActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }
}