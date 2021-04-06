package com.example.a160418042_januar_projectuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.a160418042_januar_projectuts.model.Journal

class JournalDetailViewModel(application: Application): AndroidViewModel(application) {

    val journalLD = MutableLiveData<Journal>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun fetch(id:String) {

        loadingErrorLD.value = false
        loadingDoneLD.value = false
        val journal1 = Journal("1","CALYPTRA","CALYPTRA adalah Jurnal Ilmiah Mahasiswa Universitas Surabaya merupakan kumpulan artikel yang ditulis oleh mahasiswa Universitas Surabaya yang terbit dua kali dalam satu tahun yaitu pada bulan Maret dan September.","http://journal.ubaya.ac.id/public/journals/1/journalThumbnail_en_US.png")
        val journal2 = Journal("2","Keluwih: Journal of Science and Technology","Keluwih: Jurnal Sains dan Teknologi (Keluwih: Journal of Science and Technology) is an online, open access, and peer-reviewed journal. JST publishes its issues twice in a year (February and August). This journal is to provide a forum for the sharing, dissemination, and discussion of original research, case studies, and critical reviews in the fields of science and technology including biotechnology. This focus and scopes include, but are not limited to subjects in industrial engineering, informatics, electrical engineering, manufacture, environmental issues, renewable energi, chemistry and chemical engineering, product design & management, and fashion design & lifestyle products.","http://journal.ubaya.ac.id/public/journals/31/journalThumbnail_en_US.jpg")
        val journal3 = Journal("3","ANIMA Indonesian Psychological Journal","ANIMA Indonesian Psychological Journal publishes peer reviewed articles with editors and consultants providing detailed assistance for authors to reach publication. ANIMA Indonesian Psychological Journal publishes research reports and scientific papers in psychology and/or related sciences with the aim to advance science, knowledge, and theory of psychology.","http://journal.ubaya.ac.id/public/journals/6/journalThumbnail_en_US.jpg")
        val journal4 = Journal("4","MPI (Media Pharmaceutica Indonesiana)","Media Pharmaceutica Indonesiana (MPI) is a journal focusing on pharmaceutical aspects. MPI is dedicated to update and support the development of information and knowledge on pharmaceutical fields. This journal is published twice a year (June and December). MPI has been accredited by Kemenristekdikti since July 9th, 2018 with an accreditation rank of 4.","http://journal.ubaya.ac.id/public/journals/2/journalThumbnail_en_US.jpg")
        if (id == "1")
        {
            journalLD.value = journal1
        }
        else if (id == "2")
        {
            journalLD.value = journal2
        }
        else if (id == "3")
        {
            journalLD.value = journal3
        }
        else
        {
            journalLD.value = journal4
        }
    }
}