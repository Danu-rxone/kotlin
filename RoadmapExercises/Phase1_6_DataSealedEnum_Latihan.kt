package roadmap.phase1.part6

import roadmap.Checker

// ==============================================================================
// 🟢 FASE 1 - PART 6: Data Class, Sealed Class, Enum (16 Soal)
// ==============================================================================

// ========= DATA CLASS =========
// 1. Buat data class `Akun(val usr: String, val pwd: String)`.
// Fungsi di bawah membuat `Akun("admin", "123")`. Kembalikan representasi string (toString()) dari objek tersebut.
// BUKTIKAN bahwa data class memeliki `.toString()` bawaan yang cantik seperti -> Akun(usr=admin, pwd=123)
// TODO: Buat data class Akun
fun soal01_dataClassToString(): String {
    // TODO: return objek.toString()
    return ""
}

// 2. Equality (Membandingkan Value). Data class membandingkan valuenya (bukan referensi memori kelasnya).
// Buat 2 objek `Akun` dengan isi tepat sama persis ("admin","123"). Return pembandingan objek1 == objek2 (Boolean).
// Note: Kalau dia class biasa, dia akan bernilai false. Karena data class, dia true!
fun soal02_dataClassEquals(): Boolean {
    // TODO
    return false
}

// 3. HashCode (Bukti equality). Data class menghasilkan hashCode identik jika nilainya identik.
// Kembalikan boolean: obj1.hashCode() == obj2.hashCode(). Pastikan isinya sama persis "admin","123"
fun soal03_dataClassHashCode(): Boolean {
    // TODO
    return false
}

// 4. Copying. Buat data class `Akun` isi murninya, panggil `.copy()`.
// Ubah spesifik `pwd` menjadi "444" saat menggunakan metode copy. Kembalikan obj copyannya.
fun soal04_dataClassCopy(): Any? { // Ganti Any jadi Akun
    // TODO
    return null
}

// 5. Destructuring Declarations. Dari sebuah `Akun("Budi", "999")`, 
// Destructure datanya dengan `val (nama, sandi) = akun`. Return "$nama:$sandi".
fun soal05_destructuring(): String {
    // TODO
    return ""
}

// 6. Properties default value di Data Class.
// Buat data class `Resi(val no: String, val kurir: String = "JNE")`.
// Kembalikan kurir default resi yang baru kita panggail Resi("R123")
// TODO: Buat Data Class Resi
fun soal06_dataClassDefaultVal(): String {
    // TODO: Buat Resi("R123") dan panggil .kurir
    return ""
}

// ========= ENUM CLASS =========
// 7. Enum Basic. Buat `enum class Status { START, PAUSE, STOP }`.
// Return nama string murni dari enumerasi PAUSE (Gunakan `.name`).
// TODO: Buat enum class Status
fun soal07_enumName(): String {
    // TODO: Return Status.PAUSE.name
    return ""
}

// 8. Enum Ordinal (Index/Urutan Deklarasi Enum).
// Dilarang mengubah urutannya START (0), PAUSE (1), STOP (2). Return ordinal untuk STOP (integer).
fun soal08_enumOrdinal(): Int {
    // TODO: Return Status.STOP.ordinal
    return -1
}

// 9. Enum Values(). Dapatkan dan return semua array/list dari `Status.values()`. (Pastikan format List, misal .toList())
fun soal09_enumValuesArray(): List<Any> { // Ganti Any ke Status
    // TODO: Return Status.values().toList()
    return emptyList()
}

// 10. Enum ValueOf(String). Coba ubah string murni "START" kembali menjadi objek Enumerasi Status.START
// Gunakan `Status.valueOf("START")`
fun soal10_enumValueOfStr(): Any? { // Ganti ke Status
    // TODO
    return null
}

// 11. Enum with Properties. Buat `enum class Planet(val urutan: Int)`.
// Isi dengan: BUMI(3), MARS(4). Return nilai urutan dari MARS.
// TODO: Buat enum Planet
fun soal11_enumProperty(): Int {
    // TODO
    return 0
}

// 12. Enum with Abstract Method (Advance Enum). Buat `enum class Role` yg punya fungsi `abstract fun getGaji(): Int`.
// Buat tipe ADMIN yang override fungsi return 5000, tipe USER return 1000.
// Lalu return gaji dari ADMIN.
// TODO: Buat enum class Role { ADMIN { override fun getGaji()=5000 } , USER { ... } ; abstract fun getGaji() }
fun soal12_enumMethod(): Int {
    // TODO: Role.ADMIN.getGaji()
    return 0
}


