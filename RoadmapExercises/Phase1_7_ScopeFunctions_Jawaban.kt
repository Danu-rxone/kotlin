package roadmap.phase1.part7

// ==============================================================================
// 🔑 KUNCI JAWABAN & PENJELASAN
// FASE 1 - PART 7: Scope Functions
// ==============================================================================
class Gadget {
    var merk: String = ""
    var memori: Int = 0
    var isNyala: Boolean = false
    override fun toString() = "$merk-$memori-$isNyala"
}

fun soal01_letLength_ans(input: String): Int {
    // PENJELASAN: 
    // `let` adalah Extension function. Ia menrujuk objeck penerimanya menmnggunakan kata ganti "it". 
    // Niliai palling akhir dr dalam let akan dikembalikan di sbg nilai dr kseluruhan let expression `input.let`.
    return input.let { it.length }
}

fun soal02_letNullCheck_ans(isian: String?): String {
    // PENJELASAN: 
    // Safe Call (?.let) menjamin bahwa isian di dalam tanda keriting { } 
    // DIPASTIKAN BUKAN LAGI NULL, alias sudah sngat brsih.
    return isian?.let { it.uppercase() } ?: "KOSONG"
}

fun soal03_letRenameIt_ans(input: String): String {
    // PENJELASAN: 
    // Jika scope let bersrng dan kt kebinggungan mengartikan apkah "it" pnya scope trdlm / luar.
    // kt bisa mnmerikan aliasnya dgn memnggunakan tnda Panah `nama -> `.
    return input.let { teks -> teks.reversed() }
}

fun soal04_applyInit_ans(): Gadget {
    // PENJELASAN: 
    // `apply` sangat ccok dipakai untk inisialisasi / cponfig Objek. 
    // Karena ia tdk memenggunakan "it", melainkan brada di dalam object tsb sndr sbg "this" (Bisa dklngkhin/dkosong).
    // Kembaliannya PASTILAH objeck si penerima itu sendri shg lgsng siap dilempar ke caller.
    return Gadget().apply {
        merk = "Nokia"
        memori = 32
        isNyala = true
    }
}

fun soal05_applyUpdate_ans(g: Gadget): Gadget {
    // PENJELASAN: 
    // Merubah nilai properti memori objek internal via apply dgn this referentl (scr implisit g.memori += 64). 
    return g.apply {
        memori += 64
    }
}

fun soal06_runCheck_ans(g: Gadget): String {
    // PENJELASAN: 
    // Fungsi `run` hnya brbda sbts nilai returnannya dr APPLY dr pda mengembalikan onj, run mnngembkilan LAMBDA block nya (bris trskhir di brs).
    return g.run {
        if (isNyala) "Hidup" else "Mati"
    }
}

fun soal07_runNonExtension_ans(): Int {
    // PENJELASAN: 
    // Fungi scope buasnya, run brdiri sndiri bermanffat mngtngani scope lokal sngkat tanpa mencemari parent lvar dgn prspsesn temp. variable di lusrnya.
    return run {
        val x = 10
        val y = 20
        x + y
    }
}

fun soal08_withGabung_ans(g: Gadget): String {
    // PENJELASAN: 
    // `with` itu sbnernya identik fungsinya sm sperti .run extension. 
    // Mngkin trllh lbh enak dibaca ala bhsa ingris spt "Bersama si (Gadget X), lakukan {...}".
    return with(g) {
        "$merk bermemori $memori"
    }
}

fun soal09_withCalculation_ans(g: Gadget): Boolean {
    // PENJELASAN: 
    // Mereturn result operasi perhitungan dr objek yang sama yg jd subj.
    return with(g) {
        memori > 128
    }
}

fun soal10_alsoLog_ans(angka: List<Int>): List<Int> {
    // PENJELASAN: 
    // Mirp let , tp merngembalikan objek trsebt. 
    // Bs diartikn sbagai .also { "(DAN JUGA) sy ingin intip isi angknya mksih ,  tnpa mngabauikan / mrubah chain proses utama nya!!"}.
    return angka.also {
        val sz = it.size
        // println("Size list = $sz")
    }
}

fun soal11_alsoAction_ans(listStrings: MutableList<String>): MutableList<String> {
    // PENJELASAN: 
    // Rename with "also" brjalan bs sama kek let via arrow naming pointer.
    return listStrings.also { data ->
        data.add("Z")
    }
}

fun soal12_chainLetApply_ans(nama: String?): Gadget {
    // PENJELASAN: 
    // Pnggabungan yg sgt lazim. Sering digunakan mmparsing json strng mnjdi Class DTO yg clean..dsb.
    return nama?.let { 
        Gadget().apply { merk = it }
    } ?: Gadget().apply { merk = "-1" } 
}

fun soal13_takeIf_ans(angka: Int): Int {
    // PENJELASAN: 
    // Filter inline.. ambilJIKA angka itu bs memenuhi syrat di dalam {}, jika ia brmslah, ganti saja dng nilai null hmpaa.
    return angka.takeIf { it > 50 } ?: -1
}

fun soal14_takeUnless_ans(input: String): String {
    // PENJELASAN: 
    // Kebalikan dr .takeIf (Ambil kecuali klo inputnya mnjd bgni { ... }.
    return input.takeUnless { it.isEmpty() } ?: "Kosong"
}

fun soal15_applyAlsoCombination_ans(): Gadget {
    // PENJELASAN: 
    // .Also biyasnya hnya mluingkup aksi SIDE-EFFECT (logger print dsb) , .apply ngubah logic state / nilai var .
    return Gadget().apply {
        merk = "Samsung"
    }.also {
        // Log/Print it.merk
    }
}

fun soal16_quizMengingat_ans(): String {
    // PENJELASAN: 
    // RULE OF THUMB:
    // T/this -> `run`, `with`, `apply`.
    // I/it   -> `let`, `also`.
    // R/Return result-> `let`, `run`, `with`.
    // O/Return obj -> `apply`, `also`.
    return "let=it,apply=this"
}
