package com.example.budgetingapplication

import android.graphics.Color
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.androidplot.pie.PieChart
import com.androidplot.pie.Segment
import com.androidplot.pie.SegmentFormatter
import com.example.budgetingapplication.model.Budget
import com.example.budgetingapplication.viewmodel.BudgetViewModel

class MainActivity : MenuActivity() {

    private lateinit var budgetViewModel: BudgetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayList = ArrayList<Int>()

        arrayList.add(20)
        arrayList.add(20)
        arrayList.add(5)
        arrayList.add(15)
        arrayList.add(50)
        arrayList.add(10)

        val transportation = Segment("Transportation", arrayList.get(0))
        val homeFood = Segment("Home Food", arrayList.get(1))
        val junkFood = Segment("Junk Food", arrayList.get(2))
        val entertainment = Segment("Entertainment", arrayList.get(3))
        val housing = Segment("Housing", arrayList.get(4))
        val gifts = Segment("Gift", arrayList.get(5))

        val transportationSF = SegmentFormatter(ResourcesCompat.getColor(resources, R.color.dark_jungle_green, null))
        val homeFoodSF = SegmentFormatter(ResourcesCompat.getColor(resources, R.color.myrtle_green, null))
        val junkFoodSF = SegmentFormatter(ResourcesCompat.getColor(resources, R.color.red_pigment, null))
        val entertainmentSF = SegmentFormatter(ResourcesCompat.getColor(resources, R.color.medium_purple, null))
        val housingSF = SegmentFormatter(ResourcesCompat.getColor(resources, R.color.redwood, null))
        val giftsSF = SegmentFormatter(ResourcesCompat.getColor(resources, R.color.wintergreen_dream, null))


        val pieChart = findViewById<PieChart>(R.id.pieChart)

        pieChart.addSegment(transportation, transportationSF)
        pieChart.addSegment(homeFood, homeFoodSF)
        pieChart.addSegment(junkFood, junkFoodSF)
        pieChart.addSegment(entertainment, entertainmentSF)
        pieChart.addSegment(housing, housingSF)
        pieChart.addSegment(gifts, giftsSF)
    }
}