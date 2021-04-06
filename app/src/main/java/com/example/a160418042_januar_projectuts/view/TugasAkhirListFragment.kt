package com.example.a160418042_januar_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160418042_januar_projectuts.R
import com.example.a160418042_januar_projectuts.viewmodel.TAlistViewModel
import kotlinx.android.synthetic.main.fragment_tugas_akhir_list.*

class TugasAkhirListFragment : Fragment() {

    private lateinit var viewModel: TAlistViewModel
    private val tugasAkhirListAdapter  = TAlistAdapter(arrayListOf())

    fun observeViewModel() {
        viewModel.tugasAkhirLD.observe(viewLifecycleOwner, Observer {
            tugasAkhirListAdapter.updateTAList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtError.visibility = View.VISIBLE
            } else {
                txtError.visibility = View.INVISIBLE
            }
        })

        viewModel.loadingDoneLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                tugasAkhirListView.visibility = View.INVISIBLE
                progressLoad.visibility = View.VISIBLE
            } else {
                tugasAkhirListView.visibility = View.VISIBLE
                progressLoad.visibility = View.INVISIBLE
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnFilter.setOnClickListener {
            val action = TugasAkhirListFragmentDirections.toTugasAkhirFilterFragment()
            Navigation.findNavController(it).navigate(action)
        }

        var fakultas = ""

        arguments?.let {
            fakultas = TugasAkhirListFragmentArgs.fromBundle(requireArguments()).fakultasFilter
        }

        viewModel = ViewModelProvider(this).get(TAlistViewModel::class.java)
        viewModel.refresh(fakultas)

        tugasAkhirListView.layoutManager = LinearLayoutManager(context)
        tugasAkhirListView.adapter = tugasAkhirListAdapter

        refreshLayout.setOnRefreshListener {
            tugasAkhirListView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh(fakultas)
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tugas_akhir_list, container, false)
    }
}