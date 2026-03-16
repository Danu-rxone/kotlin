package roadmap.phase1.part3

import roadmap.Checker

// ==============================================================================
// 🟢 FASE 1 - PART 3: Loops (16 Soal)
// ==============================================================================

// 1. Diberikan for loop dari 1 sampai 5 (inklusif). Return total penjumlahannya. (1+2+3+4+5)
fun soal01_forRange(): Int {
    var sum = 0
    for (i in 1..5) {
        sum += i
    }
    return sum
}

// 2. Gunakan `until`. Diberikan `n = 5`. Return bilangan dari 0 hingga SEBELUM 5 sebagai string
// dipisah spasi ("0 1 2 3 4").
fun soal02_forUntil(n: Int): String {
    var result = ""
    for (i in 0 until n) {
        result += "$i "
    }
    return result.trim()
}

// 3. For loop turun (downTo). Dari 10 ke 1. Kumpulkan angkanya di dalam list lalu return list-nya.
fun soal03_forDownTo(): List<Int> {
    val list = mutableListOf<Int>()
    for (i in 10 downTo (1)) list.add(i)
    return list
}

// 4. For loop turun dengan lompatan 2 (step 2). Mulai 10, berakhir 0. Return sebagai List.
fun soal04_forStep(): List<Int> {
    val list = mutableListOf<Int>()
    for (i in 10 downTo (0) step (2)) list.add(i)
    return list
}

// 5. Looping melalui isi List. Diberikan list ["A", "B", "C"]. Return berupa gabungan string "ABC".
fun soal05_forInList(items: List<String>): String {
    var combined = ""
    for (item in items) {
        combined += item
    }
    return combined
}

// 6. Looping menggunakan index list. (`for (i in items.indices)`).
// Jika index adalah genap (i % 2 == 0), tambahkan elemen tersebut ke `hasil`.
fun soal06_forIndices(items: List<String>): String {
    var hasil = ""
    for (i in items.indices) {
        if (i % 2 == 0) hasil += items[i]
    }
    return hasil
}

// 7. Looping list dengan index sekaligus value (withIndex).
// Pisahkan index dan value dari iterasi list ( `for ((index, value) in items.withIndex())` )
// Kembalikan dalam format string "$index:$value " berjejer.
fun soal07_forWithIndex(items: List<String>): String {
    var hasil = ""
    for ((index, value) in items.withIndex()) {
        hasil += "$index:$value "
    }
    return hasil.trim()
}

// 8. While Loop. Tambahkan nilai `count` ke `sum` secara berulang selama `count <= 5`.
fun soal08_whileLoop(): Int {
    var sum = 0
    var count = 1
    while (count <= 5) {
        sum += count
        count++
    }
    return sum
}

// 9. While dengan pengurangan. Sebuah tangki air berisi 100 liter.
// Selama air > 0, kurangi 25 liter. Berapa kali pengurangan yang dilakukan hingga air habis? Return
// angkanya.
fun soal09_whileMinus(): Int {
    var air = 100
    var kaliBerkurang = 0
    while (air > 0) {
        air -= 25
        kaliBerkurang += 1
    }
    return kaliBerkurang
}

// 10. Do-While. Nilai awal `x = 10`. Kurangkan `x` dengan 5, LALU cek `while(x > 10)`. (Return x).
// Ini untuk membuktikan Do-While dieksekusi min. 1 kali. Valuenya pasti 5 di akhir.
fun soal10_doWhile(): Int {
    var x = 10
    do {
        x -= 5
    } while (x > 10)
    return x
}

// 11. Break. Looping angka 1 sampai 10. Jika i == 4, tembak "break".
// Simpan semua angka yang sempat diloop ke dalam List sebelum terkena break.
fun soal11_break(): List<Int> {
    val list = mutableListOf<Int>()
    for (i in 1..10) {
        if (i == 4) break
        list.add(i)
    }
    return list
}

