package roadmap.phase1.part2

// ==============================================================================
// 🔑 KUNCI JAWABAN & PENJELASAN
// FASE 1 - PART 2: Control Flow (If/Else, When)
// ==============================================================================

fun soal01_ifElse_ans(angka: Int): String {
    // PENJELASAN: 
    // Logika percabangan standar yang dimiliki hampir semua bahasa pemrograman.
    if (angka > 0) {
        return "Positif"
    } else {
        return "Negatif/Nol"
    }
}

// PENJELASAN SOAL 2: 
// IF Expression. Di Kotlin if juga bertindak sbg "Expression" (yg mengembalikan nilai/return value).
// Sehingga kita tidak repot pakai variabel temporary dan lgsng assign hasil blok if tsb ke '=' .
// Ini adalah pengganti mutlak fungsi Ternary Operator ( kondisi ? "Ya" : "Tidak" ) yg dicabut dr Kotlin.
fun soal02_ifExpr_ans(angka: Int): String = if (angka > 0) "Positif" else "Negatif/Nol"

fun soal03_ifElseIf_ans(angka: Int): String {
    // PENJELASAN: 
    // Digunakan saat kondisi boolean eksklusif lebih dari dua. 
    // Kotlin sangat cermat, kalau statementnya cuma 1 baris, tidak pakai bracket {} pun tidak perlu.
    if (angka > 0) return "Positif"
    else if (angka < 0) return "Negatif"
    else return "Nol"
}

fun soal04_nestedIf_ans(isWeekend: Boolean, isRaining: Boolean): String {
    // PENJELASAN: 
    // If di dalam if. Ini baik utk pengecekan berlapis, 
    // meski harus dikurangi pemakaiannya dengan pola `guard clause` demi kode yg lurus/baca friendly.
    if (isWeekend) {
        if (isRaining) {
            return "Tidur"
        } else {
            return "Main"
        }
    } else {
        return "Kerja"
    }
}

fun soal05_stringEquals_ans(str1: String, str2: String): Boolean {
    // PENJELASAN: 
    // BERBEDA 100% dari JAVA. Di Kotlin, (==) adalah *Structural Equality*. 
    // Dia akan OTOMATIS memanggil (menyederhanakan sintax) `str1.equals(str2)` di baliknya (aman jika null). 
    // Untuk cek memori reference gundul, baru gunkn `===`
    return str1 == str2 
}

fun soal06_whenSimple_ans(angka: Int): String {
    // PENJELASAN: 
    // Pengganti `switch` di bahasa lain. Bebas tipe data (ga harus integer, boleh string dll).
    // Kata `else` berfungsi layaknya `default:` di switch-case.
    return when(angka) {
        1 -> "Satu"
        2 -> "Dua"
        else -> "Banyak"
    }
}

fun soal07_whenComma_ans(angka: Int): String {
    // PENJELASAN: 
    // Pengganti efek drop-thru kosong di switch `case 1: case3: case5: return dsb;`
    // Sangat berguna untuk menjejeri multi pattern ke 1 output.
    return when(angka) {
        1, 3, 5 -> "Ganjil"
        2, 4, 6 -> "Genap"
        else -> "Lainnya"
    }
}

fun soal08_whenRange_ans(angka: Int): String {
    // PENJELASAN: 
    // Keistimewaan `when` bisa dipadukan keyword `in`. Sangat mempersingkat ribuan if-else < > AND AND.
    // Range (..) inclusive mncakup bilangan ujung-ujungnya! (1 ikut, 10 ikut).
    return when(angka) {
        in 1..10 -> "Kecil"
        in 11..20 -> "Sedang"
        else -> "Besar"
    }
}

fun soal09_whenNotIn_ans(x: Int): String {
    // PENJELASAN: 
    // Operator `!in` bermakna NOT In (Bukan di dalam rentang yang diminta).
    return when(x) {
        !in 1..100 -> "Invalid"
        else -> "Valid"
    }
}

// PENJELASAN SOAL 10: 
// When expression, body When bisa dijadikan nilai kembalian 1 baris sama spt If di atas.  
fun soal10_whenExpr_ans(isLapar: Boolean): String = when(isLapar) { true -> "Makan" false -> "Kenyang" }

fun soal11_whenIs_ans(arg: Any): String {
    // PENJELASAN: 
    // Operator Type-Checking `is` sangat canggih di When. 
    // Ini mirip kayak operator `instanceOf` di Java tp dalam versi compact.
    return when(arg) {
        is Int -> "Angka"
        is String -> "Teks"
        is Boolean -> "Bool"
        else -> "Tidak Diketahui"
    }
}

fun soal12_smartCast_ans(arg: Any): Int {
    // PENJELASAN: 
    // Smart Cast adalah fitur tercanggih Kotlin. Sesudah kita melewati pengecekan If(arg is String) dengan sukses, 
    // Maka Kotlin otomatis mengconvert temporary `arg` JADI Tipe String! Makanya kita nggak prlu 
    // casting ribet `String a = (String) arg;` lg seperti bahasa lain dan kta lgsung bsa pass arg.length.
    if (arg is String) {
        return arg.length
    }
    return 0
}

fun soal13_whenNoArgs_ans(umur: Int, ktp: Boolean): String {
    // PENJELASAN: 
    // Jika When ditutup parameter kurungnya `when {}` , maka dia jadi bertingkat IF-ELSE-IF super bersih.
    // Di sini kita bisa menulis berabagai logika Boolean expression super bebas di kirinya tanda -> !
    return when {
        umur > 17 && ktp == true -> "Dewasa"
        umur > 17 && ktp == false -> "Bikin KTP"
        else -> "Anak"
    }
}

fun soal14_jamKerja_ans(jam: Int): Boolean {
    // PENJELASAN: 
    // AND ( && ) akan sukses jika kedua condition di sisi kiri kanannya bernilai benar mereturn true.
    return jam >= 8 && jam <= 16
}

fun soal15_diskon_ans(isDiscount: Boolean, total: Int): Int {
    // PENJELASAN: 
    // OR ( || ) akan sukses apbila salah 1 (minimal satu) kondisinya terpenuhi. 
    if (isDiscount || total > 100) {
        return total - 20
    }
    return total
}

fun soal16_pajak_ans(gaji: Double, kategori: String): Double {
    // PENJELASAN: 
    // Dalam perhitungan uang idealnya menggunakan BigDecimal. 
    // Di sini double digunakan utk mengkalikan gaji * persentase pecahannya (10% = 0.1).
    return when(kategori) {
        "A" -> gaji * 0.1
        "B" -> gaji * 0.05
        else -> 0.0
    }
}

fun soal17_whenBlock_ans(x: Int): String {
    // PENJELASAN: 
    // Di dalam case when kita bs mngeksekusi multi baris aksi kurung kurawal. 
    // Apapun statement yang menjadi baris "Terakhir", dia lah yang akan dikonversi sbg tipe Value / Kembalian balasan dr when blok tsb.
    return when(x) {
        1 -> {
            println("Halo")
            "Satu" // Baris terakhir di blok adalah nilai kembaliannya (berspesifik Tipe String)
        }
        else -> "Bukan"
    }
}
