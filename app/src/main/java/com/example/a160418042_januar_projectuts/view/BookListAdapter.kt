package com.example.a160418042_januar_projectuts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418042_januar_projectuts.R
import com.example.a160418042_januar_projectuts.model.Book
import com.example.a160418042_januar_projectuts.util.loadImage
import kotlinx.android.synthetic.main.book_list_item.view.*

class BookListAdapter (val bookList:ArrayList<Book>)
    : RecyclerView.Adapter<BookListAdapter.BookViewHolder>()
{
    class BookViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateBookList(newBookList: List<Book>) {
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.book_list_item, parent, false)

        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        var id:String = bookList[position].id.toString()
        holder.view.txtJudul.text = bookList[position].judul
        holder.view.txtKategori.text = bookList[position].kategori
        holder.view.txtAuthor.text = bookList[position].author
        holder.view.imageView.loadImage(bookList[position].image_url,
            holder.view.progressBar)
        holder.view.btnDetail.setOnClickListener {
            val action = BookListFragmentDirections.toBookDetailFragment(id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

}