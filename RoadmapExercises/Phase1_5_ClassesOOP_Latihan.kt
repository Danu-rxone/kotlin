package roadmap.phase1.part5

import roadmap.Checker

// ==============================================================================
// 🟢 FASE 1 - PART 5: Classes, OOP Concepts (16 Soal)
// ==============================================================================

// 1. Basic Class. Buat class bernama `Kursi` kosong (tanpa body/tanpa kurung kurawal). 
// TODO: Buat class Kursi
fun soal01_basicClass(): Any? {
    // Return instance dari class Kursi
    return null
}

// 2. Class Property Asli. Buat class `Meja`. Tambahkan variabel `var bahan: String = "Kayu"` di dalam body class `{ }`.
// TODO: Buat class Meja
fun soal02_classProperty(): String {
    // TODO: Buat instance Meja dan kembalikan nilai bahan (meja.bahan)
    return ""
}

// 3. Primary Constructor (Val). Buat class `Pena(val warna: String)`.
// TODO: Buat class Pena
fun soal03_primaryConstructorVal(): String {
    // TODO: Return instance dari Pena berwarna "Biru" -> ambil warnanya
    return ""
}

// 4. Primary Constructor (Vars & Default value). Buat class `Buku(var halaman: Int = 100)`.
// TODO: Buat class Buku
fun soal04_primaryConstructorVar(): Int {
    // TODO: Buat instance Buku. UBAH halamannya jadi 500 karena ia 'var'. Return halamannya.
    return 0
}

// 5. Init Block. Buat class `Kipas(val merk: String)`. Di dalam class, buat var `isMenyala: Boolean = false`.
// Tambahkan blok `init { isMenyala = true }`.
// TODO: Buat class Kipas
fun soal05_initBlock(): Boolean {
    // TODO: Buat Kipas("Miyako"). Return isMenyala-nya.
    return false
}

// 6. Secondary Constructor. Buat class `Tas(val merk: String)`. 
// Tambahkan var `harga: Int = 0`.
// Tambahkan secondary constructor `constructor(merk: String, harga: Int) : this(merk)` yg menyetel var harga tsb!
// TODO: Buat class Tas
fun soal06_secondaryConstructor(): Int {
    // TODO: Buat Tas pakai secondary constructor (merk "Eiger", harga 250000). Return harganya.
    return 0
}

// 7. Encapsulation (Private & Getter). Buat class `Dompet`. 
// Beri `private var saldo = 0`. Buat fungsi `tambah(jumlah: Int)` dan `dapatSaldo(): Int` (getter).
// TODO: Buat class Dompet
fun soal07_encapsulation(): Int {
    // TODO: Buat Dompet, tambah 50, lalu return dapatSaldo()
    return 0
}

// 8. Custom Setter. Buat class `Jam`. Beri `var menit = 0`.
// Tambahkan blok custom setter `set(value) { field = if(value > 59) 0 else value }` persis di bawah `var menit`.
// TODO: Buat class Jam
fun soal08_customSetter(): Int {
    // TODO: Buat Jam, atur menit = 70. Return menitnya (harusnya jadi 0).
    return -1
}

// 9. Inheritance (Open Class). Buat `open class Hewan` dg fungsi `open fun suara() = "Mmm"`.
// Buat `class Sapi : Hewan()`. Override suara return "Moo".
// TODO: Buat open class Hewan dan class Sapi
fun soal09_inheritance(): String {
    // TODO: Buat objek Sapi dan panggil fungsi suaranya
    return ""
}

// 10. Memanggil Super Method. Buat `open class Pekerja` dg fungsi `open fun sapa() = "Halo"`.
// Buat `class Guru : Pekerja()`. Override `sapa()` spy return `super.sapa() + " Murid"`.
// TODO: Buat kelas Pekerja dan Guru
fun soal10_superMethod(): String {
    // TODO: Buat objek Guru dan return sapa()-nya (Halo Murid)
    return ""
}

// 11. Polymorphism dengan Interface. Buat interface `BisaTerbang` dg fungsi `terbang(): String`.
// Buat class `Burung` dan `Pesawat` yang mengimplementasikan interface tsb. (Return "Kepak" dan "Mesin").
// TODO: Buat interface BisaTerbang, dan class Burung, Pesawat
fun soal11_interface(): String {
    // TODO: Buat variabel Pesawat bertipe antarmuka BisaTerbang (val x: BisaTerbang = Pesawat()). Return terbangnya!
    return ""
}

