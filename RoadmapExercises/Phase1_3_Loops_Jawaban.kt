package roadmap.phase1.part3

// ==============================================================================
// 🔑 KUNCI JAWABAN & PENJELASAN
// FASE 1 - PART 3: Loops (For, While, Do-While)
// ==============================================================================

fun soal01_forRange_ans(): Int {
    // PENJELASAN:
    // Looping menggunakan `for (item in range)`. Range dengan titik dua (..) bersifat INCLUSIVE.
    // Artinya angka 5 akan ikut dihitung (1, 2, 3, 4, 5).
    var sum = 0
    for (i in 1..5) sum += i
    return sum
}

fun soal02_forUntil_ans(n: Int): String {
    // PENJELASAN:
    // Keyword `until` membuat range bersifat EXCLUSIVE diujung akhir.
    // `0 until 5` artinya angka 5 TIDAK akan disentuh, array mentok di (0, 1, 2, 3, 4).
    var result = ""
    for (i in 0 until n) {
        result += "$i "
    }
    return result.trim()
}

fun soal03_forDownTo_ans(): List<Int> {
    // PENJELASAN:
    // Keyword `downTo` digunakan untuk looping mundur mundur dari angka bersar ke kecil.
    // Jika ditulis `for(i in 10..1)` Kotlin akan DIAM SAJA dan tidak merun loopnya sama sekali, karena sintaksnya salah.
    val list = mutableListOf<Int>()
    for (i in 10 downTo 1) list.add(i)
    return list
}

fun soal04_forStep_ans(): List<Int> {
    // PENJELASAN:
    // Keyword `step` digunakan untuk mengatur kelipatan/loncatan interasi.
    // Loop dari 10 turun 0 tetapi melompat sejauh 2 langkah tiap siklusnya (10, 8, 6 ... )
    val list = mutableListOf<Int>()
    for (i in 10 downTo 0 step 2) list.add(i)
    return list
}

fun soal05_forInList_ans(items: List<String>): String {
    // PENJELASAN:
    // Sama halnya looping Python (for item in list) atau Java (for(String i : arr)).
    // Kita menelusuri tiap element dalam Collection tanpa mempedulikan nomor indexnya.
    var combined = ""
    for (item in items) {
        combined += item
    }
    return combined
}

fun soal06_forIndices_ans(items: List<String>): String {
    // PENJELASAN:
    // Menggunakan `.indices` memberikan kita array Number yg memuat ukuran persis koleksi tersebut (mirip i=0; i<length; i++).
    // Digunakan kalau kita peduli dengan INDEX lokasi data tsb sedang ditelusuri.
    var hasil = ""
    for (i in items.indices) {
        if (i % 2 == 0) {
            hasil += items[i]
        }
    }
    return hasil
}

fun soal07_forWithIndex_ans(items: List<String>): String {
    // PENJELASAN:
    // Kalau butuh KEDUANYA (index dan value) pakai fitur `.withIndex()`.
    // Destructuring `(index, value)` membongkar data sehingga variabel i/val siap disisipkan tanpa perlu memanggil `items[index]` lagi.
    var hasil = ""
    for ((index, value) in items.withIndex()) {
        hasil += "$index:$value "
    }
    return hasil.trim()
}

fun soal08_whileLoop_ans(): Int {
    // PENJELASAN:
    // `while` akan mengevaluasi kondisi DI AWAL. Jika kondisi saat itu bernilai true,
    // maka isi blok di dalamnya akan dijalankan. Selalu ingat untuk memberhentikan / menaikkan value count agar tidak Infinite Loop.
    var sum = 0
    var count = 1
    while(count <= 5) {
        sum += count
        count++
    }
    return sum
}

fun soal09_whileMinus_ans(): Int {
    // PENJELASAN:
    // Sama spt di atas, namun disimulasikan sebagai tangki yang setiap iterasi airnya surut.
    var air = 100
    var kaliBerkurang = 0
    while(air > 0) {
        air -= 25
        kaliBerkurang++
    }
    return kaliBerkurang
}

fun soal10_doWhile_ans(): Int {
    // PENJELASAN:
    // `do-while` akan mengeksekusi blok kode di dalamnnya minimal SEKALI. Pengecekannya ditaruh dipaling AKHIR.
    var x = 10
    do {
        x -= 5
    } while(x > 10)
    return x
}

fun soal11_break_ans(): List<Int> {
    // PENJELASAN:
    // `break` difungsikan untuk "Menghancurkan/Mematikan" looping selamanya.
    val list = mutableListOf<Int>()
    for (i in 1..10) {
        if (i == 4) break
        list.add(i)
    }
    return list
}

fun soal12_continue_ans(): List<Int> {
    // PENJELASAN:
    // `continue` memfungsikan untuk "Skip bagian ekor koding (skip proses sisa bawah)" untk siklus ini saja.
    // Looping akan terus hidup meloncat ke baris iterasi berikutnya.
    val list = mutableListOf<Int>()
    for (i in 1..5) {
        if (i == 3) continue
        list.add(i)
    }
    return list
}

fun soal13_nestedLoop_ans(): String {
    // PENJELASAN:
    // Loop beranak dalam loop.
    var papan = ""
    for (i in 1..2) {
        for (j in 1..2) {
            papan += "($i,$j)"
        }
    }
    return papan
}

fun soal14_labeledBreak_ans(): Int {
    // PENJELASAN:
    // Labeled Break `label@`. Sangat canggih saat Nested loop.
    // Memanggil `break@labelLuar`  akan otomatis menghabisi SEMUA kalang sampe ke induknya sekalian.
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

fun soal15_labeledContinue_ans(): String {
    // PENJELASAN:
    // Labeled continue melompat kbali dan memulai iterasi dari level for yang ditentukan label.
    var result = ""
    for (i in 1..2) {
        loopJ@ for (j in 1..3) {
            if (j == 2) continue@loopJ
            result += "($i:$j)"
        }
    }
    return result
}

fun soal16_repeatLoop_ans(n: Int): String {
    // PENJELASAN:
    // Standard library Kotlin yg powerful. `repeat(int.kali)` akan mengeksekusi blok sebanyak batas count.
    var kotak = ""
    repeat(n) {
        kotak += "X"
    }
    return kotak
}
