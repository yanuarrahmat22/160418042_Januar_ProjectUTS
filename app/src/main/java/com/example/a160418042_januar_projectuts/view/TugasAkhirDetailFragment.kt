package com.example.a160418042_januar_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160418042_januar_projectuts.R
import com.example.a160418042_januar_projectuts.viewmodel.BookDetailViewModel
import com.example.a160418042_januar_projectuts.viewmodel.TAdetailViewModel
import kotlinx.android.synthetic.main.fragment_tugas_akhir_detail.*

class TugasAkhirDetailFragment : Fragment() {

    private lateinit var viewModel: TAdetailViewModel

    fun observeViewModel() {
        viewModel.tugasAkhirLD.observe(viewLifecycleOwner, Observer {
            txtLblJudulTA.text = it.judul
            txtJurusan.text = it.jurusan
            txtLblAuthor.text = it.author
            txtAbstrak.text = it.abstrak
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var id = ""
        arguments?.let {
            id = TugasAkhirDetailFragmentArgs.fromBundle(requireArguments()).TAid
        }

        viewModel = ViewModelProvider(this).get(TAdetailViewModel::class.java)
        viewModel.fetch(id)

        observeViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tugas_akhir_detail, container, false)
    }
}