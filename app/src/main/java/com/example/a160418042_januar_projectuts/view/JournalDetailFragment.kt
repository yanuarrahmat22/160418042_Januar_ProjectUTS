package com.example.a160418042_januar_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160418042_januar_projectuts.R
import com.example.a160418042_januar_projectuts.util.loadImage
import com.example.a160418042_januar_projectuts.viewmodel.JournalDetailViewModel
import kotlinx.android.synthetic.main.fragment_journal_detail.*

class JournalDetailFragment : Fragment() {

    private lateinit var viewModel: JournalDetailViewModel

    fun observeViewModel() {
        viewModel.journalLD.observe(viewLifecycleOwner, Observer {
            imgViewJournal.loadImage(it.image_url,progressBar4)
            txtViewNama.text = it.nama
            txtAboutJournal.text = it.about
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_journal_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var id = ""
        arguments?.let {
            id = JournalDetailFragmentArgs.fromBundle(requireArguments()).journalid
        }

        viewModel = ViewModelProvider(this).get(JournalDetailViewModel::class.java)
        viewModel.fetch(id)

        observeViewModel()
    }

}