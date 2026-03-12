package roadmap.phase1.part5

// ==============================================================================
// 🔑 KUNCI JAWABAN & PENJELASAN
// FASE 1 - PART 5: Classes, OOP Concepts
// ==============================================================================

// PENJELASAN SOAL 1:
// Deklarasi kelas di Kotlin sangat ringkas. Tidak butuh kurung kurawal jk todak ada member data.
class Kursi

fun soal01_basicClass_ans(): Kursi {
    return Kursi() // Kotlin tak perlu kta kunci `new` seperti java:  `new Kursi()`
}

// PENJELASAN SOAL 2:
// Properti standard, scr diam-diam Kotlin membuatkannya Getter Setter backing field internal di JVM (bukan lagi field mentah kek Java).
class Meja {
    var bahan: String = "Kayu"
}

fun soal02_classProperty_ans(): String {
    val m = Meja()
    return m.bahan
}

// PENJELASAN SOAL 3:
// Primary constructor mendefiisikan Parameter langsung mnjadi Properti kelas 
// jk dberikan embel-embel val maupun var. Jika polosan (nama: String), hnya sebatas parameter construct (hilang stlh instance build).
class Pena(val warna: String)

fun soal03_primaryConstructorVal_ans(): String {
    val p = Pena("Biru")
    return p.warna
}

class Buku(var halaman: Int = 100)

fun soal04_primaryConstructorVar_ans(): Int {
    // PENJELASAN:
    // Dikarenakan param `var`, halamannya bisa ditulis / set ualng stlh object dbuat.
    val b = Buku()
    b.halaman = 500
    return b.halaman
}

class Kipas(val merk: String) {
    var isMenyala: Boolean = false
    // PENJELASAN SOAL 5:
    // Blok inisalisasi. Berjalan scr otomatis pd saat object kelas tersebut dicreate (stlh valued prim. constructor ditampung).
    init {
        isMenyala = true
    }
}

fun soal05_initBlock_ans(): Boolean {
    val k = Kipas("Miyako")
    return k.isMenyala
}

class Tas(val merk: String) {
    var harga: Int = 0
    // PENJELASAN SOAL 6:
    // Constructor pendamping. WAJIB mendelegasikan ke primary const (via `this(merk)`) jk ada.
    constructor(merk: String, harga: Int) : this(merk) {
        this.harga = harga
    }
}

fun soal06_secondaryConstructor_ans(): Int {
    val t = Tas("Eiger", 250000)
    return t.harga
}

class Dompet {
    // PENJELASAN SOAL 7:
    // Encapsulation. Menyembunyikan detil dalam brgn `private`, shingga class luar ga asal ganti nilai Saldo,
    // hnya dipercya melalui function penengah `tambah()` utk menjga keabsahan biz logic.
    private var saldo = 0

    fun tambah(jumlah: Int) {
        saldo += jumlah
    }

    fun dapatSaldo(): Int {
        return saldo
    }
}

fun soal07_encapsulation_ans(): Int {
    val d = Dompet()
    d.tambah(50)
    return d.dapatSaldo()
}

class Jam {
    var menit = 0
        // PENJELASAN SOAL 8:
        // Coustm Setter. Kita bs mmbjalankan validasi ssaat user meng-set property.
        // `value` trm jwban caller, `field` (Backing Field) adalah dompet rahasia yg sebensrnya mnampung nilainya di memory.
        set(value) {
            field = if (value > 59) 0 else value
        }
}

fun soal08_customSetter_ans(): Int {
    val j = Jam()
    j.menit = 70
    return j.menit
}

// PENJELASAN SOAL 9:
// Inheritance. Di Kotlin scara default smua Class ditutup (Final/Tdk bsa diwariskan).
// Msti dipasangkan brg `open` agar "Hewan" sudi jadi superclass/parent. Fungsi yg pengwn bs doverride jg hrus dideklarasi `open`.
open class Hewan {
    open fun suara() = "Mmm"
}

