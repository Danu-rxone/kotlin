package roadmap.phase1.part1

import roadmap.Checker

// ==============================================================================
// 🟢 FASE 1 - PART 1: Variables & Data Types (LATIHAN) (16 Soal)
// ==============================================================================

// 1. Diberikan fungsi kosong. Kembalikan sebuah teks String "Hello Kotlin"
fun soal01_basicString(): String {
    return "Hello Kotlin"
}

// 2. Buat variabel `val` bernama `pi` bertipe Double dengan nilai 3.14. Kembalikan variabel tsb.
fun soal02_valDouble(): Double {
    return 3.14
}

// 3. Buat variabel `var` bernama `skor` dengan nilai awal 10. Ubah nilainya menjadi 100.
// Kembalikan.
fun soal03_varUbah(): Int {
    var skor = 10
    skor = 100
    return skor
}

// 4. Ekspresi Boolean sederhana. Kembalikan hasil dari (10 lebih besar dari 5).
fun soal04_booleanLebihBesar(): Boolean {
    return 10 > 5
}

// 5. Deklarasi tipe data Eksplisit. Buat variabel `huruf` bertipe `Char` berisi 'A'. Kembalikan.
fun soal05_tipeChar(): Char {
    val huruf: Char = 'A'
    return huruf
}

// 6. Konversi tipe data numerik. Diberikan `angkaFloat: Float`. Ubah menjadi `Int` dan kembalikan.
fun soal06_floatToInt(angkaFloat: Float): Int {
    return angkaFloat.toInt()
}

// 7. Penggabungan String murni dengan operator (+). Gabungkan kata "Mobil" dan "Merah" dengan
// spasi.
fun soal07_concatString(): String {
    return "Mobil" + " " + "Merah"
}

// 8. String Template. Diberikan `nama` dan `umur`. Return string "Namaku [nama], umurku [umur]".
fun soal08_stringTemplate(nama: String, umur: Int): String {
    return "Namaku $nama, umurku $umur"
}

// 9. String Template Expression. Hitung panjang karakter dari argumen `kata`.
// Return teks persis spt ini: "Panjang kata adalah [x] huruf"
fun soal09_stringTemplateExpr(kata: String): String {
    return "Panjang kata adalah ${kata.length} huruf"
}

// 10. Boolean AND (&&). Seseorang boleh minjam buku jika (isRegistered = true) DAN (belumPunyaBuku
// = true).
fun soal10_logikaAnd(isRegistered: Boolean, belumPunyaBuku: Boolean): Boolean {
    return isRegistered && belumPunyaBuku
}

// 11. Boolean OR (||). Bisa dapat diskon jika (isMember = true) ATAU (belanja > 100).
fun soal11_logikaOr(isMember: Boolean, belanja: Int): Boolean {
    return isMember || belanja > 100
}

// 12. Boolean NOT (!). Kebalikan nilai dari isRainy. Jika hujan, return false (berarti tidak bisa
// main).
fun soal12_logikaNot(isRainy: Boolean): Boolean {
    return !isRainy
}

// 13. Tipe data Long. Tambahkan L di akhir angka untuk deklarasi Long. Return angka 3 miliar
// (3000000000)
fun soal13_tipeLong(): Long {
    return 3000000000L
}

// 14. String Methods Trim. Hapus spasi berlebih di awal dan akhir teks parameter masukan.
fun soal14_stringTrim(input: String): String {
    return input.trim()
}

// 15. Konversi String ke Number. Diberikan String "123". Konversi agar menjadi Int.
fun soal15_stringToInt(input: String): Int {
    return input.toInt()
}

// 16. Multi-line / Raw String. Gunakan Triple Quotes (""")
// Buat string persis seperti ini:
// Baris1
// Baris2
// Gunakan fungsi .trimIndent() dari triple quotes tersebut!
fun soal16_rawString(): String {
    return """
    Baris1
    Baris2
    """.trimIndent()
}

// ==============================================================================
// ▶️ RUN (KOREKSI OTOMATIS)
// ==============================================================================
fun main() {
    Checker.printHeader("PART 1 - Variables & Data Types (16 Soal)")
    Checker.checkEquals("Hello Kotlin", soal01_basicString(), "Soal 1")
    Checker.checkEquals(3.14, soal02_valDouble(), "Soal 2")
    Checker.checkEquals(100, soal03_varUbah(), "Soal 3")
    Checker.checkEquals(true, soal04_booleanLebihBesar(), "Soal 4")
    Checker.checkEquals('A', soal05_tipeChar(), "Soal 5")
    Checker.checkEquals(15, soal06_floatToInt(15.9f), "Soal 6")
    Checker.checkEquals("Mobil Merah", soal07_concatString(), "Soal 7")
    Checker.checkEquals("Namaku Budi, umurku 20", soal08_stringTemplate("Budi", 20), "Soal 8")
    Checker.checkEquals(
            "Panjang kata adalah 6 huruf",
            soal09_stringTemplateExpr("Kotlin"),
            "Soal 9"
    )
    Checker.checkEquals(true, soal10_logikaAnd(true, true), "Soal 10 (True/True)")
    Checker.checkEquals(false, soal10_logikaAnd(true, false), "Soal 10 (True/False)")
    Checker.checkEquals(
            true,
            soal11_logikaOr(false, 150),
            "Soal 11 (Bukan Member, tapi Belanja 150)"
    )
    Checker.checkEquals(false, soal11_logikaOr(false, 50), "Soal 11 (Bukan Member, Belanja 50)")
    Checker.checkEquals(false, soal12_logikaNot(true), "Soal 12")
    Checker.checkEquals(3000000000L, soal13_tipeLong(), "Soal 13")
    Checker.checkEquals("Bersih", soal14_stringTrim("  Bersih \n"), "Soal 14")
    Checker.checkEquals(123, soal15_stringToInt("123"), "Soal 15")
    Checker.checkEquals("Baris1\nBaris2", soal16_rawString(), "Soal 16")
}
