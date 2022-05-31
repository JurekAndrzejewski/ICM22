package com.example.hw2_2

import CustomAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FirstFragment : Fragment() {
    private val data = ArrayList<ItemsViewModel>()
    private val cities = listOf("Lodz", "Lisbon", "Berlin", "Rome", "Paris", "Warsaw", "Budapest", "Madrid", "Barcelona", "Prague")

    private fun addData(city: String)
    {
        data.add(ItemsViewModel(R.drawable.ic_baseline_location_city_24, city))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        for (city in cities) {
            addData(city)
        }

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false) as View

        val bundle = Bundle()
        val city = "Lodz"
        fun navigateIt(city: String) {
            bundle.putString("city", city)
            findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }


        val adapter = CustomAdapter(data) { navigateIt(it)}

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapter
        return view
    }
}