package com.example.a160418042_januar_projectuts.view

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.a160418042_januar_projectuts.R
import com.example.a160418042_januar_projectuts.model.GlobalFasilitas
import kotlinx.android.synthetic.main.fragment_peminjaman_fasilitas.*
import java.text.SimpleDateFormat
import java.util.*

class PeminjamanFasilitasFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterFasilitas = this.context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, GlobalFasilitas.fasilitasList) }

        adapterFasilitas?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFasilitas.adapter = adapterFasilitas

        val adapterJamMulai = this.context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, GlobalFasilitas.jamMulai) }

        adapterJamMulai?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerJamMulai.adapter = adapterJamMulai

        val adapterJamSelesai = this.context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, GlobalFasilitas.jamSelesai) }

        adapterJamSelesai?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerJamSelesai.adapter = adapterJamSelesai

        val adapterTujuan = this.context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, GlobalFasilitas.tujuanPenggunaan) }

        adapterTujuan?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTujuan.adapter = adapterTujuan

        txtShowDate.setOnClickListener {
            val today = Calendar.getInstance()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DAY_OF_MONTH)
            var picker = this.context?.let {DatePickerDialog(it, DatePickerDialog.OnDateSetListener { datePicker, selYear, selMonth, selDay -> val calendar = Calendar.getInstance()
                calendar.set(selYear, selMonth, selDay)
                var dateFormat = SimpleDateFormat("dd MMMM yyyy")
                var str = dateFormat.format(calendar.time)
                txtShowDate.setText(str)
            },year, month, day)}
            picker?.show()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_peminjaman_fasilitas, container, false)
    }
}