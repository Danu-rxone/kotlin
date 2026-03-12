package roadmap.phase1.part6b

import roadmap.Checker

// ==============================================================================
// 🟢 FASE 1 - PART 6B: DATA & SEALED CLASS LANJUTAN (10 Soal)
// Fokus Ekstra: Data Class, Sealed Class, Enum
// ==============================================================================

// ========= DATA CLASS =========
// 1. Data Class dengan Properti Mutable.
// Buat data class `Keranjang(var jumlah: Int)`. Perhatikan penggunaan VAR.
// TODO: Buat class Keranjang
fun soal01_dataClassMutable(): Int {
    // TODO: Buat Keranjang(5), UBAH jumlahnya jadi 10, Return nilai jumlahnya.
    return 0
}

// 2. Data Class di dalam Collections.
// Buat data class `Siswa(val nama: String, val nilai: Int)`.
// TODO: Buat class Siswa
fun soal02_dataClassList(): String {
    // TODO: Buat `val list = listOf(Siswa("A", 80), Siswa("B", 90))`
    // TODO: Return nama Siswa pertama di index [0] dari list tsb.
    return ""
}

// 3. Mapping List dari Data Class (Transformasi).
// Diberikan list `Siswa("X", 50), Siswa("Y", 60)`.
// Gunakan ekstensi `.map { it.nilai }` untuk merubah list Object menjadi List Int MURNI.
fun soal03_dataClassMap(): List<Int> {
    // Asumsikan Siswa sudah dibuat di soal 02
    // TODO: val murid = listOf(Siswa("X", 50), Siswa("Y", 60))
    // TODO: Return murid.map { ... }
    return emptyList()
}


// ========= SEALED CLASS (Deeper Dive) =========
// 4. Sealed Class vs Abstraction Biasa.
// Sealed class memungkinkan turunan berada di dalam/luar body ASAL masih dlm file yang sama!
// Buat `sealed class StatusJaringan`
// Buat turunan `object Loading : StatusJaringan()`
// Buat turunan `data class Error(val pesan: String) : StatusJaringan()`
// TODO: Buat class StatusJaringan, Loading, Error
fun soal04_sealedNetworking(pesan: String): Any? { // Ganti ke StatusJaringan
    // TODO: Jika parameter pass berisi teks kosong "", Return object Loading.
    // TODO: Jika string ada isinya, Return error(pesannya).
    return null
}

// 5. Sealed Class di RecyclerView / UI State (Simulasi).
// Anda dapat parameter state bertipe (StatusJaringan dlm btk Any). Ubah tipe Anynya.
// Gunakan `when` (ingat Exhaustive):
// - Jika Loading -> Return "Sedang memuat..."
// - Jika Error -> Return "Gagal: ${state.pesan}"
fun soal05_sealedWhenExtra(state: Any): String { // Ganti tipe param ke StatusJaringan
    // TODO...
    return ""
}

// 6. Sealed Interface vs Sealed Class.
// Sealed Class bisa menyimpan Constructor parameter umum `sealed class Shape(val x:Int)`, tp Interface TIDAK BISA.
// Buat `sealed interface TombolAksi`
// Buat `data class Klik(val x: Int, val y: Int) : TombolAksi`
// TODO: Definisikan interface dan class
fun soal06_sealedInterfaceKlik(): Any? { // Ganti ke TombolAksi
    // TODO: Return object Klik dengan Koordinat 10, 20
    return null
}


// ========= ENUM CLASS LANJUTAN =========
// 7. Iterasi (Foreach) pada Enum Array.
// Buat Enum `Bulan { JAN, FEB, MAR }`.
// TODO: Buat Enum Bulan
fun soal07_enumForEach(): String {
    // TODO: Loop semua values() nya dengan `for`. Gabungkan jadi String "JAN-FEB-MAR" (pisahkan dg dash)
    var result = ""
    // for(b in Bulan.values()) { result += "${b.name}-" } lalu hapus dash trkhir pakai .dropLast(1)
    return result
}

// 8. Pencarian Data di Enum berdasarkan Property (Mencari ID).
// Buat Enum `RoleAkses(val level: Int) { GUEST(1), MEMBER(2), ADMIN(3) }`.
// Diberikan parameter 'dicariLevel' (Int = 2). 
// Lacak di sekujur arrays Bulan tsb, kemnbalikan Object yg Punya level tsb (Pastilah MEMBER).
// TODO: Buat Enum RoleAkses
fun soal08_enumFind(dicariLevel: Int): Any? { // Ganti ke RoleAkses
    // TODO: Return RoleAkses.values().find { it.level == dicariLevel }
    return null
}

// 9. Enum dan Custom toString().
// Enum otomatis toStringnya adalah .name. Tapi BISA di override.
// Buat `enum class Warna { MERAH { override fun toString() = "Super Merah" }, BIRU }`.
// TODO: Buat enum Warna
fun soal09_enumOverrideString(): String {
    // TODO: Return text dr print(Warna.MERAH) atau Warna.MERAH.toString()
    return ""
}

// 10. Membandingkan Eksekusi State. Saat di when, Enum sama amannya spt Sealed Exhaustive.
// Buat fungsi when utk nangkep Warna: "MERAH" return 1, "BIRU" return 2.
fun soal10_enumExhaustiveWhen(w: Any): Int { // Ganti param jd Warna
    // TODO: when(w)
    return 0
}


// ===================================
// ▶️ RUN
// ===================================
fun main() {
    Checker.printHeader("PART 6B - Data & Sealed Class Lanjutan (10 Soal)")
    Checker.checkEquals(10, soal01_dataClassMutable(), "Soal 1")
    
    try {
        val nma = soal02_dataClassList()
        Checker.checkEquals("A", nma, "Soal 2 (Siswa Nama)")
        Checker.checkEquals(listOf(50, 60), soal03_dataClassMap(), "Soal 3 (Map List)")
        
        val ld = soal04_sealedNetworking("")
        Checker.checkEquals("Loading", ld?.javaClass?.simpleName, "Soal 4 (Loading)")
        val er = soal04_sealedNetworking("RTO")
        Checker.checkEquals("Gagal: RTO", soal05_sealedWhenExtra(er!!), "Soal 5 (Error UI State)")
    } catch(e:Exception){ println("ERR 2-5: Pastikan class sudah dibuat & param fungsi diupdate typenya $e") }

    try {
        val klk = soal06_sealedInterfaceKlik()
        Checker.checkEquals("Klik", klk?.javaClass?.simpleName, "Soal 6")
        val xp = klk?.javaClass?.getMethod("getX")?.invoke(klk)
        Checker.checkEquals(10, xp, "Soal 6 (X Cek)")
    } catch(e:Exception){}

    Checker.checkEquals("JAN-FEB-MAR", soal07_enumForEach(), "Soal 7")
    try {
        val rl = soal08_enumFind(3)
        Checker.checkEquals("ADMIN", rl?.javaClass?.getMethod("name")?.invoke(rl), "Soal 8")
    } catch(e:Exception){}
    
    try {
       Checker.checkEquals("Super Merah", soal09_enumOverrideString(), "Soal 9")
       val wClass = Class.forName("roadmap.phase1.part6b.Warna")
       val wBiru = o(wClass, "BIRU")
       Checker.checkEquals(2, soal10_enumExhaustiveWhen(wBiru!!), "Soal 10")
    } catch(e:Exception){ println(e) }
}
fun o(c: Class<*>, name: String) = c.enumConstants.firstOrNull { (it as Enum<*>).name == name }
