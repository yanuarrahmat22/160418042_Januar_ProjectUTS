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
import com.example.a160418042_januar_projectuts.viewmodel.FasilitasListViewModel
import kotlinx.android.synthetic.main.fragment_fasilitas_list.*
import kotlinx.android.synthetic.main.fragment_fasilitas_list.progressLoad
import kotlinx.android.synthetic.main.fragment_fasilitas_list.txtError


class FasilitasListFragment : Fragment() {

    private lateinit var viewModel: FasilitasListViewModel
    private val fasilitasListAdapter  = FasilitasListAdapter(arrayListOf())

    fun observeViewModel() {
        viewModel.FasilitasLD.observe(viewLifecycleOwner, Observer {
            fasilitasListAdapter.updateFasilitasList(it)
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
                fasilitasListView.visibility = View.INVISIBLE
                progressLoad.visibility = View.VISIBLE
            } else {
                fasilitasListView.visibility = View.VISIBLE
                progressLoad.visibility = View.INVISIBLE
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FasilitasListViewModel::class.java)
        viewModel.refresh()

        fasilitasListView.layoutManager = LinearLayoutManager(context)
        fasilitasListView.adapter = fasilitasListAdapter

        refreshLayout.setOnRefreshListener {
            fasilitasListView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fasilitas_list, container, false)
    }

}