// Mewarisi ditandai brg spasi_titik_dua (:). Memanggil constructor parentnya ()
class Sapi : Hewan() {
    override fun suara() = "Moo"
}

fun soal09_inheritance_ans(): String {
    return Sapi().suara()
}

open class Pekerja {
    open fun sapa() = "Halo"
}

class Guru : Pekerja() {
    // PENJELASAN SOAL 10:
    // Menggunakan behaviour ibunda lalu ditambahkan sifat trtentu di class nakal tanpa hrus ngetik behavior si ibu scara repitiif .
    override fun sapa() = super.sapa() + " Murid"
}

fun soal10_superMethod_ans(): String {
    return Guru().sapa()
}

// PENJELASAN SOAL 11:
// Antarmuka mnggambarkan PERANAN/KONTRAK sebuah class. Burung DAN Pesawat bs mnyandang gelar sm (BisaTerbang), 
// mesi scara turunan keluarga / keturunan mrka gk prnh ada hbungan darah samasekali.
interface BisaTerbang {
    fun terbang(): String
}

class Burung : BisaTerbang {
    override fun terbang() = "Kepak"
}

class Pesawat : BisaTerbang {
    override fun terbang() = "Mesin"
}

fun soal11_interface_ans(): String {
    val p: BisaTerbang = Pesawat()
    return p.terbang()
}

interface BisaBerenang {
    fun renang(): String
}

class Bebek : BisaTerbang, BisaBerenang {
    // PENJELASAN SOAL 12:
    // Kotlin melarang Class Mewarisi bnyk Induk secara smultan (Mencegah diamond problem), 
    // tp blh mengimplemen bnyk Interface via Koma.
    override fun terbang() = "Ngos-ngosan"
    override fun renang() = "Kwek"
}

fun soal12_multipleInterface_ans(): String {
    val b = Bebek()
    return "${b.terbang()} ${b.renang()}"
}

// PENJELASAN SOAL 13:
// Blueprint/Cetak Biru abstark yg gk bsa dibikin obejct. Harus diwarisi ke brang real sseperti class "Persegi" (yg merealsiasikan fungsinya/Mrumskan luasnya).
abstract class Shape {
    abstract fun area(): Int
}

class Persegi(val sisi: Int) : Shape() {
    override fun area() = sisi * sisi
}

fun soal13_abstractClass_ans(): Int {
    val p = Persegi(5)
    return p.area()
}

open class Rahasia {
    // PENJELASAN SOAL 14:
    // Modifiers Protected adlah anak pertngahan public dan private. Rahasia tsb hnya dpt dlihat
    // Oleh si Class itu sndiir DAN Turunan-turunannya (Sprti class AnakRahasia).
    protected val pin = 1234
}

class AnakRahasia : Rahasia() {
    fun bocorkan() = pin
}

fun soal14_protectedModifier_ans(): Int {
    return AnakRahasia().bocorkan()
}

class Pabrik {
    // PENJELASAN SOAL 15:
    // Kotlin tak punya syntax "static". Smua variable statis (Tdk prlu bkn Object untuk diakses, lgsg Pabrik.LOKASI)
    // hrus dgntikan dengan pattern Companion Object yg mlekat brsm class.
    companion object {
        val LOKASI = "Jakarta"
    }
}

fun soal15_companionObject_ans(): String {
    return Pabrik.LOKASI
}

fun soal16_anonymousObject_ans(): BisaBerenang {
    // PENJELASAN SOAL 16:
    // Pembuatan Class "Sekali Pakai" (Anonnymmous inner class). Sering dipakai pada listener tombol Android (`setOnClickListener { object: ... }`)
    // Tp dikotlin srgkali bsa lbh singat dbentuk jd Lambda saja `setOnClickListener { ... } ` trgatung interface nya.
    return object : BisaBerenang {
        override fun renang() = "Byur"
    }
}
