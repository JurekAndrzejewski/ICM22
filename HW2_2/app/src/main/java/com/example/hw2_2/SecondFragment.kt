package com.example.hw2_2

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.hw2_2.databinding.FragmentSecondBinding
import java.net.URL


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment: Fragment() {
    private var _binding: FragmentSecondBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_second, container, false) as View
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        println(arguments?.getString("city"))
        val response = arguments?.getString("city")?.let { run(it) }
        println(response)
        view.findViewById<TextView>(R.id.textView2)?.text = response
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}