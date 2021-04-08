package com.example.a160418042_januar_projectuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.a160418042_januar_projectuts.model.Fasilitas
import com.example.a160418042_januar_projectuts.model.GlobalFasilitas

class FasilitasListViewModel(application: Application): AndroidViewModel(application) {

    val FasilitasLD = MutableLiveData<List<Fasilitas>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun refresh() {
        loadingErrorLD.value = false
        loadingDoneLD.value = false

        FasilitasLD.value = GlobalFasilitas.fasilitasList
    }
}