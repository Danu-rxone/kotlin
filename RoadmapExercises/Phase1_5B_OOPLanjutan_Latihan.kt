package roadmap.phase1.part5b

import roadmap.Checker

// ==============================================================================
// 🟢 FASE 1 - PART 5B: OOP LANJUTAN (15 Soal)
// Fokus: Encapsulation, Inheritance, Interface, Polymorphism
// ==============================================================================

// ========= ENCAPSULATION =========
// 1. Private Setter. 
// Buat class `Rekening` dengan properti `var saldo: Int = 0`.
// Batasi (encapsulate) agar member dari luar class bisa BACA saldo, tapi TIDAK BISA MENGUBAH / SET saldonya secara langsung.
// Cara merubahnya hanya lewat fungsi `fun setor(uang: Int)`.
// TODO: Buat class Rekening
fun soal01_privateSetter(): Int {
    // TODO: Buat Rekening, jalankan setor(100), lalu return saldo-nya.
    return 0
}

// 2. Backing Property. Terkadang butuh property yang terekspos sbg List Read-Only, tp di dalam class sbg MutableList.
// Buat class `Koleksi`. Di dalam miliki `private val _items = mutableListOf<String>()` (Backing property).
// Ekspos sbg `val items: List<String> get() = _items`.
// Buat fungsi `fun tambah(item: String) { _items.add(item) }`.
// TODO: Buat class Koleksi
fun soal02_backingProperty(): List<String> {
    // TODO: Buat class Koleksi, tambah("A"), tambah("B"). Return list items-nya.
    return emptyList()
}


// ========= INHERITANCE =========
// 3. Overriding Properties. 
// Buat `open class Kendaraan { open val jumlahRoda: Int = 0 }`.
// Buat turunan `class Motor : Kendaraan() { override val jumlahRoda: Int = 2 }`.
// TODO: Buat class Kendaraan dan Motor.
fun soal03_overrideProperty(): Int {
    // TODO: Return jumlahRoda dari Motor.
    return 0
}

// 4. Overriding Constructor Parameter (Cara rintas Override Property).
// Buat `open class Senjata(open val damage: Int)`.
// Buat `class Pedang(override val damage: Int) : Senjata(damage)`.
// TODO: Buat class Senjata dan Pedang
fun soal04_overrideConstructorParam(): Int {
    // TODO: Return damage dari Pedang(50).
    return 0
}

// 5. Calling Super Implementation.
// Buat `open class AkunGame { open fun tier() = "Bronze" }`.
// Buat `class AkunPro : AkunGame() { override fun tier() = super.tier() + "-Pro" }`.
// TODO: Buat class AkunGame dan AkunPro
fun soal05_superCall(): String {
    // TODO: Return tier() dari AkunPro.
    return ""
}


// ========= INTERFACE =========
// 6. Mengimplementasikan Interface dengan Property.
// Buat interface `PunyaNama { val nama: String }`.
// Buat `class Karyawan(override val nama: String) : PunyaNama`.
// TODO: Buat interface PunyaNama dan class Karyawan
fun soal06_interfaceProperty(): String {
    // TODO: Buat Karyawan("Agus"). Return namanya.
    return ""
}

// 7. Interface Default Validasi (Default Implementation).
// Interface di Kotlin BISA punya body (implementasi default) tanpa harus dioverride jika mmg tidak perlu!
// Buat Interface `BisaJalan { fun jalan() = "Sedang Jalan" }`.
// Buat `class Orang : BisaJalan` (Biarkan body kosong, dia otomatis punya kemampuan jalan()).
// TODO: Buat Interface BisaJalan dan Class Orang
fun soal07_interfaceDefaultMethod(): String {
    // TODO: Panggil jalan() dari objek Orang.
    return ""
}

// 8. Resolusi Konflik Interface ganda (Multiple Interface dengan nama method sama).
// Buat `interface A { fun print() = "A" }` dan `interface B { fun print() = "B" }`.
// Buat `class C : A, B { override fun print(): String { /* panggil super<A>.print() + super<B>.print() */ } }`.
// TODO: Buat antarmuka A, B dan class C
fun soal08_interfaceConflict(): String {
    // TODO: Return hasil C().print() (Seharusnya berisi gabungan misal "AB")
    return ""
}


// ========= POLYMORPHISM =========
// 9. Polymorphism Dasar (Subtyping).
// Menggunakan class Senjata dan Pedang yang sudah kalian buat di Soal 4!
// Buat `class Panah(override val damage: Int) : Senjata(damage)`.
// TODO: Buat fungsi `serang(s: Senjata): String` yang mereturn "Serang menghasilkan ${s.damage} damage".
fun soal09_polymorphismFunction(): String {
    // TODO: Lempar sebuah Panah(20) BUKAN SENJATA AWAL ke dalam pemanggilan fungsi serang(s). Return teksnya.
    return ""
}

