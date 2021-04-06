package com.example.a160418042_januar_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.a160418042_januar_projectuts.R
import kotlinx.android.synthetic.main.fragment_book_filter.*
import kotlinx.android.synthetic.main.fragment_book_list.*

class BookFilterFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var kategori = ""

        btnAll.setOnClickListener {
            val action = BookFilterFragmentDirections.filterToBookListFragment()
            Navigation.findNavController(it).navigate(action)
        }

        btnTeknologi.setOnClickListener {
            kategori = "Teknologi"
            val action = BookFilterFragmentDirections.filterToBookListFragment(kategori)
            Navigation.findNavController(it).navigate(action)
        }

        btnPsiko.setOnClickListener {
            kategori = "Psikologi"
            val action = BookFilterFragmentDirections.filterToBookListFragment(kategori)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_book_filter, container, false)
    }

}