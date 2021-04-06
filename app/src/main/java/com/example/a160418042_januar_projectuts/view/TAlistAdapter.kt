package com.example.a160418042_januar_projectuts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.a160418042_januar_projectuts.R
import com.example.a160418042_januar_projectuts.model.TA
import kotlinx.android.synthetic.main.tugas_akhir_list_item.view.*

class TAlistAdapter (val taList:ArrayList<TA>)
    : RecyclerView.Adapter<TAlistAdapter.TAViewHolder>()
{
    class TAViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateTAList(newTAList: List<TA>) {
        taList.clear()
        taList.addAll(newTAList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return taList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TAViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.tugas_akhir_list_item, parent, false)

        return TAlistAdapter.TAViewHolder(view)
    }

    override fun onBindViewHolder(holder: TAViewHolder, position: Int) {
        var id:String = taList[position].id.toString()
        holder.view.txtJdlTA.text = taList[position].judul
        holder.view.txtFakultas.text = taList[position].fakultas
        holder.view.txtAuthorTA.text = taList[position].author
        holder.view.btnDetailTA.setOnClickListener {
            val action = TugasAkhirListFragmentDirections.toTugasAkhirDetailFragment(id)
            Navigation.findNavController(it).navigate(action)
        }
    }
}