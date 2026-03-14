package roadmap.phase1.part2

import roadmap.Checker

// ==============================================================================
// 🟢 FASE 1 - PART 2: Control Flow (17 Soal)
// ==============================================================================

// 1. Diberikan angka. Jika > 0, return "Positif". Jika tidak, return "Negatif/Nol".
fun soal01_ifElse(angka: Int): String {
    // if (anga > 0) {
    //     return "Positif"
    // } else {
    //     return "Negatif/Nol"
    // }
    return angka.takeIf { it > 0 }?.let { "Positif" } ?: "Negatif/Nol"
}

// 2. Refactor fungsi di atas menggunakan if-expression (fungsi satu baris dengan '=')
fun soal02_ifExpr(angka: Int): String = if (angka > 0) "Positif" else "Negatif/Nol"

// 3. Tiga kondisi: > 0 ("Positif"), < 0 ("Negatif"), == 0 ("Nol").
fun soal03_ifElseIf(angka: Int): String {
    return when {
        angka > 0 -> "Positif"
        angka < 0 -> "Negatif"
        else -> "Nol"
    }

    // return angka.takeIf { it > 0 }?.let { "Positif" }
    //         ?: angka.takeIf { it < 0 }?.let { "Negatif" } ?: "Nol"
}

// 4. Nested IF. Jika isWeekend = true, cek isRaining. Jika isRaining = true (return "Tidur"), false
// ("Main"). Jika isWeekend = false (return "Kerja")
fun soal04_nestedIf(isWeekend: Boolean, isRaining: Boolean): String {
    // return when {
    //     isWeekend && isRaining -> "Tidur"
    //     isWeekend && !isRaining -> "Main"
    //     else -> "Kerja"
    // }
    return when {
        isWeekend ->
                when {
                    isRaining -> "Tidur"
                    else -> "Main"
                }
        else -> "Kerja"
    }
}

// 5. Cek dua string apakah sama (equals / ==). Jika sama -> true. Beda -> false.
fun soal05_stringEquals(str1: String, str2: String): Boolean {
    return str1 === str2
}

// 6. When Paling Sederhana. Angka 1 -> "Satu", 2 -> "Dua", selain itu -> "Banyak"
fun soal06_whenSimple(angka: Int): String {
    when (angka) {
        1 -> return "Satu"
        2 -> return "Dua"
        else -> return "Banyak"
    }
}

// 7. When Banyak Nilai Sekaligus Koma. Jika angka 1, 3, 5 -> "Ganjil", 2, 4, 6 -> "Genap", else ->
// "Lainnya"
fun soal07_whenComma(angka: Int): String {
    when (angka) {
        1, 3, 5 -> return "Ganjil"
        2, 4, 6 -> return "Genap"
        else -> return "Lainnya"
    }
}

// 8. When Range. Jika angka dalam rentang (in) 1 sampai 10 -> "Kecil", 11 sampai 20 -> "Sedang",
// else -> "Besar"
fun soal08_whenRange(angka: Int): String {
    when (angka) {
        in 1..10 -> return "Kecil"
        in 11..20 -> return "Sedang"
        else -> return "Besar"
    }
}

// 9. When Bukan Di Range(!in). Jika x BUKAN rentang 1..100, return "Invalid". Jika di rentang,
// return "Valid"
fun soal09_whenNotIn(x: Int): String {
    when (x) {
        !in 1..100 -> return "Invalid"
        else -> return "Valid"
    }
}

// 10. When Expression. Gabung dengan '=' (sama dengan). Return string langsung berdasar boolean
// isLapar. True->"Makan", False->"Kenyang"
fun soal10_whenExpr(isLapar: Boolean): String =
        when (isLapar) {
            true -> "Makan"
            false -> "Kenyang"
        }

// 11. When Type Checks (is). Parameter arg: Any. Jika Int -> "Angka", jika String -> "Teks", jika
// Boolean -> "Bool"
fun soal11_whenIs(arg: Any): String {
    when (arg) {
        is Int -> return "Angka"
        is String -> return "Teks"
        is Boolean -> return "Bool"
        else -> return "Tidak Diketahui"
    }
}

