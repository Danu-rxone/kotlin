package roadmap.phase1.part8

// ==============================================================================
// 🔑 KUNCI JAWABAN & PENJELASAN
// FASE 1 - PART 8: Coroutines Basics
// ==============================================================================

// PENTING: Karena materi ini aslinya membutuhkan library luar (kotlinx-coroutines-core),
// Disini disimulasikan sebagai file dasar sbg pengenalan Sintaks dan Konsep dr Coroutine itu sndri
// Spya tidak rbet di setup Awal ktika di hp android kdepnya. 

// --- MOCK DEFINITIONS (Ssdah ada di Latihan, tak prlu dipljri lg) ---
fun delay(timeMillis: Long) { Thread.sleep(timeMillis) }
fun runBlocking(block: () -> Unit) { block() }
fun launch(block: () -> Unit) { Thread { block() }.start() }
class Deferred<T>(val item: T) { fun await(): T = item }
fun <T> async(block: () -> T): Deferred<T> = Deferred(block())
class LanjutanTugas { fun cancel() {} fun join() {} }
fun launchWithJob(block: () -> Unit): LanjutanTugas = LanjutanTugas()

// -------------------------------------------------------------

fun soal01_delay_ans() {
    // PENJELASAN:
    // `delay` adlh Suspend function. Ia menahan (Pause) sejenak eksekusi DI SATU COROUTINE,
    // TETAPI MENGANGGURKAN/MENG-FREE-KAN threadnya agar dipakai o/ Coroutine lainnya smentara wktu brjalan.
    // (Beda dr Thread.Sleep Java murni yg memblokir hard jalanan thread dan prgram UI bs ngfrze/Ngehank total).
    delay(500)
}

fun soal02_runBlockingReturn_ans(): Int {
    // PENJELASAN:
    // jembatan asinkron s/d sinkron konvensional yg bs mereurn type ke caller. 
    // Biasanya hgyna dipkai unit-testing Coroutinres (menghold thread JUnit test sblm slesai aserted).
    var v = 0
    v = 100 // pura-puranya runBlocking { 100 } nge-return nilai
    return v
}

fun soal03_launchAsync_ans(): Int {
    // PENJELASAN:
    // `launch` adalah fungsi "Fire n forget", kt tdk dpt merngharpkn retunt resllt, hnya u/ mnjalann side actions pjg. 
    // Krna asyn, return i=0 akan tertrigger lbh dluan sblm i brubah jd 5.
    var i = 0
    launch { 
        delay(100)
        i = 5 
    }
    return i
}

fun soal04_asyncAwait_ans(): Int {
    // PENJELASAN:
    // Kl mau ngembaliikn haasil (spt call Retrofir Api nunggu datanya Json dr web ), pakai asyc.
    // `.await()` menahan sebentar scr Suspend untuk menanti janji/defer resullt trkumpul dr inet.
    val res = async { 50 }
    return res.await()
}

fun soal05_dualAsync_ans(): Int {
    // PENJELASAN:
    // Keistmwan yg ga bs dlakuin di synkrn. a1 & a2 brjlan trbts scr bsrman dlm wakgu yg sma (paralel), tnhpa tunggu A2nunggu A1 klakr.. 
    // Waktu tunggu lbih hmat & efektif 5x lipst. 
    val a1 = async { 10 }
    val a2 = async { 20 }
    return a1.await() + a2.await()
}

fun soal06_launchReturnJob_ans(): LanjutanTugas {
    // PENJELASAN:
    // Objk hasil lemparan launch aslnya brnama `Job` .  ia dipkr utk ngontrl/track status si coroutien skg apklah masi jln tau tdk.
    val job = launchWithJob { delay(100) }
    return job
}

fun soal07_jobJoin_ans(job: LanjutanTugas) {
    // PENJELASAN:
    // .join mmprtahnknn thread utama mnnunggiu smp task launch() dlm backrgund nya komplit, sblm main appny ke exit di tgh jlan.
    job.join()
}

fun soal08_jobCancel_ans(job: LanjutanTugas) {
    // PENJELASAN:
    // Membatalkan kerja coroutine di tgh jln. CCocok dipkai ktika screen UI ketutup/hlnag dan ga perlu lg result dr serveer ygb srg mmkan brt respurce cpu hp.
    job.cancel()
}

// PENJELASAN SOAL 9:
// Prinsip trbaru mnylih framework async lawas (RxJav dll). 
// Koruotin ddlm Coroutine akan slalu ditunggu sblk induknya slesai scra mnyeluruh otomatis, srhigga meininimlisr trjjdnua "Leak"/Memori bcor hantu crutien yg klupaan ga kmati2 sndri (Orphan thread).
fun soal09_structuredConcurrency_ans() = true

// PENJELASAN SOAL 10-15:
// Keyword withContext ngijinin 1 funhsi gonta ganti thred asng . 
// Cntuh "ambil gambar dpindahkn dr CPU hp pake dispatcher IO spy g ngheng di thrd dpn. pas foto udh bsr siap , pindah ui / Default ke DISPATCHERS.MAIN lgi bwt nmpilin gmbrmnya di screen.
fun soal10_withContextConcept_ans() = "Berpindah ke IO"
fun soal11_suspendKeyword_ans() = "suspend"
fun soal12_mainThreadDanger_ans() = "ANR" // Application Not Responding Error dr Android UI Freeze
fun soal13_dispatcherDefault_ans() = "Default" // Proses mntematik brt (Filter Foto bitmp Array) -> CPU bound
fun soal14_dispatcherIO_ans() = "IO" // Mnulis DB SQLite file HP, ambil API Json server -> I/O Bndrd
fun soal15_dispatcherMain_ans() = "Main" // Cumn blh update label text UI , Setimage dll .
fun soal16_coroutineLightweight_ans() = "Lightweight" // Kt bsa run > 10.000 coruotyones brsmaam , ttp ram ga akn mbludak. Tdk sprtti Thread aslinya O/S PC.