// ========= SEALED CLASS =========
// 13. Basic Sealed Class (Bisa dibayangkan Enum Superpower). 
// Buat `sealed class Bentuk`
// Buat `data class Lingkaran(val r: Int) : Bentuk()`
// Buat `object Titik : Bentuk()`
// Return sebuah instance dari Lingkaran dengan jari (r) 10.
// TODO: Buat sealed class Bentuk dkk
fun soal13_sealedClassCreation(): Any? { // Ganti jd Bentuk
    // TODO
    return null
}

// 14. Fungsi Evaluasi Exhaustive (When with Sealed Class).
// Parameter 'b' bertipe `Bentuk` (Ubah dulu dr Any ke Bentuk).
// Gunakan `when(b)`! Jika `is Lingkaran`, return nilai String jari-jarinya. Jika `is Titik`, return "Ini Titik".
// Perhatikan bahwa "else" TIDAK DIPERLUKAN apabila sudah menyapu bersih semua kondisi Sealed Class!
fun soal14_sealedWhen(b: Any): String { // Ubah arg jd Bentuk
    // TODO
    return ""
}

// 15. Sealed Interface. Mulai Kotlin 1.5, sealed tidak harus class tapi bisa Interface!
// Buat `sealed interface Aksi`, buat `object Lari : Aksi`, `object Lompat : Aksi`. Return instan Lari.
// TODO: Buat sealed interface Aksi
fun soal15_sealedInterface(): Any? { // Ganti ke Aksi
    // TODO
    return null
}

// 16. Mengapa Sealed Class > Enum untuk merepresentasikan network/hasil pemrosesan?
// Jwb: Karena sealed class turunannya diijinkan untuk menyimpan properti dan membawanya kemana-mana spt Data class.
// Parameter `sukses` bernilai true -> Return `ListHasil.Berhasil` bawa teks "Yes".
// Parameter false -> Return `ListHasil.Gagal` (hanya object Gagal murni saja tnp data teks).
// TODO: Buat sealed class ListHasil { data class Berhasil(teks: String): ListHasil() ; object Gagal: ListHasil() }
fun soal16_realSealedAction(sukses: Boolean): Any? { // Ganti ke ListHasil
    // TODO
    return null
}


// ===================================
// ▶️ RUN
// ===================================
fun main() {
    Checker.printHeader("PART 6 - Data/Sealed/Enum (16 Soal)")
    try {
        val akId = Class.forName("roadmap.phase1.part6.Akun")
        val const = akId.constructors[0]
        val akObj = const.newInstance("admin", "123")
        Checker.checkEquals("Akun(usr=admin, pwd=123)", akObj.toString(), "Soal 1 (Data Class auto-toString)")
    } catch(e:Exception){ Checker.checkEquals("OK", "TIDAK DITEMUKAN CLASS", "Soal 1-5") }
    
    Checker.checkEquals(true, soal02_dataClassEquals(), "Soal 2")
    Checker.checkEquals(true, soal03_dataClassHashCode(), "Soal 3")
    val cpy = soal04_dataClassCopy()
    Checker.checkEquals(true, cpy.toString().contains("444"), "Soal 4 (Copy Password)")
    Checker.checkEquals("Budi:999", soal05_destructuring(), "Soal 5")
    Checker.checkEquals("JNE", soal06_dataClassDefaultVal(), "Soal 6")
    Checker.checkEquals("PAUSE", soal07_enumName(), "Soal 7")
    Checker.checkEquals(2, soal08_enumOrdinal(), "Soal 8")
    Checker.checkEquals(true, soal09_enumValuesArray().toString().contains("START, PAUSE, STOP"), "Soal 9")
    Checker.checkEquals("START", soal10_enumValueOfStr().toString(), "Soal 10")
    Checker.checkEquals(4, soal11_enumProperty(), "Soal 11")
    Checker.checkEquals(5000, soal12_enumMethod(), "Soal 12")
    Checker.checkEquals(true, soal13_sealedClassCreation().toString().contains("Lingkaran"), "Soal 13")
    
    try {
        val tInst = Class.forName("roadmap.phase1.part6.Titik").getDeclaredField("INSTANCE").get(null)
        Checker.checkEquals("Ini Titik", soal14_sealedWhen(tInst!!), "Soal 14 (Sealed When Exhaustive)")
    } catch(e:Exception){ println("❌ Soal 14: Failed / Belum Class"); }
    
    Checker.checkEquals("Lari", soal15_sealedInterface()?.javaClass?.simpleName, "Soal 15")
    val res16 = soal16_realSealedAction(true)
    Checker.checkEquals(true, res16.toString().contains("Berhasil") && res16.toString().contains("Yes"), "Soal 16 (Sealed Real App)")
}