// 12. Continue. Looping angka 1 sampai 5. Jika i == 3, tembak "continue".
// Simpan sisanya ke dalam List. (Harusnya [1,2,4,5])
fun soal12_continue(): List<Int> {
    val list = mutableListOf<Int>()
    for (i in 1..5) {
        if (i == 3) continue
        list.add(i)
    }
    return list
}

// 13. Nested Loop. Buat papan catur 2x2. Baris i dari 1..2. Kolom j dari 1..2.
// Catat ke format "($i,$j)" misal "(1,1)(1,2)(2,1)(2,2)". Return teksnya.
fun soal13_nestedLoop(): String {
    var papan = ""
    for (i in 1..2) {
        for (j in 1..2) {
            papan += "($i,$j)"
        }
    }
    return papan
}

// 14. Labeled Break. Diberikan nested loop i = 1..3 dan j = 1..3.
// Jika i==2 dan j==2, hancurkan KEDUA loop menggunakan label (contoh `loopUtama@`).
// Return hasil perhitungan berapa kali loop j tereksekusi sebelum mati.
fun soal14_labeledBreak(): Int {
    var hitung = 0
    loopUtama@ for (i in 1..3) {
        for (j in 1..3) {
            if (i == 2 && j == 2) {
                break@loopUtama
            }
            hitung++
        }
    }
    return hitung
}

// 15. Labeled Continue. Lompati sisa iterasi J (lanjutkan iterasi loop luar / I berikutnya)
// jika j == 2. (i=1..2, j=1..3). Gabungkan "(i:j)" ke total string.
fun soal15_labeledContinue(): String {
    var result = ""
    for (i in 1..2) {
        loopJ@ for (j in 1..3) {
            if (j == 2) continue@loopJ
            result += "($i:$j)"
        }
    }
    return result
}

// 16. Repeat. Gunakan block `repeat(n) { ... }` untuk loop n kali.
// Diberikan parameter 'n'. Tambahkan huruf "X" ke kotak teks sebanyak n kali lipat.
fun soal16_repeatLoop(n: Int): String {
    var kotak = ""
    repeat(n) { kotak += "X" }
    return kotak
}

// ===================================
// ▶️ RUN
// ===================================
fun main() {
    Checker.printHeader("PART 3 - Loops (16 Soal)")
    Checker.checkEquals(15, soal01_forRange(), "Soal 1")
    Checker.checkEquals("0 1 2 3 4", soal02_forUntil(5), "Soal 2")
    Checker.checkEquals(listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), soal03_forDownTo(), "Soal 3")
    Checker.checkEquals(listOf(10, 8, 6, 4, 2, 0), soal04_forStep(), "Soal 4")
    Checker.checkEquals("ABC", soal05_forInList(listOf("A", "B", "C")), "Soal 5")
    Checker.checkEquals("AC", soal06_forIndices(listOf("A", "B", "C")), "Soal 6")
    Checker.checkEquals("0:X 1:Y", soal07_forWithIndex(listOf("X", "Y")), "Soal 7")
    Checker.checkEquals(15, soal08_whileLoop(), "Soal 8")
    Checker.checkEquals(4, soal09_whileMinus(), "Soal 9 (100 / 25 = 4)")
    Checker.checkEquals(5, soal10_doWhile(), "Soal 10")
    Checker.checkEquals(listOf(1, 2, 3), soal11_break(), "Soal 11 (Sempat print sd 3)")
    Checker.checkEquals(listOf(1, 2, 4, 5), soal12_continue(), "Soal 12")
    Checker.checkEquals("(1,1)(1,2)(2,1)(2,2)", soal13_nestedLoop(), "Soal 13")
    Checker.checkEquals(4, soal14_labeledBreak(), "Soal 14 (1x3 + elemen pertama i=2)")
    Checker.checkEquals("(1:1)(1:3)(2:1)(2:3)", soal15_labeledContinue(), "Soal 15")
    Checker.checkEquals("XXX", soal16_repeatLoop(3), "Soal 16")
}
