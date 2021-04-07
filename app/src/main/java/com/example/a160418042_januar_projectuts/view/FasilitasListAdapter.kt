package com.example.a160418042_januar_projectuts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418042_januar_projectuts.R
import com.example.a160418042_januar_projectuts.model.Fasilitas
import kotlinx.android.synthetic.main.fasilitas_list_item.view.*

class FasilitasListAdapter  (val fasilitasList:ArrayList<Fasilitas>)
    : RecyclerView.Adapter<FasilitasListAdapter.FasilitasViewHolder>()
{
    class FasilitasViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateFasilitasList(newFasilitasList: List<Fasilitas>) {
        fasilitasList.clear()
        fasilitasList.addAll(newFasilitasList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FasilitasViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fasilitas_list_item, parent, false)

        return FasilitasListAdapter.FasilitasViewHolder(view)
    }

    override fun onBindViewHolder(holder: FasilitasViewHolder, position: Int) {
        var id:String = fasilitasList[position].id.toString()
        holder.view.txtNamaFasil.text = fasilitasList[position].nama
        holder.view.btnDetailFasil.setOnClickListener {
            val action = FasilitasListFragmentDirections.toDetailFasilitasFragment(id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return fasilitasList.size
    }
}