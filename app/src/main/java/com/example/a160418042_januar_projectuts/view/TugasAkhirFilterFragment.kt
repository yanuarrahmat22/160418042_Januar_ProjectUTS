package com.example.a160418042_januar_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.a160418042_januar_projectuts.R
import kotlinx.android.synthetic.main.fragment_tugas_akhir_filter.*

class TugasAkhirFilterFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var faculty = ""

        btnAllFac.setOnClickListener {
            val action = TugasAkhirFilterFragmentDirections.filterToTugasAkhirListFragment()
            Navigation.findNavController(it).navigate(action)
        }

        btnEngine.setOnClickListener {
            faculty = "Teknik"
            val action = TugasAkhirFilterFragmentDirections.filterToTugasAkhirListFragment(faculty)
            Navigation.findNavController(it).navigate(action)
        }

        btnPsyco.setOnClickListener {
            faculty = "Psikologi"
            val action = TugasAkhirFilterFragmentDirections.filterToTugasAkhirListFragment(faculty)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tugas_akhir_filter, container, false)
    }

}