package com.example.part5bitfit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels


class DashboardFragment : Fragment() {

    private val viewModel: WaterViewModel by activityViewModels() // Access ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // Reference to the TextView that will display total glasses
        val summaryText = view.findViewById<TextView>(R.id.summaryText)

        // Observe the allEntries LiveData from the ViewModel
        viewModel.allEntries.observe(viewLifecycleOwner) { entries ->
            // Calculate total glasses
            val totalGlasses = entries.sumOf { it.glasses }
            // Update the UI
            summaryText.text = "Total glasses: $totalGlasses"
        }

        return view
    }
}
