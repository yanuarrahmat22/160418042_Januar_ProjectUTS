package com.example.a160418042_januar_projectuts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418042_januar_projectuts.R
import com.example.a160418042_januar_projectuts.model.Journal
import com.example.a160418042_januar_projectuts.util.loadImage
import kotlinx.android.synthetic.main.fragment_journal_list.view.*
import kotlinx.android.synthetic.main.journal_list_item.view.*

class JournalListAdapter (val journalList:ArrayList<Journal>)
    : RecyclerView.Adapter<JournalListAdapter.JournalViewHolder>()
{
    class JournalViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateJournalList(newJournalList: List<Journal>) {
        journalList.clear()
        journalList.addAll(newJournalList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.journal_list_item, parent, false)

        return JournalListAdapter.JournalViewHolder(view)
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        var id:String = journalList[position].id.toString()
        holder.view.imgViewJournal.loadImage(journalList[position].image_url,
            holder.view.progressBar3)
        holder.view.txtNamaJournal.text = journalList[position].nama
        holder.view.btnDetailJournal.setOnClickListener {
            val action = JournalListFragmentDirections.toJournalDetailFragment(id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return journalList.size
    }
}