// 10. List Polymorphism.
// Tahu kah Anda, Koleksi List bisa memegang berbagai turunan dari 1 Bapak yang sama?
// Buat List<Senjata> yang berisi listOf(Pedang(10), Panah(15)). 
// Uji iterasi tiap itm dan hitung Total Damage dari keduanya. Return totalnya (Int).
fun soal10_polymorphismList(): Int {
    // TODO: Return 10 + 15 via loop list polymorphism.
    return 0
}

// 11. Type Casting (The `as` operator). Unsafe cast.
// Kadang ada objek polimorfisme Any (yg sbnrnya String).
// Gunakan `arg as String` secara eksplisit, lalu return huruf pertamanya `[0]`.
fun soal11_unsafeCasting(arg: Any): Char {
    // TODO: Cast arg sebagai String dan return char pertamanya.
    return ' '
}

// 12. Safe Casting (The `as?` operator).
// Jika `as` biasa akan crash (Exception) kl gagal cast.
// Gunakan `as?` untuk mencegah crash. Berikan masukan Integer Int(10) ke param.
// Cast `arg as? String` dan tangkap nilainya yg dijamin mnjadi Null (krna dilarang mng-cast Int jd String lgsg). 
// Jika jadi null, elvis ?: "Bukan Teks".
fun soal12_safeCasting(arg: Any): String {
    // TODO: return arg as? String ?: "Bukan Teks"
    return ""
}


// ========= ADVANCE OOP CLASS =========
// 13. Abstract Class dengan Abstract Property.
// Buat abstract class `Bangunan { abstract val harga: Int }`.
// Buat turunan `class Rumah : Bangunan() { override val harga = 500 }`.
// TODO: Buat class Bangunan dan Rumah
fun soal13_abstractProperty(): Int {
    // TODO: Return harga dari Rumah.
    return 0
}

// 14. Nested Class (Kelas Bersarang biasa - Tanpa koneksi ke Parent/Luar).
// Buat `class Luar { class Dalam { fun cetak() = "Ini Dalam" } }`.
// TODO: Buat class Luar.Dalam
fun soal14_nestedClass(): String {
    // TODO: Instansiasi langsung dari luar (`Luar.Dalam().cetak()`). Return hasilnya.
    return ""
}

// 15. Inner Class (Terkoneksi dengan instance Parent/Luar).
// Buat `class Induk(val id: Int) { inner class Anak { fun cetak() = "Anak dari $id" } }`.
// TODO: Buat class Induk
fun soal15_innerClass(): String {
    // TODO: Berbeda dg nested biasa, mmbuat Inner class harus membuat bapaknya dlu!
    // Instansiasi `Induk(99).Anak().cetak()`.
    return ""
}

// ===================================
// ▶️ RUN
// ===================================
fun main() {
    Checker.printHeader("PART 5B - OOP Lanjutan (15 Soal)")
    Checker.checkEquals(100, soal01_privateSetter(), "Soal 1")
    Checker.checkEquals(listOf("A", "B"), soal02_backingProperty(), "Soal 2")
    Checker.checkEquals(2, soal03_overrideProperty(), "Soal 3")
    Checker.checkEquals(50, soal04_overrideConstructorParam(), "Soal 4")
    Checker.checkEquals("Bronze-Pro", soal05_superCall(), "Soal 5")
    Checker.checkEquals("Agus", soal06_interfaceProperty(), "Soal 6")
    Checker.checkEquals("Sedang Jalan", soal07_interfaceDefaultMethod(), "Soal 7")
    Checker.checkEquals(true, soal08_interfaceConflict().contains("A") && soal08_interfaceConflict().contains("B"), "Soal 8")
    Checker.checkEquals("Serang menghasilkan 20 damage", soal09_polymorphismFunction(), "Soal 9")
    Checker.checkEquals(25, soal10_polymorphismList(), "Soal 10")
    Checker.checkEquals('H', soal11_unsafeCasting("Halo"), "Soal 11")
    Checker.checkEquals("Bukan Teks", soal12_safeCasting(123), "Soal 12")
    Checker.checkEquals(500, soal13_abstractProperty(), "Soal 13")
    Checker.checkEquals("Ini Dalam", soal14_nestedClass(), "Soal 14")
    Checker.checkEquals("Anak dari 99", soal15_innerClass(), "Soal 15")
}
