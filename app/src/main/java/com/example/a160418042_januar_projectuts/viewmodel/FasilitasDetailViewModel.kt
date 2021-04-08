package com.example.a160418042_januar_projectuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.a160418042_januar_projectuts.model.Fasilitas
import com.example.a160418042_januar_projectuts.model.GlobalFasilitas

class FasilitasDetailViewModel(application: Application): AndroidViewModel(application)  {

    val fasilitasLD = MutableLiveData<Fasilitas>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun fetch(id:String) {

        loadingErrorLD.value = false
        loadingDoneLD.value = false

        var fasilitasList = GlobalFasilitas.fasilitasList

        for (f in fasilitasList)
        {
            if (f.id == id)
            {
                fasilitasLD.value = f
                break
            }
        }

    }

}