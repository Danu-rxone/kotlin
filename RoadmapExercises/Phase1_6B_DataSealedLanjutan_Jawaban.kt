package roadmap.phase1.part6b

// ==============================================================================
// 🔑 KUNCI JAWABAN & PENJELASAN
// FASE 1 - PART 6B: DATA & SEALED CLASS LANJUTAN
// ==============================================================================

// SOAL 1
data class Keranjang(var jumlah: Int)

fun soal01_dataClassMutable_ans(): Int {
    // PENJELASAN: 
    // Data Class boleh memakai `var`. Ini sangat flexibel untk logic spt counter cart yg dinamis. 
    val k = Keranjang(5)
    k.jumlah = 10
    return k.jumlah
}

// SOAL 2 & 3
data class Siswa(val nama: String, val nilai: Int)

fun soal02_dataClassList_ans(): String {
    val list = listOf(Siswa("A", 80), Siswa("B", 90))
    // PENJELASAN: Data Class adalah warga kelas 1 untuk mengisi List Array. 
    return list[0].nama
}

fun soal03_dataClassMap_ans(): List<Int> {
    val murid = listOf(Siswa("X", 50), Siswa("Y", 60))
    // PENJELASAN:
    // Mmentransformsikan (Mapping) list of Object menjado list of Property specifik. 
    // Hasil map ini akan beruap Tipe Data [50, 60] (List of Integers murni krena yg diptik hnya intgiernilanya).
    return murid.map { it.nilai }
}

// SOAL 4 & 5
sealed class StatusJaringan {
    object Loading : StatusJaringan()
    data class Error(val pesan: String) : StatusJaringan()
}

fun soal04_sealedNetworking_ans(pesan: String): StatusJaringan {
    // PENJELASAN: Object Loading gk bth diinstansiasi jd bs lgsug dhpanggil.
    if (pesan == "") return StatusJaringan.Loading
    return StatusJaringan.Error(pesan)
}

fun soal05_sealedWhenExtra_ans(state: StatusJaringan): String {
    // PENJELASAN: Pattern Matching mnggunanan When Exhaustive trhdp semua jajaran "Klan" sealed.
    return when(state) {
        is StatusJaringan.Loading -> "Sedang memuat..."
        is StatusJaringan.Error -> "Gagal: ${state.pesan}"
    } // Tidak prlu "else" Krang slmua kamvkinan udh trtebak olh compileer!!
}

// SOAL 6
sealed interface TombolAksi {
    data class Klik(val x: Int, val y: Int) : TombolAksi
}

fun soal06_sealedInterfaceKlik_ans(): TombolAksi {
    // PENJELASAN: Mirip Sealed Class nmun tk ush mmkai `()` ktia implementasika  Interface bapknya mllaui data Class anak.
    return TombolAksi.Klik(10, 20)
}

// SOAL 7
enum class Bulan { JAN, FEB, MAR }

fun soal07_enumForEach_ans(): String {
    // PENJELASAN: Looping the .values() array returns all entries uruttt!
    var result = ""
    for(b in Bulan.values()) {
        result += "${b.name}-"
    }
    return result.dropLast(1)
}

// SOAL 8
enum class RoleAkses(val level: Int) { 
    GUEST(1), MEMBER(2), ADMIN(3) 
}

fun soal08_enumFind_ans(dicariLevel: Int): RoleAkses? {
    // PENEJELASAN:
    // Fungsi `.find` adlaah extnsion cllsctiom dr kotlin, ia mngiterasi array mcrri Elemen PERKSTAMAN yg pass test kndisi dan brhsil true, kl tdk da yg cucuk jd Null !
    return RoleAkses.values().find { it.level == dicariLevel }
}

// SOAL 9 & 10
enum class Warna { 
    MERAH { override fun toString() = "Super Merah" }, 
    BIRU 
}

fun soal09_enumOverrideString_ans(): String {
    // PENJELASAMN: Memaksa override strig mnri pda enum tsrtnt.
    return Warna.MERAH.toString()
}

fun soal10_enumExhaustiveWhen_ans(w: Warna): Int {
    // PENJELASAN: Sama sprt Sealed class!! Enym Exhaausyice tk prrlu blok else krn compilrr hapah jumlhanya pasito cuma duaa wRna. 
    return when(w) {
        Warna.MERAH -> 1
        Warna.BIRU -> 2
    }
}
