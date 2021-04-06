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
import com.example.a160418042_januar_projectuts.viewmodel.BookListViewModel
import kotlinx.android.synthetic.main.book_list_item.view.*
import kotlinx.android.synthetic.main.fragment_book_list.*

class BookListFragment : Fragment() {

    private lateinit var viewModel: BookListViewModel
    private val bookListAdapter  = BookListAdapter(arrayListOf())

    fun observeViewModel() {
        viewModel.bookLD.observe(viewLifecycleOwner, Observer {
            bookListAdapter.updateBookList(it)
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
                bookListView.visibility = View.INVISIBLE
                progressLoad.visibility = View.VISIBLE
            } else {
                bookListView.visibility = View.VISIBLE
                progressLoad.visibility = View.INVISIBLE
            }
        })


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnFilter.setOnClickListener {
            val action = BookListFragmentDirections.toBookFilterFragment()
            Navigation.findNavController(it).navigate(action)
        }

        var kategori = ""

        arguments?.let {
            kategori = BookListFragmentArgs.fromBundle(requireArguments()).kategori
        }

        viewModel = ViewModelProvider(this).get(BookListViewModel::class.java)
        viewModel.refresh(kategori)

        bookListView.layoutManager = LinearLayoutManager(context)
        bookListView.adapter = bookListAdapter

        refreshLayout.setOnRefreshListener {
            bookListView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh(kategori)
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_book_list, container, false)
    }


}