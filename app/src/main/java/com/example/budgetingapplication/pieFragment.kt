package com.example.budgetingapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.example.budgetingapplication.viewmodel.BudgetViewModel



/**
 * A simple [Fragment] subclass.
 * Use the [PieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PieFragment : Fragment() {
    private lateinit var budgetViewModel: BudgetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        budgetViewModel = ViewModelProvider(this).get(BudgetViewModel::class.java)

        val pie = AnyChart.pie()

        val budgets = budgetViewModel.readAll
        val data: MutableList<DataEntry> = ArrayList()

        budgets.observe(this, { values ->
            data.add(ValueDataEntry("Transportation", values[0].spending))
            data.add(ValueDataEntry("Home food", values[1].spending))
            data.add(ValueDataEntry("Junk food", values[2].spending))
            data.add(ValueDataEntry("Entertainment", values[3].spending))
            data.add(ValueDataEntry("Housing", values[4].spending))
            data.add(ValueDataEntry("Gifts", values[5].spending))

            // Add the data to the pie
            pie.data(data)
            val anyChartView = getView()?.findViewById(R.id.pieChart) as AnyChartView
            anyChartView.setChart(pie)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pie, container, false)
    }

}