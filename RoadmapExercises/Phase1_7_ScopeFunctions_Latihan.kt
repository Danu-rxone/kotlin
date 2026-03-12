package roadmap.phase1.part7

import roadmap.Checker

// ==============================================================================
// 🟢 FASE 1 - PART 7: Scope Functions (16 Soal)
// Materi: let, apply, run, also, with
// ==============================================================================

class Gadget {
    var merk: String = ""
    var memori: Int = 0
    var isNyala: Boolean = false
    override fun toString() = "$merk-$memori-$isNyala"
}

// 1. `let` Basic. Diberikan string `input`. Gunakan `.let { }` untuk mereturn panjang stringnya (length).
fun soal01_letLength(input: String): Int {
    // TODO: input.let { ... }
    return 0
}

// 2. `let` untuk Null Check (Safe Call). Diberikan `isian: String?`. 
// Jika isian TIDAK null, gunakan `?.let { }` untuk mereturn teks tersebut dicetak kapital (uppercase).
// Jika isian NULL, tangkap dengan Elvis operator `?:` untuk mereturn "KOSONG".
fun soal02_letNullCheck(isian: String?): String {
    // TODO: isian?.let { ... } ?: "KOSONG"
    return ""
}

// 3. `let` Renaming `it`. Saat menggunakan let, variabel bawaannya adalah `it`.
// Rename `it` menjadi `teks` di dalam blok let -> `.let { teks -> teks.reversed() }`.
// Return hasil membalik string tersebut (reversed).
fun soal03_letRenameIt(input: String): String {
    // TODO
    return ""
}

// 4. `apply` Basic (Inisialisasi Objek). 
// Buat objek `Gadget()`. Gunakan `.apply { }` untuk mengisi: merk="Nokia", memori=32, isNyala=true.
// Return objek tersebut.
fun soal04_applyInit(): Gadget {
    // TODO
    return Gadget()
}

// 5. Mengubah Properti menggunakan `apply`. Diberikan objek Gadget yang sudah jadi.
// Gunakan `apply` untuk murni merubah memorinya ditambah 64 (memori += 64). Return objek Gadget tsb.
fun soal05_applyUpdate(g: Gadget): Gadget {
    // TODO
    return g
}

// 6. `run` Basic. `run` mirip `apply` (context: `this`), TAPI mereturn baris terakhir (bukan objeknya).
// Diberikan objek Gadget. Gunakan `run { }` untuk mengecek: 
// Jika isNyala = true return "Hidup", else return "Mati". (Akses isNyala langsung tanpa g.isNyala).
fun soal06_runCheck(g: Gadget): String {
    // TODO
    return ""
}

// 7. `run` Tanpa Objek (Bukan Extension). `run` bisa dipanggil langsung sebagai fungsi blok.
// Buat blok `run { }`. Di dalamnya deklarasikan `val x = 10`, `val y = 20`. Return penjumlahan x+y-nya.
fun soal07_runNonExtension(): Int {
    // TODO: return run { ... }
    return 0
}

// 8. `with` Basic. Mirip fungsi `run`, tapi objeknya disuapkan lewat parameter: `with(objek) { }`.
// Kirim object Parameter 'g' ke dalam `with(g)`. Return gabungan string: "$merk bermemori $memori".
fun soal08_withGabung(g: Gadget): String {
    // TODO
    return ""
}

// 9. Return value dari `with`. 
// Gunakan `with(g)`. Hitung: Jika memori > 128 mereturn boolean true, selain itu false.
fun soal09_withCalculation(g: Gadget): Boolean {
    // TODO
    return false
}

// 10. `also` Basic (Fungsi efek samping). `also` menggunakan context `it`, mereturn objeknya.
// Diberikan array Angka. .also akan dipakai untuk mencetak/ngelog datanya.
// Lakukan `angka.also { ... }`. Di dalamnya buat variabel lokal (atau print) untuk mecatat angka.size. Return list angka.
fun soal10_alsoLog(angka: List<Int>): List<Int> {
    // TODO
    return angka
}

// 11. `also` Renaming. Ubah `it` menjadi `data` saat mengggunakan also: `.also { data -> ... }`.
// Isi list 'data' dengan elemen baru "Z" (data.add("Z") atau jika immutable jadikan mutable, tunggu intruksi array list)
// Karena ini MutableList, CUKUP lakukan `.also { data -> data.add("Z") }` saja ke param list tsb, lalu Return as MutableList.
fun soal11_alsoAction(listStrings: MutableList<String>): MutableList<String> {
    // TODO
    return listStrings
}

