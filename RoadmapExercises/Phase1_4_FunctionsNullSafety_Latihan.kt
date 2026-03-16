package roadmap.phase1.part4

import roadmap.Checker

// ==============================================================================
// 🟢 FASE 1 - PART 4: Functions & Null Safety (16 Soal)
// ==============================================================================

// 1. Function Biasa. Buat fungsi perkalian. Kalikan X dan Y. (Anda tidak boleh mengubah parameter).
fun soal01_multiplication(x: Int, y: Int): Int {
    return x * y
}

// 2. Default Arguments. Isi parameter `bahasa` dengan default value "Kotlin".
fun soal02_defaultArg(nama: String, bahasa: String = "Kotlin"): String {
    return "$nama belajar $bahasa"
}

// 3. Named Arguments. Fungsi bawaan: func(a: Int, b: Int, c: Int).
// Kembalikan PANGGILAN FUNGSI di bawah tersebut dengan mendahulukan memasukkan C = 3, lalu B = 2, A
// = 1 ke input.
fun mockFunc(a: Int, b: Int, c: Int) = "$a$b$c"

fun soal03_namedArg(): String {
    return mockFunc(c = 3, b = 2, a = 1)
}

// 4. Single-Expression Function. Hapus kurung kurawal, dan jadikan fungsi satu baris dengan `=`.
fun soal04_singleExpr(teks: String): Int = teks.length

// 5. Vararg. Fungsi bisa menerima data list/array bebas menggunakan keyword `vararg`.
// Jumlahkan SEMUA angka dari `numbers` tersebut, dan kembalikan angkanya. (bisa pakai perulangan
// atau method bawaan return numbers.sum())
fun soal05_vararg(vararg numbers: Int): Int {
    return numbers.sum()
}

// 6. Nullable Type Declaration. Tipe data normal tidak bisa diisi null.
// Ubah signature kembalian fungsi ini dari `String` DARI FUNGSINYA (di kanan kurung) menjadi
// `String?`! LALU return null murni
fun soal06_nullableType(): String? {
    return null
}

// 7. Pengecekan Null Klasik (If-Else). Jika masukan `nama` null, return "Tanpa Nama". Jika tidak
// return namanya.
fun soal07_nullIf(nama: String?): String {
    if (nama == null) {
        return "Tanpa Nama"
    } else {
        return nama
    }
}

// 8. Safe Call Operator `?.`. Kembalikan panjang dari password input (jika String). Jika inputan
// null, KEMBALIKAN NULL (Int?).
// DILARANG PAKAI IF ELSE. Harus menggunakan safe call pass?.length
fun soal08_safeCall(pass: String?): Int? {
    return pass?.length
}

// 9. Elvis Operator `?:`. Lanjutan soal di atas. Cari len dar password.
// TAPI Jika null tangkap sebagai angka 0. (Int). DILARANG pakai if else.
fun soal09_elvis(pass: String?): Int {
    return pass?.length ?: 0
}

// 10. Not-Null Assertion Operator `!!`. (Hati-hati, jika obj null maka akan force crash).
// Diberikan parameter non-null. Cobalah paksa pemanggilan fungsi ini menggunakan obj!!.length
// Asumsikan data yang lewat PASTI selamanya tidak pernah null, sehingga kita berani.
fun soal10_forceNull(pass: String?): Int {
    return pass!!.length
}

// 11. Extension Functions. Kita bisa membuat sub-fungsi tempelan untuk Kelas yg sudah ada (seperti
// String).
// Fungsi `String.hurufTerakhir()` akan dibuat.
// TUGAS ANDA: Panggil ekstensi `.hurufTerakhir()` pada argumen teks tersebut dan return karakter
// hasilnya!
fun String.hurufTerakhir(): Char = this[this.length - 1]

fun soal11_extension(teks: String): Char {
    return teks.hurufTerakhir()
}

// 12. Smart Cast lanjutan.
// Jika data adalah null, return -1. Jika data bertipe Int, kalikan 10. Jika String, kembalikan
// length-nya.
fun soal12_smartCastLagi(data: Any?): Int {
    return when (data) {
        null -> -1
        is Int -> data * 10
        is String -> data.length
        else -> -1
    }
}

// 13. Unit Returning. Fungsi default jika void/tidak mengembalikan apapun maka tipenya otomatis
// `Unit`.
// Fungsi ini haruslah ber-return type eksplisit `Unit` di parameter method dan memiliki isian
// bebas, misalnya `println()`.
fun soal13_unitReturn() {
    println("Hello")
}

// 14. Nested Function. Sebuah fungsi dideklarasikan di DALAAM tubuh fungsi lain.
// 1. Buat local function `fun double(n: Int) = n * 2` persis ditengah fungsi ini.
// 2. Panggil local function double() ke input var input, assign ke val x. lalu return angkanya

fun double(n: Int) = n * 2

fun soal14_nested(input: Int): Int {
    return double(input)
}

// 15. Higher Order Function sederhana.
// Menerima input bertipe fungsi `operation: (Int) -> Int`.
// Terapkan fungsi tersebut pada angka 10 dan kembalikan hasilnya. (Panggil `operation(10)`)

fun soal15_higherOrder(operation: (Int) -> Int): Int {
    return operation(10)
}

// 16. Anonymous Function / Lambda (Penggunaannya).
// Untuk bisa memanggil Soal 15, kita bisa mengirim Lambda expression.
// Cukup panggil `soal15_higherOrder` di dalam TODO block, dan PASS LAMBDA ke dalamnya
// `soal15_higherOrder { it + 5 }`.
fun soal16_callLambda(): Int {
    return soal15_higherOrder { it + 5 }
}

// ===================================
// ▶️ RUN
// ===================================
fun main() {
    Checker.printHeader("PART 4 - Functions & Null Safety (16 Soal)")
    Checker.checkEquals(50, soal01_multiplication(10, 5), "Soal 1")
    Checker.checkEquals("Ali belajar Kotlin", soal02_defaultArg("Ali", "Kotlin"), "Soal 2")
    Checker.checkEquals("123", soal03_namedArg(), "Soal 3 (123 terurut)")
    Checker.checkEquals(4, soal04_singleExpr("Test"), "Soal 4")
    Checker.checkEquals(10, soal05_vararg(1, 2, 3, 4), "Soal 5 (Sum Vararg)")
    Checker.checkEquals(null, soal06_nullableType(), "Soal 6 (Bisa simpan Null)")
    Checker.checkEquals("Tanpa Nama", soal07_nullIf(null), "Soal 7")
    Checker.checkEquals(null, soal08_safeCall(null), "Soal 8 (Return nullable proper)")
    Checker.checkEquals(3, soal08_safeCall("123"), "Soal 8")
    Checker.checkEquals(0, soal09_elvis(null), "Soal 9 (Elvis jika Null = 0)")
    Checker.checkEquals(5, soal10_forceNull("Hello"), "Soal 10")
    Checker.checkEquals('o', soal11_extension("Halo"), "Soal 11 (Extension Function)")
    Checker.checkEquals(100, soal12_smartCastLagi(10), "Soal 12")
    Checker.checkEquals(4, soal12_smartCastLagi("Test"), "Soal 12")
    Checker.checkEquals(-1, soal12_smartCastLagi(null), "Soal 12")
    val res13 = soal13_unitReturn() // akan bertipe Unit, dicek reflection
    Checker.checkEquals(Unit, res13, "Soal 13 (Memang unit)")
    Checker.checkEquals(20, soal14_nested(10), "Soal 14")
    Checker.checkEquals(15, soal16_callLambda(), "Soal 15 & 16 (Lambda 10 + 5)")
}
