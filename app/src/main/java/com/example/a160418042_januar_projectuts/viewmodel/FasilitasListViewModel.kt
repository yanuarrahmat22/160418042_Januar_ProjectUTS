package com.example.a160418042_januar_projectuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.a160418042_januar_projectuts.model.Fasilitas

class FasilitasListViewModel(application: Application): AndroidViewModel(application) {

    val FasilitasLD = MutableLiveData<List<Fasilitas>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun refresh() {
        loadingErrorLD.value = false
        loadingDoneLD.value = false

        val fasilitas1 = Fasilitas("1","Ruang Baca 24 jam (Lantai 1)","dapat dipergunakan pemakai selama 24 jam sebagai ruang baca dan tempat belajar. Pemakai dapat membawa buku miliknya sendiri atau buku perpustakaan yang telah dipinjam sebagai bahan bacaan atau belajar.")
        val fasilitas2 = Fasilitas("2","Ruang Pameran Buku Baru (Lantai 2)","Pemakai dapat mengikuti perkembangan koleksi terbaru yang dimiliki perpustakaan melalui rak pameran buku yang terdapat di ruang baca koleksi.")
        val fasilitas3 = Fasilitas("3","Ruang Baca Koleksi (Lantai 2 & 3)","Ruangan yang terletak di lantai 2 dan 3 ini cukup luas dan dilengkapi sarana tempat baca yang nyaman dapat dimanfaatkan semua pemakai untuk membaca koleksi buku yang dimiliki perpustakaan. Pemakai dapat langsung mengambil buku yang akan dibaca dan meletakkan kembali ke tempat yang disediakan tanpa harus mengembalikan ke rak buku.")
        val fasilitas4 = Fasilitas("4","Ruang Referensi (Lantai 2)","Ruang baca untuk koleksi referensi saat ini berada satu ruangan dengan ruang baca koleksi buku teks di lantai 2.")
        val fasilitas5 = Fasilitas("5","Ruang Baca Koleksi Pascasarjana (Lantai 5)","Ruang baca koleksi pascasarjana menyediakan tempat bagi koleksi serta ruang baca khusus bagi mahasiswa pascasarjana Universitas Surabaya.")
        val fasilitas6 = Fasilitas("6","Ruang Internet (Lantai 2)","Di ruang internet tersedia 50 unit komputer yang dapat digunakan untuk mengakses berbagai informasi baik dari dalam maupun dari luar negeri. Sementara ini fasilitas tersebut hanya diperuntukkan civitas akademika Universitas Surabaya.")
        val fasilitas7 = Fasilitas("7","Ruang Diskusi (Lantai 4)","Ruangan ini disediakan sebagai tempat untuk melakukan diskusi ataupun tempat belajar berkelompok")
        val fasilitas8 = Fasilitas("8","Ruang Audio Visual (Lantai 4)","Ruang audio visual memberikan tempat dan sarana yang nyaman untuk memanfaatkan koleksi AV dengan baik, didukung perangkat lunak dan keras memadai akan lebih mendorong pemakai untuk memanfaatkan koleksi AV dalam menunjang belajar dan mengajar.")
        val fasilitas9 = Fasilitas("9","Kantin (Lantai 4)","Ruang kantin menyediakan makanan dan minuman yang dapat dinikmati pemakai, dengan sarana ini pemakai dapat menghemat waktu dalam memenuhi kebutuhan makan dan minum.")
        val fasilitas10 = Fasilitas("10","Ruang Santai (Lantai 4)","Pemakai dapat melepaskan penat akibat belajar dan aktifitas lainnya dengan bersantai di ruangan ini. Dengan sarana ini diharapkan dapat memulihkan kejenuhan, kepenatan dan kelelahan.")
        val fasilitas11 = Fasilitas("11","Ruang Pertemuan (Lantai 5)","Perpustakaan menyediakan sarana untuk keperluan seminar, rapat baik bersifat intern maupun ekstern. dan dapat dimanfaatkan oleh seluruh sivitas akademika Universitas Surabaya sesuai dengan ketentuan yang berlaku.")
        var fasilitasList:ArrayList<Fasilitas> =  arrayListOf<Fasilitas>()
        fasilitasList = arrayListOf<Fasilitas>(fasilitas1,fasilitas2,fasilitas3,fasilitas4,fasilitas5,fasilitas6,fasilitas7,fasilitas8,fasilitas9,fasilitas10,fasilitas11)
        FasilitasLD.value = fasilitasList
    }
}