// 12. Chaining Scope Functions (let & apply).
// Diberikan string nullable `nama?`.  Jika tidak null ( ?.let ),
// di dalam let -> Buat Gadget().apply { merk = it(dari string atas) }. 
// (Karena let pakai 'it' dan apply pakai 'this', tidak akan tabrakan).
// Paling akhir beri `?: Gadget()` jika nama null.
fun soal12_chainLetApply(nama: String?): Gadget {
    // TODO
    return Gadget()
}

// 13. Scope `takeIf`. Ini mirip filter. Diberikan angka. 
// return angka.takeIf { it > 50 }. Jika angka <= 50, akan mengembalikan null (jadi safe pass buat Elvis).
// Tangkap kembalian yg null dg Elvis `?: -1`.
fun soal13_takeIf(angka: Int): Int {
    // TODO
    return 0
}

// 14. Scope `takeUnless`. Kebalikan `takeIf`. 
// return input.takeUnless { it.isEmpty() }. Jika kosong (empty=true) dia jd null.
// Gunakan elvis `?: "Kosong"` jika tangkapannya null.
fun soal14_takeUnless(input: String): String {
    // TODO
    return ""
}

// 15. Kapan pakai Apply vs Also? 
// Jika mengedit/inisialisasi property objek -> Pakai `apply` (`this.merk=..`).
// Jika mempassing/ngelempar objek ke fungsi lain tanpa mengubah konteks -> Pakai `also` (`CetakLogger(it)`).
// Buat Gadget, .apply { merk="Samsung" }.also { /* pura-pura ngeprint it.merk */ }. Return gadgetnya.
fun soal15_applyAlsoCombination(): Gadget {
    // TODO
    return Gadget()
}

// 16. The "it" and "this" mapping quiz. (Konseptual diwujudkan dalam Code).
// Function A (let)  -> mereferensi arg via: "it", kembalian: "Lambda Result"
// Function B (apply)-> mereferensi arg via: "this", kembalian: "Object it self"
// Coba gunakan kombinasi blok untuk menghasilkan "it-this" sebagai string literal return dari blok run di bawah:
// run {  Input "X".let { ... } // di dlm let return teks "it" jika parameter let dpt akses. }
// Intinya: kembalikan string murni persis berikut "let=it,apply=this" !
fun soal16_quizMengingat(): String {
    return "let=it,apply=this"
}

// ===================================
// ▶️ RUN
// ===================================
fun main() {
    Checker.printHeader("PART 7 - Scope Functions (16 Soal)")
    Checker.checkEquals(4, soal01_letLength("Buku"), "Soal 1")
    Checker.checkEquals("KOSONG", soal02_letNullCheck(null), "Soal 2 (Null)")
    Checker.checkEquals("KOTLIN", soal02_letNullCheck("kotlin"), "Soal 2 (Not Null)")
    Checker.checkEquals("cba", soal03_letRenameIt("abc"), "Soal 3")
    Checker.checkEquals("Nokia-32-true", soal04_applyInit().toString(), "Soal 4")
    Checker.checkEquals("A-164-false", soal05_applyUpdate(Gadget().apply{merk="A";memori=100}).toString(), "Soal 5")
    val g1 = Gadget().apply{isNyala = true}; val g2 = Gadget().apply{isNyala = false}
    Checker.checkEquals("Hidup", soal06_runCheck(g1), "Soal 6 (Hidup)")
    Checker.checkEquals("Mati", soal06_runCheck(g2), "Soal 6 (Mati)")
    Checker.checkEquals(30, soal07_runNonExtension(), "Soal 7")
    Checker.checkEquals("Vivo bermemori 128", soal08_withGabung(Gadget().apply{merk="Vivo";memori=128}), "Soal 8")
    Checker.checkEquals(true, soal09_withCalculation(Gadget().apply{memori=256}), "Soal 9")
    Checker.checkEquals(listOf(1,2,3), soal10_alsoLog(listOf(1,2,3)), "Soal 10")
    val mutList = mutableListOf("A")
    Checker.checkEquals(listOf("A", "Z"), soal11_alsoAction(mutList), "Soal 11")
    Checker.checkEquals("Oppo-0-false", soal12_chainLetApply("Oppo").toString(), "Soal 12")
    Checker.checkEquals("-1-0-false", soal12_chainLetApply(null).toString(), "Soal 12 (Elvis)")
    Checker.checkEquals(100, soal13_takeIf(100), "Soal 13 (Lolos)")
    Checker.checkEquals(-1, soal13_takeIf(40), "Soal 13 (Gagal/Elvis)")
    Checker.checkEquals("Ada", soal14_takeUnless("Ada"), "Soal 14")
    Checker.checkEquals("Kosong", soal14_takeUnless(""), "Soal 14 (Kosong/Elvis)")
    Checker.checkEquals("Samsung", soal15_applyAlsoCombination().merk, "Soal 15")
    // Note: Soal 12 pada null ekspectasikan empty Gadget merk="" bukan null, sehingga Stringnya memori 0 dll
}
