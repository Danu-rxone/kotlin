package roadmap.phase1.part5b

// ==============================================================================
// 🔑 KUNCI JAWABAN & PENJELASAN
// FASE 1 - PART 5B: OOP Lanjutan
// ==============================================================================

// SOAL 1
class Rekening {
    var saldo: Int = 0
        private set // PENJELASAN: Memblokir penulisan langsung dari luar class. Hnya class Rekening ini yg bs merubah isian saldonya.

    fun setor(uang: Int) {
        saldo += uang
    }
}

fun soal01_privateSetter_ans(): Int {
    val r = Rekening()
    // r.saldo = 100 // <-- AKAN COMPILE ERROR JIKA DIBUKA KARENA PRIVATE SETTER!!
    r.setor(100)
    return r.saldo
}

// SOAL 2
class Koleksi {
    // PENJELASAN: Ini mencegah list dimodifikasi dengan sengaja dari luar menggunakan `.add()`
    private val _items = mutableListOf<String>()
    
    // Yg diekspose ke caller luar hnyalah versi `List` murni yg mana antarmkuka list standar di KT tidak punya opsi `.add` atau `.remove`. 
    // Data List ssuhnnys mengambil nilai sinkron / pointer ke dalam tubuh mutable list aslinya (_items).
    val items: List<String> get() = _items

    fun tambah(item: String) {
        _items.add(item)
    }
}

fun soal02_backingProperty_ans(): List<String> {
    val k = Koleksi()
    k.tambah("A")
    k.tambah("B")
    return k.items
}

// SOAL 3
open class Kendaraan {
    open val jumlahRoda: Int = 0 
}

class Motor : Kendaraan() {
    override val jumlahRoda: Int = 2
}

fun soal03_overrideProperty_ans(): Int {
    return Motor().jumlahRoda
}

// SOAL 4
open class Senjata(open val damage: Int)

class Pedang(override val damage: Int) : Senjata(damage)

fun soal04_overrideConstructorParam_ans(): Int {
    return Pedang(50).damage
}

// SOAL 5
open class AkunGame {
    open fun tier() = "Bronze"
}

class AkunPro : AkunGame() {
    override fun tier() = super.tier() + "-Pro"
}

fun soal05_superCall_ans(): String {
    return AkunPro().tier()
}

// SOAL 6
interface PunyaNama {
    val nama: String
}

class Karyawan(override val nama: String) : PunyaNama

fun soal06_interfaceProperty_ans(): String {
    return Karyawan("Agus").nama
}

// SOAL 7
interface BisaJalan {
    fun jalan() = "Sedang Jalan" // PENJELASAN: Default body interface (mengirit keharusan mengoverride smua child yg sbenrnya cm perrlu pliku dsr).
}

class Orang : BisaJalan

fun soal07_interfaceDefaultMethod_ans(): String {
    return Orang().jalan()
}

// SOAL 8
interface A {
    fun print() = "A"
}
interface B {
    fun print() = "B"
}

// PENJELASAN: Diamond problem (fungsi kembar). Kt msti menoverrrde eksplisit yg ngasi petunjuk compiler mana rujukan ibu moygany yg bner untk dpanggil (`super<NamaBapak>.method`).
class C : A, B {
    override fun print(): String {
        return super<A>.print() + super<B>.print()
    }
}

fun soal08_interfaceConflict_ans(): String {
    return C().print()
}

// SOAL 9
class Panah(override val damage: Int) : Senjata(damage)

// PENJELASAN: `s` bebas menerima turunan bentuk APAPUN sbgin Bapaknya si Senjata ini asalkan valid child. Inilah jantung Polimorfisme.
fun serang(s: Senjata): String {
    return "Serang menghasilkan ${s.damage} damage"
}

fun soal09_polymorphismFunction_ans(): String {
    return serang(Panah(20))
}

// SOAL 10
fun soal10_polymorphismList_ans(): Int {
    // PENJELASAN: Lst of Bapak (List<Senjata>), tp member d dlm koleksinya bebas rupa (Pedang, Panah, dll).
    val list: List<Senjata> = listOf(Pedang(10), Panah(15))
    var total = 0
    for (s in list) {
        total += s.damage
    }
    return total
}

// SOAL 11
fun soal11_unsafeCasting_ans(arg: Any): Char {
    // PENJELASAN: Casting maksa (Unsafe) menggunakan as. Crash kl yg dlempar taunya Int!
    val teks = arg as String
    return teks[0]
}

// SOAL 12
fun soal12_safeCasting_ans(arg: Any): String {
    // PENJELASAN: Pngman trbaik kotlin. Kl ggl ubah Any->Str, dy akan ngluarin Null insted of exception. Null trsbt di tlpsih ke Elvis ?: .
    return arg as? String ?: "Bukan Teks"
}

// SOAL 13
abstract class Bangunan {
    abstract val harga: Int // Property tanpa nilai bawaan yg WAJIB diisi anaknya.
}

class Rumah : Bangunan() {
    override val harga = 500
}

fun soal13_abstractProperty_ans(): Int {
    return Rumah().harga
}

// SOAL 14
// PENJELASAN: Nested Class. Ibarat klas murni yg cm numpang domisili bernaung nma saja dlm kelas Luar, tp ia GAK PUNYA AKSE Ke prperty dlam class Luar ny sama skali.
class Luar {
    class Dalam {
        fun cetak() = "Ini Dalam"
    }
}

fun soal14_nestedClass_ans(): String {
    // Pembuatan trlpt tnpa membuat var luar = Luar() prtma.
    return Luar.Dalam().cetak()
}

// SOAL 15
// PENJELASAN: Inner class. Class khusus yg Punya konekso / tali pusar memori lgsgg nge-refer ke Bapapakmnya sbgingga ia bsa mkkses var id ny sang Indulkt dgn leluasa!
class Induk(val id: Int) {
    inner class Anak {
        fun cetak() = "Anak dari $id"
    }
}

fun soal15_innerClass_ans(): String {
    val bapaknya = Induk(99)
    val anakTersambung = bapaknya.Anak()
    return anakTersambung.cetak()
    // atau chaining: return Induk(99).Anak().cetak()
}