// 12. Smart Cast. Jika arg `is String`, kembalikan panggil `.length`-nya String tersebut. Else
// return 0.
fun soal12_smartCast(arg: Any): Int {
    when (arg) {
        is String -> return arg.length
        else -> return 0
    }
}

// 13. When tanpa argumen. Cek kondisi umur > 17 dan ktp == true -> "Dewasa". umur > 17 ktp == false
// -> "Bikin KTP". Else -> "Anak"
fun soal13_whenNoArgs(umur: Int, ktp: Boolean): String {
    when {
        umur > 17 && ktp -> return "Dewasa"
        umur > 17 && !ktp -> return "Bikin KTP"
        else -> return "Anak"
    }
}

// 14. If majemuk AND (&&). Jika jam >= 8 DAN jam <= 16 -> true (Jam Kerja), Else -> false
fun soal14_jamKerja(jam: Int): Boolean {
    if (jam >= 8 && jam <= 16) return true else return false
}

// 15. If majemuk OR (||). Jika isDiscount = true ATAU total > 100 -> bayar total - 20. Else bayar
// total.
fun soal15_diskon(isDiscount: Boolean, total: Int): Int {
    if (isDiscount || total >= 100) return (total - 20) else return total
}

// 16. Returning inside When. Hitung pajak.
// Jika kategori "A" -> return gaji * 10% (.1). "B" -> gaji * 5% (.05). Else -> 0.
fun soal16_pajak(gaji: Double, kategori: String): Double {
    when (kategori) {
        "A" -> return gaji * 0.1
        "B" -> return gaji * 0.05
        else -> return 0.0
    }
}

// 17. Block di dalam When. Jika x == 1, print("Halo") lalu return "Satu". Else return "Bukan"
fun soal17_whenBlock(x: Int): String {
    when (x) {
        1 -> {
            println("Halo")
            return "Satu"
        }
        else -> return "Bukan"
    }
}

// ===================================
// ▶️ RUN
// ===================================
fun main() {
    Checker.printHeader("PART 2 - Control Flow If/When (17 Soal)")
    Checker.checkEquals("Positif", soal01_ifElse(10), "Soal 1")
    Checker.checkEquals("Negatif/Nol", soal01_ifElse(-5), "Soal 1b")
    Checker.checkEquals("Positif", soal02_ifExpr(10), "Soal 2")
    Checker.checkEquals("Nol", soal03_ifElseIf(0), "Soal 3")
    Checker.checkEquals("Tidur", soal04_nestedIf(true, true), "Soal 4 (Weekend, Rain)")
    Checker.checkEquals("Kerja", soal04_nestedIf(false, true), "Soal 4 (Not Weekend)")
    Checker.checkEquals(true, soal05_stringEquals("Kotlin", "Kotlin"), "Soal 5")
    Checker.checkEquals("Dua", soal06_whenSimple(2), "Soal 6")
    Checker.checkEquals("Ganjil", soal07_whenComma(3), "Soal 7")
    Checker.checkEquals("Sedang", soal08_whenRange(15), "Soal 8")
    Checker.checkEquals("Invalid", soal09_whenNotIn(200), "Soal 9")
    Checker.checkEquals("Makan", soal10_whenExpr(true), "Soal 10")
    Checker.checkEquals("Teks", soal11_whenIs("Halo"), "Soal 11")
    Checker.checkEquals(4, soal12_smartCast("ABCD"), "Soal 12")
    Checker.checkEquals("Bikin KTP", soal13_whenNoArgs(18, false), "Soal 13")
    Checker.checkEquals(true, soal14_jamKerja(10), "Soal 14")
    Checker.checkEquals(80, soal15_diskon(false, 100), "Soal 15 (Tidak diskon pas 100)")
    Checker.checkEquals(180, soal15_diskon(true, 200), "Soal 15 (Diskon besar)")
    Checker.checkEquals(50.0, soal16_pajak(500.0, "A"), "Soal 16")
    Checker.checkEquals("Satu", soal17_whenBlock(1), "Soal 17")
}
