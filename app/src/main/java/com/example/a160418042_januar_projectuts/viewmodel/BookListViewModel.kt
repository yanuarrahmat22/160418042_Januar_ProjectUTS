package com.example.a160418042_januar_projectuts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.a160418042_januar_projectuts.model.Book

class BookListViewModel(application: Application):AndroidViewModel(application) {

    val bookLD = MutableLiveData<List<Book>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun refresh(kategori:String) {
        loadingErrorLD.value = false
        loadingDoneLD.value = false

        val book1 = Book("1","Artificial Intelligence A Modern Approach Fou","Teknologi","Stuart J. Russell and Peter Norvig","Artificial Intelligence (AI) is a big field, and this is a big book. We have tried to explore\n" +
                "the full breadth of the field, which encompasses logic, probability, and continuous mathematics; perception, reasoning, learning, and action; fairness, trust, social good, and safety; and\n" +
                "applications that range from microelectronic devices to robotic planetary explorers to online\n" +
                "services with billions of users.\n" +
                "The subtitle of this book is “A Modern Approach.” That means we have chosen to tell\n" +
                "the story from a current perspective. We synthesize what is now known into a common\n" +
                "framework, recasting early work using the ideas and terminology that are prevalent today.\n" +
                "We apologize to those whose subfields are, as a result, less recognizable.","http://aima.cs.berkeley.edu/cover2.jpg")
        val book2 = Book("2","Psikologi Kepribadian Edisi Revisi","Psikologi","Alwisol","Sejak lahirn ya ilmu psikologi pada akhir abad 18, kepribadian selalu menjadi salah satu topik bahasan yang penting. Psikologi lahir sebagai ilmu yang berusaha memahami manusia seutuhnya, yang hanya dapat dilakukan melalui pemahaman tentang kepribadian. Teori Psikologi Kepribadian melahirkan konsep-konsep seperti dinamika pengaturan tingkah laku, pola tingkah laku, model tingkah laku dan perkembangan repertoir tingkah laku, dalam rangka mengurai kompleksitas tingkah laku manusia. Ahli-ahli psikologi kepribadian melakukan riset yang cermat untuk menguji konsep-konsep itu, memakai kaidah-kaidah ilmiah untuk menegakkan teori yang andal; yakni teori yang dapat mengemban fungsi deskriptif dan prediktif dalam kerangka pendekatan psikologik. Pakar-pakar psikologi itu memakai kerangka berfikir psikologi untuk memahami manusia sebagai individu. \n","https://ummpress.umm.ac.id/files/image/cover_buku/Psikologi%20Kepribadian.jpg")
        var bookList:ArrayList<Book> =  arrayListOf<Book>()
        if (kategori == "Teknologi")
        {
            bookList = arrayListOf<Book>(book1)
        }
        else if (kategori == "Psikologi")
        {
            bookList = arrayListOf<Book>(book2)
        }
        else
        {
            bookList = arrayListOf<Book>(book1, book2)
        }
        bookLD.value = bookList
//        queue = Volley.newRequestQueue(getApplication())
//        val url = "http://10.0.2.2/AdvNative/getbook.php"
//
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            { response ->
//                val sType = object : TypeToken<List<Book>>() { }.type
//                val result = Gson().fromJson<List<Book>>(response, sType)
//                bookLD.value = result
//                loadingDoneLD.value = false
//                Log.d("showvoley", response.toString())
//            },
//            {
//                Log.d("showvoley", it.toString())
//                loadingErrorLD.value = true
//                loadingDoneLD.value = false
//            })
//
//        stringRequest.tag = TAG
//        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

}