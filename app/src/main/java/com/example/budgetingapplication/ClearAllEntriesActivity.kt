package com.example.budgetingapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ClearAllEntriesActivity : MenuActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clear_all_entries)
    }
}