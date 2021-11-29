package com.example.budgetingapplication

import android.os.Bundle
import android.view.View
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry

class MainActivity : MenuActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pie = AnyChart.pie()

        val data: MutableList<DataEntry> = ArrayList()
        data.add(ValueDataEntry("Transportation", 10000 ))
        data.add(ValueDataEntry("Home food", 20000 ))
        data.add(ValueDataEntry("Junk food", 5000 ))
        data.add(ValueDataEntry("Entertainment", 20000 ))
        data.add(ValueDataEntry("Housing", 40000 ))
        data.add(ValueDataEntry("Gifts", 5000 ))

        pie.data(data)

        val anyChartView = findViewById<View>(R.id.pieChart) as AnyChartView
        anyChartView.setChart(pie)
    }
}