package com.example.part5bitfit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EntryListFragment : Fragment() {
    private val viewModel: WaterViewModel by activityViewModels()
    private lateinit var adapter: WaterEntryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_entry_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        adapter = WaterEntryAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.allEntries.observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }

        return view
    }
}
