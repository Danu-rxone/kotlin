package roadmap.phase1.part4

// ==============================================================================
// 🔑 KUNCI JAWABAN & PENJELASAN
// FASE 1 - PART 4: Functions & Null Safety
// ==============================================================================

fun soal01_multiplication_ans(x: Int, y: Int): Int {
    // PENJELASAN:
    // Deklarasi fungsi standar Kotlin dimulai dengan fun.
    // Argument yang sudah dipassing bersifat 'val', sehingga x dan y tidak bisa di assign ulang.
    return x * y
}

fun soal02_defaultArg_ans(nama: String, bahasa: String = "Kotlin"): String {
    // PENJELASAN:
    // Default argument dideklarasikan dengan `param: Tipe = DefaultValue`.
    // Membantu mengurangi kebiasaan membuat method overloading berlebihan di Java.
    // Jika caller mengosongi parameter ini, "Kotlin" akan langsung menyelinap dipakai.
    return "$nama belajar $bahasa"
}

fun soal03_namedArg_ans(): String {
    // PENJELASAN:
    // Named Argument memungkinkan kita mempassing data secara OUT-OF-ORDER (tidak urut).
    // Memudahkan caller tanpa takut terbalik memasukkan string password di parameter username dan sebaliknya.
    return mockFunc(c = 3, b = 2, a = 1)
}

// PENJELASAN SOAL 4:
// Single-Expression Function membuang kurung kurawal `{ }` dan `return` untuk dialihkan langsung menggunakan tanda sama dengan `=`.
// Tipe kembalian (ex: Int) juga boleh ikut dihapus karena ada "Type Inference" dr Kotlin yg sudah tahu string.length pasti mnghslkan Int.
fun soal04_singleExpr_ans(teks: String): Int = teks.length

fun soal05_vararg_ans(vararg numbers: Int): Int {
    // PENJELASAN:
    // `vararg` membungkus banyak arguments seakan akan menjadi Array (seperti varargs `int... args`  di Java).
    // Pemanggilannya bisa bebas panjang `sum(1, 2)` atau `sum(1, 2, 3, 4, 5)`.
    return numbers.sum() 
}

fun soal06_nullableType_ans(): String? {
    // PENJELASAN:
    // Menambahkan Tanda Tanya `?` pada tipe data menjadikannya Nullable 
    // (Bisa mereferensikan null, bukan cuma nilai pasti).
    return null
}

fun soal07_nullIf_ans(nama: String?): String {
    // PENJELASAN:
    // Null safety pengecekan IF manual seperti era Java.
    // Tipe `nama` adalah String? tapi karena difilter manual, bagian else compiler sadar `nama` PASTI BUKAN NULL.
    if (nama == null) return "Tanpa Nama"
    else return nama
}

fun soal08_safeCall_ans(pass: String?): Int? {
    // PENJELASAN:
    // Pengganti terbaik if=null. Safe Call Operator `?.` hanya akan memangil method (misal length)
    // JIKA obj bukan null. Jike ia null, SEMUA EVALUASI DIMATIKAN dan me-return literal `null`.
    return pass?.length
}

fun soal09_elvis_ans(pass: String?): Int {
    // PENJELASAN:
    // Elvis Operator `?:` menyediakan "Fallback/Default Value".
    // Ia membackup hasil Safe Call `?.` di atas yang masih mentah (Int?). 
    // Bila `pass?.length` meletus null, Elvis akan menggantinya jdi 0, shingga hasil akhirnya dijamin bersih dr null (Int Murni).
    return pass?.length ?: 0
}

fun soal10_forceNull_ans(pass: String?): Int {
    // PENJELASAN:
    // Not-Null Assertion Operator `!!`.
    // Sintaks ini memaksa "BODO AMAT SAYA YAKIN INI NGGAK NULL. BYPASS SEMUA PERINGATAN! PANGGIL LENGTHNYA".
    // Jika pass kebetulan null, aplikasi anda akan langsung menemui azab (NullPointerException Crash).
    return pass!!.length
}

fun soal11_extension_ans(teks: String): Char {
    // PENJELASAN:
    // Extension function. Kita seolah olah "Menginjeksi" fungsi hurufTerakhir() ke dalam source code 
    // class String milik Kotlin. Sehingga tiap String dpt memakai kemampuan baru ini tanpa membuat class Utils (mirip C# params var).
    return teks.hurufTerakhir()
}

fun soal12_smartCastLagi_ans(data: Any?): Int {
    // PENJELASAN:
    // When dikombinasikan dengan pengecekan `is String` dll. Sesudah condition checked dan masuk body ->
    // Kotlin paham (Smartcast) bahwa saat di bris tsb tipenya adalah Int/String yg mana ia bs dimatikalisasikan/dilength kan.
    return when(data) {
        null -> -1
        is Int -> data * 10
        is String -> data.length
        else -> -1
    }
}

fun soal13_unitReturn_ans(): Unit {
    // PENJELASAN:
    // Unit berarti fungsi ini mengevaluasi tanpa return useful data. (Mirip Void).
    // Bedanya di memori ia benar benar object Unit instance (Punya address memory), tidak seperti `void` yg completely hampa.
    println("Halo")
}

fun soal14_nested_ans(input: Int): Int {
    // PENJELASAN:
    // Mendefinisikan class/method sementara secara private di function dlm scope fungsi lain.
    // Agar fngsi pembantu tdk tercampur dgn util global.
    fun double(n: Int) = n * 2
    return double(input)
}

fun soal15_higherOrder_ans(operation: (Int) -> Int): Int {
    // PENJELASAN:
    // Higher Order Function: Fungsi yang menerima ATAU MENGEMBALIKAN FUNGSI LAIN (sebagai parameter).
    // Method di parameter ditangani sbg Object (First Class Citizen)
    return operation(10)
}

fun soal16_callLambda_ans(): Int {
    // PENJELASAN:
    // Jika parameter TERAKHIR sebuah func adalah Function, kita bisa mendorong lambda block (kurung kurawal { }) 
    // keluar dari tanda kurung fungsinya (Trailing Lambda Syntax).
    return soal15_higherOrder { it + 5 }
    // atau jika dimasukn dalam krung bisa: soal15_higherOrder( { i -> i + 5 } )
}