// 12. Multiple Interfaces. Buat interface `BisaBerenang` (fun renang(): String).
// Class `Bebek` mengimplementasi `BisaTerbang` (dari soal 11) DAN `BisaBerenang` menggunakan tanda koma. 
// Bebek terbang return "Ngos-ngosan", renang return "Kwek".
// TODO: Buat interface BisaBerenang dan class Bebek
fun soal12_multipleInterface(): String {
    // TODO: Buat objek Bebek, gabungkan return terbang dan renang (contoh: "Ngos-ngosan Kwek")
    return ""
}

// 13. Abstract Class. Buat `abstract class Shape` dg `abstract fun area(): Int`.
// Buat `class Persegi(val sisi: Int) : Shape()`. Implementasikan area = sisi * sisi.
// TODO: Buat abstract class Shape dan Persegi
fun soal13_abstractClass(): Int {
    // TODO: Buat Persegi dg sisi 5. Return (Shape) area-nya.
    return 0
}

// 14. Visibility Modifiers: Protected.
// Buat `open class Rahasia` dg `protected val pin = 1234`.
// Buat `class AnakRahasia : Rahasia()` dg fungsi `fun bocorkan() = pin`.
// TODO: Buat class Rahasia dan AnakRahasia
fun soal14_protectedModifier(): Int {
    // TODO: Buat AnakRahasia, return fungsi bocorkan
    return 0
}

// 15. Companion Object (Static Member). Buat class `Pabrik`.
// Tambahkan `companion object { val LOKASI = "Jakarta" }` di dlmnya.
// TODO: Buat class Pabrik
fun soal15_companionObject(): String {
    // TODO: Return properti statis Pabrik.LOKASI
    return ""
}

// 16. Anonymous Object (Object Expression).
// Ada interface `BisaBerenang` dari soal 12. Buat objek *langsung di return function ini* pakai
// `return object : BisaBerenang { override fun renang() = "Byur" }`
fun soal16_anonymousObject(): Any? { // Ganti ke BisaBerenang jika sdh dibikin
    // TODO: return object : BisaBerenang
    return null
}

// ===================================
// ▶️ RUN
// ===================================
fun main() {
    Checker.printHeader("PART 5 - Classes & OOP Concepts (16 Soal)")
    Checker.checkEquals("Kursi", soal01_basicClass()?.javaClass?.simpleName, "Soal 1")
    Checker.checkEquals("Kayu", soal02_classProperty(), "Soal 2")
    Checker.checkEquals("Biru", soal03_primaryConstructorVal(), "Soal 3")
    Checker.checkEquals(500, soal04_primaryConstructorVar(), "Soal 4")
    Checker.checkEquals(true, soal05_initBlock(), "Soal 5")
    Checker.checkEquals(250000, soal06_secondaryConstructor(), "Soal 6")
    Checker.checkEquals(50, soal07_encapsulation(), "Soal 7")
    Checker.checkEquals(0, soal08_customSetter(), "Soal 8")
    Checker.checkEquals("Moo", soal09_inheritance(), "Soal 9")
    Checker.checkEquals("Halo Murid", soal10_superMethod(), "Soal 10")
    Checker.checkEquals("Mesin", soal11_interface(), "Soal 11")
    Checker.checkEquals("Ngos-ngosan Kwek", soal12_multipleInterface(), "Soal 12")
    Checker.checkEquals(25, soal13_abstractClass(), "Soal 13")
    Checker.checkEquals(1234, soal14_protectedModifier(), "Soal 14")
    Checker.checkEquals("Jakarta", soal15_companionObject(), "Soal 15")
    try {
        val mr = soal16_anonymousObject()
        val ren = mr?.javaClass?.getMethod("renang")?.invoke(mr)
        Checker.checkEquals("Byur", ren, "Soal 16 (Anonymous Object)")
    } catch(e:Exception){ Checker.checkEquals("Byur", "GAGAL", "Soal 16 Error")}
}
