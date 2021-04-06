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
import com.example.a160418042_januar_projectuts.viewmodel.BookDetailViewModel
import kotlinx.android.synthetic.main.fragment_book_detail.*

class BookDetailFragment : Fragment() {

    private lateinit var viewModel: BookDetailViewModel

    fun observeViewModel() {
        viewModel.bookLD.observe(viewLifecycleOwner, Observer {
            imgViewBook.loadImage(it.image_url,progressBar2)
            txtLblJudul.text = it.judul
            txtVAbout.text = it.about
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var id = ""
        arguments?.let {
            id = BookDetailFragmentArgs.fromBundle(requireArguments()).id
        }

        viewModel = ViewModelProvider(this).get(BookDetailViewModel::class.java)
        viewModel.fetch(id)

        observeViewModel()
    }

}