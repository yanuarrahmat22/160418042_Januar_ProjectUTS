package com.example.a160418042_januar_projectuts.model

object GlobalFasilitas {
    private val fasilitas1 = Fasilitas("1","Ruang Baca 24 jam (Lantai 1)","dapat dipergunakan pemakai selama 24 jam sebagai ruang baca dan tempat belajar. Pemakai dapat membawa buku miliknya sendiri atau buku perpustakaan yang telah dipinjam sebagai bahan bacaan atau belajar.")
    private val fasilitas2 = Fasilitas("2","Ruang Pameran Buku Baru (Lantai 2)","Pemakai dapat mengikuti perkembangan koleksi terbaru yang dimiliki perpustakaan melalui rak pameran buku yang terdapat di ruang baca koleksi.")
    private val fasilitas3 = Fasilitas("3","Ruang Baca Koleksi (Lantai 2 & 3)","Ruangan yang terletak di lantai 2 dan 3 ini cukup luas dan dilengkapi sarana tempat baca yang nyaman dapat dimanfaatkan semua pemakai untuk membaca koleksi buku yang dimiliki perpustakaan. Pemakai dapat langsung mengambil buku yang akan dibaca dan meletakkan kembali ke tempat yang disediakan tanpa harus mengembalikan ke rak buku.")
    private val fasilitas4 = Fasilitas("4","Ruang Referensi (Lantai 2)","Ruang baca untuk koleksi referensi saat ini berada satu ruangan dengan ruang baca koleksi buku teks di lantai 2.")
    private val fasilitas5 = Fasilitas("5","Ruang Baca Koleksi Pascasarjana (Lantai 5)","Ruang baca koleksi pascasarjana menyediakan tempat bagi koleksi serta ruang baca khusus bagi mahasiswa pascasarjana Universitas Surabaya.")
    private val fasilitas6 = Fasilitas("6","Ruang Internet (Lantai 2)","Di ruang internet tersedia 50 unit komputer yang dapat digunakan untuk mengakses berbagai informasi baik dari dalam maupun dari luar negeri. Sementara ini fasilitas tersebut hanya diperuntukkan civitas akademika Universitas Surabaya.")
    private val fasilitas7 = Fasilitas("7","Ruang Diskusi (Lantai 4)","Ruangan ini disediakan sebagai tempat untuk melakukan diskusi ataupun tempat belajar berkelompok")
    private val fasilitas8 = Fasilitas("8","Ruang Audio Visual (Lantai 4)","Ruang audio visual memberikan tempat dan sarana yang nyaman untuk memanfaatkan koleksi AV dengan baik, didukung perangkat lunak dan keras memadai akan lebih mendorong pemakai untuk memanfaatkan koleksi AV dalam menunjang belajar dan mengajar.")
    private val fasilitas9 = Fasilitas("9","Kantin (Lantai 4)","Ruang kantin menyediakan makanan dan minuman yang dapat dinikmati pemakai, dengan sarana ini pemakai dapat menghemat waktu dalam memenuhi kebutuhan makan dan minum.")
    private val fasilitas10 = Fasilitas("10","Ruang Santai (Lantai 4)","Pemakai dapat melepaskan penat akibat belajar dan aktifitas lainnya dengan bersantai di ruangan ini. Dengan sarana ini diharapkan dapat memulihkan kejenuhan, kepenatan dan kelelahan.")
    private val fasilitas11 = Fasilitas("11","Ruang Pertemuan (Lantai 5)","Perpustakaan menyediakan sarana untuk keperluan seminar, rapat baik bersifat intern maupun ekstern. dan dapat dimanfaatkan oleh seluruh sivitas akademika Universitas Surabaya sesuai dengan ketentuan yang berlaku.")
    var fasilitasList:ArrayList<Fasilitas> = arrayListOf<Fasilitas>(fasilitas1,fasilitas2,fasilitas3,fasilitas4,fasilitas5,fasilitas6,fasilitas7,fasilitas8,fasilitas9,fasilitas10,fasilitas11)

    val jamMulai:Array<Jam> = arrayOf(
            Jam("1", "08:00"),
            Jam("2", "09:00"),
            Jam("3", "10:00"),
            Jam("4", "11:00"),
            Jam("5", "12:00"),
            Jam("6", "13:00"),
            Jam("7", "14:00"),
            Jam("8", "15:00"),
            Jam("9", "16:00"),
            Jam("10", "17:00"),
            Jam("11", "18:00"),
            Jam("12", "19:00"),
    )

    val jamSelesai:Array<Jam> = arrayOf(
            Jam("1", "08:00"),
            Jam("2", "09:00"),
            Jam("3", "10:00"),
            Jam("4", "11:00"),
            Jam("5", "12:00"),
            Jam("6", "13:00"),
            Jam("7", "14:00"),
            Jam("8", "15:00"),
            Jam("9", "16:00"),
            Jam("10", "17:00"),
            Jam("11", "18:00"),
            Jam("12", "19:00"),
    )

    val tujuanPenggunaan:Array<TujuanPenggunaan> = arrayOf(
            TujuanPenggunaan("1", "Belajar/Tugas Kelompok"),
            TujuanPenggunaan("2", "Bimbingan"),
            TujuanPenggunaan("3", "Diskusi"),
            TujuanPenggunaan("4", "Latihan Presentasi"),
            TujuanPenggunaan("5", "Perkuliahan Singkat"),
            TujuanPenggunaan("6", "Rapat Kerja/Panitia"),
            TujuanPenggunaan("7", "Other"),
    )
}