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
import com.example.a160418042_januar_projectuts.viewmodel.JournalListViewModel
import kotlinx.android.synthetic.main.fragment_journal_list.*
import kotlinx.android.synthetic.main.fragment_journal_list.progressLoad
import kotlinx.android.synthetic.main.fragment_journal_list.refreshLayout
import kotlinx.android.synthetic.main.fragment_journal_list.txtError

class JournalListFragment : Fragment() {

    private lateinit var viewModel: JournalListViewModel
    private val journalListAdapter  = JournalListAdapter(arrayListOf())

    fun observeViewModel() {
        viewModel.journalLD.observe(viewLifecycleOwner, Observer {
            journalListAdapter.updateJournalList(it)
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
                journalListView.visibility = View.INVISIBLE
                progressLoad.visibility = View.VISIBLE
            } else {
                journalListView.visibility = View.VISIBLE
                progressLoad.visibility = View.INVISIBLE
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(JournalListViewModel::class.java)
        viewModel.refresh()

        journalListView.layoutManager = LinearLayoutManager(context)
        journalListView.adapter = journalListAdapter

        refreshLayout.setOnRefreshListener {
            journalListView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_journal_list, container, false)
    }

}