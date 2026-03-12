package roadmap.phase1.part6

// ==============================================================================
// 🔑 KUNCI JAWABAN & PENJELASAN
// FASE 1 - PART 6: Data Class, Sealed Class, Enum
// ==============================================================================

// PENJELASAN SOAL 1-5 (DATA CLASS):
// Menambahkan keyword `data` di depan class akan otomatis mengenerate/membuatkan fungsi 
// krusial POJO seperti `.equals()`, `.hashCode()`, `.toString()`, `.copy()` dan `.componentN()`.
// Ini sangat mengurangi boilerplate code mndeklarasikan getter/setter override Java murni yang bisa trsan hingga puluhan baris.
data class Akun(val usr: String, val pwd: String)

fun soal01_dataClassToString_ans(): String {
    // PENJELASAN: 
    // Otomatis men-generate string terbaca manis `Akun(usr=admin, pwd=123)` bkn `Akun@8263hjd`.
    return Akun("admin", "123").toString()
}

fun soal02_dataClassEquals_ans(): Boolean {
    // PENJELASAN: 
    // Data class membandingkan VALUES (Isi property). Sehingga admin==admin pasti true.
    return Akun("admin", "123") == Akun("admin", "123")
}

fun soal03_dataClassHashCode_ans(): Boolean {
    // PENJELASAN: 
    // Jika value sama persis, hashCode yang dihasilkan fungsi hashing jg dijamin sama.
    return Akun("admin", "123").hashCode() == Akun("admin", "123").hashCode()
}

fun soal04_dataClassCopy_ans(): Akun {
    // PENJELASAN: 
    // `.copy()` men-cloning Objek A ke B, lalu kita bisa menimpa specific properties tanpa mnyentuh field lamanya.
    val a = Akun("admin", "123")
    return a.copy(pwd = "444")
}

fun soal05_destructuring_ans(): String {
    // PENJELASAN: 
    // Destructuring mnjadi terbongkar seperti object Javascript `const {usr, pwd} = ...`
    // Namun penulisan di destructuring Kotlin bergantung pada URUTAN parameter letaknya di Primary Constructor! (Bukan urutan penamaan propertinya).
    val akun = Akun("Budi", "999")
    val (nama, sandi) = akun
    return "$nama:$sandi"
}

// PENJELASAN SOAL 6 (DEFAULT ARGUMENTS Di Data Class):
// Cukup berguna jika parameter API backend response ada yg missing JSON-nya (di Retrofit). 
// shingga Kotlin bs mnangani sndiri default modelnya sblm app ngecrash saat diparsing Gson/Moshi.
data class Resi(val no: String, val kurir: String = "JNE")

fun soal06_dataClassDefaultVal_ans(): String {
    val r = Resi("R123")
    return r.kurir
}

// PENJELASAN SOAL 7-10 (ENUM CLASS):
// Himpunan list yang memiliki jumlah yang "PASTI" (Ex: Hari cuma 7, Bulan cuma 12).
enum class Status { START, PAUSE, STOP }

fun soal07_enumName_ans(): String {
    // `.name` mengembalikan tipe string utuh 
    return Status.PAUSE.name
}

fun soal08_enumOrdinal_ans(): Int {
    // `.ordinal` mengmbalikan Angka index berdsar posiai deklarasinya (Mulai dari 0 spt list array biasa)
    return Status.STOP.ordinal
}

fun soal09_enumValues_ans(): List<Status> {
    // Mendapatkan total semua populasi Enum dr dlm Class sbg Array
    return Status.values().toList()
}

fun soal10_enumValueOfStr_ans(): Status {
    // Cast merubah kembali kalimat string tdk bertuan menjadi Tipe Enum kuat / aslinya.
    return Status.valueOf("START")
}

// PENJELASAN SOAL 11 (ENUM BERPROPERTY):
// Setiap pilihan enum boleh mnyimpan data khusus misal kode planet ID yang fix (bukan lg ordinal dinamis 0 1 2). 
enum class Planet(val urutan: Int) {
    BUMI(3), MARS(4)
}

fun soal11_enumProperty_ans(): Int {
    return Planet.MARS.urutan
}

// PENJELASAN SOAL 12 (ADVANCE ENUM):
// Enum yang mempunyi sifat / fungsi berbeda di dlam tiap pilhhannya .
// Memaksa tiap elemen mnjelaskan perannya lgsg spt implementasi interace.
enum class Role {
    ADMIN {
        override fun getGaji() = 5000
    },
    USER {
        override fun getGaji() = 1000
    }; // Harus dikasih TITIK KOMA jika hbdikombinasi dg function absract lgi sbg spertor logic nya.
    abstract fun getGaji(): Int
}

fun soal12_enumMethod_ans(): Int {
    return Role.ADMIN.getGaji()
}

// PENJELASAN SOAL 13-14 (SEALED CLASS):
// Merupkan pelebaran dari Enum Class (Enum On Steroids).
// Bedanya, dlm Sealed Class setiap turunannya diijinkan sbg OBJECT atau jga DATA CLASS 
// shg bisa menyimpan nilai Property tambahan yang unik/berbeda dari saudara yg lain.
sealed class Bentuk {
    data class Lingkaran(val r: Int) : Bentuk()
    object Titik : Bentuk()
}

fun soal13_sealedClassCreation_ans(): Bentuk {
    // Tdk prlu new. Jika Data class WAJIB dipassing argumen sesuai contract.
    return Bentuk.Lingkaran(10)
}

fun soal14_sealedWhen_ans(b: Bentuk): String {
    // FUNGSI UTAMA SEALED: Meng"Enforce"/Memaksa kita menghandle SELURUH cabang tanpa kelewtan satupun di When (Exhaustive Eval).
    // Misal kdepannya ada prbmbahan di Class Bentuk, compiler akn lgsung NGAMUK di When block ini sampai kita tmbh cabang baru trsbut. (Bug Preventer handal!).
    return when(b) {
        is Bentuk.Lingkaran -> b.r.toString()
        is Bentuk.Titik -> "Ini Titik"
    }
}

// PENJELASAN SOAL 15 (SEALED INTERFACE):
// Bisa diturunkan spt SealedClass di bwhnya, namum jauh lebih ringan di mnajemen file mnurut tim Kotlin.
sealed interface Aksi {
    object Lari : Aksi
    object Lompat : Aksi
}

fun soal15_sealedInterface_ans(): Aksi {
    return Aksi.Lari
}

// PENJELASAN SOAL 16 (REAL WORLD USE CASE):
// Sangat sring ditemui di StateFlow MVI Android untuk merepresentasikan network response: Loading / Success (bawa List<Baju>) / Error (Bawa pesan "Timeout").
sealed class ListHasil {
    data class Berhasil(val teks: String): ListHasil()
    object Gagal: ListHasil()
}

fun soal16_realSealedAction_ans(sukses: Boolean): ListHasil {
    if (sukses) {
        return ListHasil.Berhasil("Yes")
    } else {
        return ListHasil.Gagal
    }
}
