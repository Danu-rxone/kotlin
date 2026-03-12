package roadmap.phase1.part1

// ==============================================================================
// 🔑 KUNCI JAWABAN & PENJELASAN
// FASE 1 - PART 1: Variables & Data Types
// ==============================================================================

fun soal01_basicString_ans(): String {
    // PENJELASAN: 
    // String murni harus diapit oleh dua tanda kutip ("..."). 
    // Tipe kembalian dideklarasikan setelah titik dua `: String`.
    return "Hello Kotlin"
}

fun soal02_valDouble_ans(): Double {
    // PENJELASAN: 
    // `val` digunakan untuk variabel yang tidak bisa diubah (Immutable/Read-only).
    // Layaknya `final` dalam Java. Disini `Double` secara eksplisit ditulis.
    val pi: Double = 3.14
    return pi
}

fun soal03_varUbah_ans(): Int {
    // PENJELASAN: 
    // `var` digunakan untuk variabel yang nilainya BISA diubah (Mutable).
    // Perhatikan pada baris kedua skor diset 100 tanpa error.
    var skor = 10
    skor = 100
    return skor
}

fun soal04_booleanLebihBesar_ans(): Boolean {
    // PENJELASAN: 
    // Hasil komparasi (seperti > , < , ==, !=) secara alami mengevaluasi diri 
    // menjadi hasil akhir bertipe `Boolean` (true atau false).
    return 10 > 5
}

fun soal05_tipeChar_ans(): Char {
    // PENJELASAN: 
    // Tipe data `Char` merepresentasikan satu karakter tunggal saja.
    // Penulisannya WAJIB menggunakan tanda KUTIP SATU ( 'A' ), bukan kutip dua.
    val huruf: Char = 'A'
    return huruf
}

fun soal06_floatToInt_ans(angkaFloat: Float): Int {
    // PENJELASAN: 
    // Kotlin sangat strict mengenai perbedaan tipe numerik. 
    // Tidak ada konversi diam-diam (implicit conversion). 
    // Untuk mengubah Float ke Int wajib memanggil helper func `.toInt()`.
    return angkaFloat.toInt()
}

fun soal07_concatString_ans(): String {
    // PENJELASAN: 
    // Penggabungan manual masih bisa menggunakan operator `+`.
    return "Mobil" + " " + "Merah"
}

fun soal08_stringTemplate_ans(nama: String, umur: Int): String {
    // PENJELASAN: 
    // Best Practice Kotlin: Daripada menggunakan `+`, gunakan String Template `$`.
    // Cukup sisipkan `$nama_variable` ke dalam kutip dua. 
    // Ini menghemat memori objek berkat implementasi StringBuilder internal Kotlin.
    return "Namaku $nama, umurku $umur"
}

fun soal09_stringTemplateExpr_ans(kata: String): String {
    // PENJELASAN: 
    // Jika kita perlu memanggil Method (misal `.length`) atau melakukan kalkulasi
    // matematika, bungkus variabelnya dengan KUTIP-KURUNG-KURAWAL `${ ... }`.
    return "Panjang kata adalah ${kata.length} huruf"
}

fun soal10_logikaAnd_ans(isRegistered: Boolean, belumPunyaBuku: Boolean): Boolean {
    // PENJELASAN: 
    // Operator logika AND (&&) menghasilkan true jika dan HANYA JIKA KEDUA sisinya bernilai true.
    return isRegistered && belumPunyaBuku
}

fun soal11_logikaOr_ans(isMember: Boolean, belanja: Int): Boolean {
    // PENJELASAN: 
    // Operator logika OR (||) akan mengeksekusi dan melihat apakah SALAH SATU kondisinya true.
    // Jika kondisinya member=true, maka syarat sebelahnya tidak dicek lagi dan sistem langsung me-return true.
    return isMember || belanja > 100
}

fun soal12_logikaNot_ans(isRainy: Boolean): Boolean {
    // PENJELASAN: 
    // Operator NOT (!/Bang) membalikkan nilai. True jadi False, False jadi true.
    return !isRainy
}

fun soal13_tipeLong_ans(): Long {
    // PENJELASAN: 
    // Meskipun tidak ada koma, secara default 3 miliar dianggap melebih batas muat Int (Maks ~2.1 Miliar).
    // Menambahkan suffix / akhiran kapital (L) akan memaksa kotlin mengenalinya sebagai nilai Long (64-bit).
    return 3000000000L
}

fun soal14_stringTrim_ans(input: String): String {
    // PENJELASAN: 
    // `.trim()` meremove whitespace / jarak (termasuk \n dan tab) di AWAL dan AKHIR string. 
    // (Spasi yg berada di tengah kata tidak akan terhapus).
    return input.trim()
}

fun soal15_stringToInt_ans(input: String): Int {
    // PENJELASAN: 
    // Angka yang tersimpan di dalam bentuk tulisan teks bisa dirubah jadi Integer (bisa digunakn utk MTK nantinya).
    // Hati hati, ini akan melempar exception NumberFormatException jika teks bukan sebuah angka murni.
    return input.toInt()
}

fun soal16_rawString_ans(): String {
    // PENJELASAN: 
    // Triple Quotes (""") memungkinkan penulisan String multiline.
    // `trimIndent()` sangat krusial digunakan di akhir untuk meyakinkan space identasi putih (margin 
    // jarak dr penulisan IDE) dihapus rapi saat string dihasilkan ke output terminal.
    return """
        Baris1
        Baris2
    """.trimIndent()
}
