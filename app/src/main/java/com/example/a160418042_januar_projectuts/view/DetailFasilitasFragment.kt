package com.example.a160418042_januar_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160418042_januar_projectuts.R
import com.example.a160418042_januar_projectuts.viewmodel.FasilitasDetailViewModel
import kotlinx.android.synthetic.main.fragment_detail_fasilitas.*

class DetailFasilitasFragment : Fragment() {

    private lateinit var viewModel: FasilitasDetailViewModel

    fun observeViewModel() {
        viewModel.fasilitasLD.observe(viewLifecycleOwner, Observer {
            txtNamaFasilitas.text = it.nama
            txtKeterangan.text = it.keterangan
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var id = ""
        arguments?.let {
            id = DetailFasilitasFragmentArgs.fromBundle(requireArguments()).fasilitasID
        }

        viewModel = ViewModelProvider(this).get(FasilitasDetailViewModel::class.java)
        viewModel.fetch(id)

        observeViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_fasilitas, container, false)
    }

}