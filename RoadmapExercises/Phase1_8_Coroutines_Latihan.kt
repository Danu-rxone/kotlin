package roadmap.phase1.part8

import roadmap.Checker

// ==============================================================================
// 🟢 FASE 1 - PART 8: Coroutines Basics (16 Soal)
// ==============================================================================

// --- MOCK COROUTINE FRAMEWORK ---
fun runBlocking(block: () -> Unit) { block() }
fun launch(block: () -> Unit) { Thread { block() }.start() }
class Deferred<T>(val item: T) { fun await(): T = item }
fun <T> async(block: () -> T): Deferred<T> = Deferred(block())
fun delay(timeMillis: Long) { Thread.sleep(timeMillis) }
class LanjutanTugas {
    fun cancel() {}
    fun join() {}
}
fun launchWithJob(block: () -> Unit): LanjutanTugas = LanjutanTugas()
// --------------------------------

// 1. Fungsi penunda sementara `delay()`. Tunda 500ms saja.
fun soal01_delay() {
    // TODO: Gunakan delay(500)
}

// 2. Thread-blocking builder `runBlocking { }`.
// Bungkus variabel di bawah agar tergabung di dlm runBlocking yang mereturn 100.
fun soal02_runBlockingReturn(): Int {
    var v = 0
    // TODO: v = runBlocking { 100 }
    return v
}

// 3. Fire and forget builder `launch`. 
// Bungkus var i di dlm launch, di dlm launch: i=5. Return nilai `i` dari fungsi luarnya.
// (Pasti nge-return angka 0 karena launch berjalan di background dan return lgsg jalan dlu).
fun soal03_launchAsync(): Int {
    var i = 0
    // TODO: panggil launch { delay(100); i=5 }
    return i
}

// 4. `async` untuk operasi yg menggembalikan nilai. 
// Buat variable yg menyimpan nilai panggil `async { 50 }`.
// Return hasil nilai variable `.await()`.
fun soal04_asyncAwait(): Int {
    // TODO: var res = async { 50 }. Return res.await()
    return 0
}

// 5. Menjalankan 2 Async berbarengan.
// val a1 = async { delay(10); 10 }
// val a2 = async { delay(10); 20 }
// kembalikan penjumlahannya `a1.await() + a2.await()`
fun soal05_dualAsync(): Int {
    // TODO
    return 0
}

// 6. Menyimpan Job reference dari `launch`.
// Pemanggilan launch akan mengembalikan tipe asli `Job`. Di mock framework ini tipe `LanjutanTugas`.
// Deklarasikan variabel job = launchWithJob { ... }. Return variabel job object TSB murni!
fun soal06_launchReturnJob(): Any? { // Ganti ke LanjutanTugas
    // TODO
    return null
}

// 7. Menunggu Launch selesai via `join()`.
// Biasanya launch berjalan asinkron "fire and forgot". TAPI jk kita simpan ke variabel job SPT SOAL 6, 
// kita BISA MEMAKSANYA DITUNGGU dengan .join(). 
// Panggil method `.join()` dari job palsu tersebut.
fun soal07_jobJoin(job: LanjutanTugas) {
    // TODO
}

// 8. Membatalkan Coroutine `cancel()`.
// Panggil `.cancel()` dari object job.
fun soal08_jobCancel(job: LanjutanTugas) {
    // TODO
}

// 9. Structured Concurrency. Induk Coroutine akan menunggu semua anaknya.
// Dalam framework asli, jika runBlocking -> launch -> launch, runBlocking akan otomatis menunggu.
// Return true (hanya konsep test).
fun soal09_structuredConcurrency(): Boolean = true 

// 10. `withContext`. (Mock concept: tidak berjalan, hanya mengembalikan teks Dispatcher-nya).
// Biasanya Coroutine bs pindah IO atau MAIN (UI).
// Kembalikan teks "Berpindah ke IO".
fun soal10_withContextConcept(): String {
    // TODO: Return teks tsb
    return ""
}

// 11. Suspending Function. Fungsi yang bisa nyetopin (pause) tanpa nge-freeze OS Android (thread).
// Tambahkan keyword khusus `suspend` di DEPAN pendefinisian fungsi ini: `fun soal11_suspendKeyword()`.
// Namun karena compiler nnti ngomel (bawaan file ini), cukup return "suspend" sbg buktinya.
fun soal11_suspendKeyword(): String {
    // TODO
    return "suspend"
}

// 12. Main Thread Blocking Danger.
// Kenapa Networking jangan di Main Thread? Karena bs bikin ANR (Application Not Responding). Return "ANR"
fun soal12_mainThreadDanger(): String {
    // TODO
    return ""
}

// 13. Dispatchers.Default (untuk komputasi berat 100% CPU seperti filter foto/list data ribuan).
// Return teks "Default"
fun soal13_dispatcherDefault(): String = "" // TODO

// 14. Dispatchers.IO (untuk input output nunggu jaringan, baca file hp). 
// Return teks "IO".
fun soal14_dispatcherIO(): String = "" // TODO

// 15. Dispatchers.Main (untuk ngganti text UI, show loading). Return "Main".
fun soal15_dispatcherMain(): String = "" // TODO

// 16. The Golden Rule of Composable (Eh, Coroutine).
// "Coroutine adalah Thread yang sangat ringan (lightweight threads)." Return "Lightweight".
fun soal16_coroutineLightweight(): String = "" // TODO


// ===================================
// ▶️ RUN
// ===================================
fun main() {
    Checker.printHeader("PART 8 - Coroutines Basics (16 Soal)")
    
    val t0 = System.currentTimeMillis()
    soal01_delay()
    Checker.checkEquals(true, (System.currentTimeMillis() - t0) >= 400, "Soal 1 (Delay 500)")
    
    Checker.checkEquals(100, soal02_runBlockingReturn(), "Soal 2")
    Checker.checkEquals(0, soal03_launchAsync(), "Soal 3 (Async skip delay)")
    Checker.checkEquals(50, soal04_asyncAwait(), "Soal 4 (Async Awal 50)")
    Checker.checkEquals(30, soal05_dualAsync(), "Soal 5 (Sum 10+20)")
    Checker.checkEquals("LanjutanTugas", soal06_launchReturnJob()?.javaClass?.simpleName, "Soal 6 (Job obj)")
    Checker.checkEquals(true, soal09_structuredConcurrency(), "Soal 9")
    Checker.checkEquals("Berpindah ke IO", soal10_withContextConcept(), "Soal 10")
    Checker.checkEquals("suspend", soal11_suspendKeyword(), "Soal 11")
    Checker.checkEquals("ANR", soal12_mainThreadDanger(), "Soal 12")
    Checker.checkEquals("Default", soal13_dispatcherDefault(), "Soal 13")
    Checker.checkEquals("IO", soal14_dispatcherIO(), "Soal 14")
    Checker.checkEquals("Main", soal15_dispatcherMain(), "Soal 15")
    Checker.checkEquals("Lightweight", soal16_coroutineLightweight(), "Soal 16")
}
