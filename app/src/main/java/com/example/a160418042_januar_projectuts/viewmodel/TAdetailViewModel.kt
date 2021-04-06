package com.example.a160418042_januar_projectuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.a160418042_januar_projectuts.model.TA

class TAdetailViewModel(application: Application): AndroidViewModel(application) {
    val tugasAkhirLD = MutableLiveData<TA>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    fun fetch(id:String) {

        loadingErrorLD.value = false
        loadingDoneLD.value = false

        val ta1 = TA("1","PEMBUATAN APLIKASI PENGENALAN WAJAH DENGAN METODE DISCRETE COSINE TRANSFORM DENGAN CONTOH KASUS PRESENSI SEDERHANA","Teknik","Informatika","Rendy Yonathan Sofian","Bidang penelitian pemrosesan wajah (face processing) dan pendeteksian wajah manusia (face detection) adalah salah satu tahap awal yang sangat penting di dalam proses pengenalan wajah (face recognition). Proses pengenalan wajah (face recognition) oleh manusia merupakan tugas visual tingkat tinggi (high level visual task) yang sangat sulit untuk dikerjakan secara rinci. Hal ini dikarenakan wajah memiliki kekomplekskan yang alami. Discretee Cosine Transform (DCT) merupakan urut-urutan beberapa titik data dalam bentuk sejumlah fungsi kosinus pada frekuensi yang berbeda. DCT atau khususnya DCT-II sering digunakan dalam pengolahan sinyal dan gambar, terutama untuk kompresi lossy data, seperti audio (mp3) dan gambar (JPEG) dimana sebagian kecil dari high-frequency  dapat dihilangkan, yaitu dengan metode spektral untuk penyelesaian numeric dari sebagian persamaan diferensial.  DCT menggunakan fungsi kosinus sebagai fungsi utama dibandingkan dengan sinus, karena ternyata fungsi kosinus jauh lebih efisien. Aplikasi yang dibuat merupakan sebuah aplikasi pencocokkan wajah yang memanfaatkan perhitungan DCT. Aplikasi menyimpan minimal lima wajah untuk tiap orang yang hendak dikenali oleh sistem. Output dari aplikasi ini adalah sebuah daftar presensi yang menyatakan waktu kehadiran dan waktu keluar, disertakan status mengenai terlambat atau lembur orang tersebut. Aplikasi dapat dikembangkan lagi sebagai sebuah sistem presensi dengan perhitungan yang lengkap selayaknya presensi sebuah perusahaan. Melalui uji coba yang dilakukan, aplikasi telah memenuhi tujuan awal sistem dibuat, dimana sistem dapat mengenali wajah input-an dan dapat menghasilkan output sebuah daftar presensi. Dapat disimpulkan aplikasi ini dapat dijadikan sebuah dasar sebuah sistem presensi.")
        val ta2 = TA("2","BIBLIOTHERAPY DAN FORGIVENESS THERAPY UNTUK MENINGKATKAN HARGA DIRI PADA KORBAN BULLYING","Psikologi","Psikologi","Mangesthiningtyas Adi Pratiwi","Penelitian ini bertujuan untuk melihat pengaruh bibliotherapy dan forgiveness therapy terhadap peningkatan harga diri dan penurunan distorsi kognitif pada korban bullying. Responden dalam penelitian ini adalah dua orang remaja kelas 2 SMP. Desain penelitian ini adalah one group before after/pre-test post-test tanpa kelompok kontrol dengan menggunakan uji wilcoxon. Pengukuran menggunakan angket CSEI (Coopersmith Self Esteem Inventory) dan angket distorsi kognitif. Hasil dari penelitian ini adalah tidak ada perbedaan harga diri yang signifikan antara sebelum dan sesudah pemberian intervensi (p=0,180>0,05). Begitupula pada pengukuran distorsi kognitif pada empat kelompok distorsi, tidak ada perbedaan distorsi kognitif antara sebelum dan sesudah pemberian intervensi (p>0,05). Meskipun secara uji statistika tidak ada pebedaan yang signifikan, namun didapatkan secara uji deskriptif, ada perubahan kategori harga diri dan distorsi kognitif antara sebelum serta sesudah intervensi. Dapat dikatakan bahwa bibliotherapy dan forgiveness therapy memiliki pengaruh positif terhadap peningkatan harga diri serta penurunan distorsi kognitif pada kedua responden. ")

        if (id == "1")
        {
            tugasAkhirLD.value = ta1
        }
        else if (id == "2")
        {
            tugasAkhirLD.value = ta2
        }
    }
}