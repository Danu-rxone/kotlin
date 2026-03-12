package roadmap.mockandroid

import roadmap.Checker

// ==============================================================================
// 🟡 FASE 2 SAMPAI 8: ANDROID & ARCHITECTURE (LATIHAN Mock API)
// Karena kita tidak menjalankan ini di Android Studio app nyata,
// saya membuat "Mock Framework" buatan untuk mensimulasikan Android.
// ==============================================================================

// --- MOCK ANDROID FRAMEWORK --- (Jangan diedit)
class Context
class Intent(val context: Context, val targetClass: String) {
    val extras = mutableMapOf<String, String>()
    fun putExtra(key: String, value: String) { extras[key] = value }
}
abstract class ViewModel {
    var isCleared = false
    fun clear() { isCleared = true }
}
class MutableStateFlow<T>(var value: T)

// Mock Room Annotations
annotation class Entity(val tableName: String = "")
annotation class PrimaryKey(val autoGenerate: Boolean = false)
annotation class Dao
annotation class Query(val value: String)
// ----------------------------------------------


// ---------------------------------------------------------
// SOAL 1: Android Fundamentals (Intents)
// Diminta: Buat dan kembalikan sebuah instance class 'Intent' untuk berpindah
// ke "HomeActivity".
// Masukkan data (putExtra) dengan key "userId" dan value "A001".
// ---------------------------------------------------------
fun soal1_pindahActivity(context: Context): Intent {
    // TODO: Buat Intent, isi data, dan return
    return Intent(context, "")
}

// ---------------------------------------------------------
// SOAL 2: Jetpack Compose Concept (State)
// Jetpack Compose sangat bergantung pada State. 
// Buat data class 'UiState' yang memiliki:
// 1. isLoading: Boolean (default false)
// 2. dataItem: List<String> (default listOf())
// Lalu kembalikan instance UiState dengan isLoading = true.
// ---------------------------------------------------------
// TODO: Buat data class UiState di sini

fun soal2_composeState(): Any? { // Ganti Any? menjadi UiState
    return null
}

// ---------------------------------------------------------
// SOAL 3: Architecture (MVVM & StateFlow)
// 1. Buat class 'MainViewModel' yang inherit dari (extends) class 'ViewModel'.
// 2. Di dalamnya, buat property 'counterState' menggunakan MutableStateFlow dengan nilai awal 0.
// 3. Buat fungsi 'increment()' di dalam kelas tersebut yang menambah value counterState sebanyak 1.
// 4. Return instance MainViewModel dari fungsi di bawah.
// ---------------------------------------------------------
// TODO: Buat class MainViewModel di sini

fun soal3_mvvm(): ViewModel? {
    // TODO: Return instance()
    return null
}

// ---------------------------------------------------------
// SOAL 4: Local Database (Room Mock)
// 1. Buat data class 'Note' dan berikan annotation @Entity(tableName = "notes_table")
// 2. Di dalam class Note, buat property 'id' bertipe Int berikan @PrimaryKey(autoGenerate = true)
// 3. Tambahkan property 'title' bertipe String
// 
// Kembalikan return true murni (Ini hanya tes kompilasi penulisan annotation).
// ---------------------------------------------------------
// TODO: Buat @Entity Note di sini

fun soal4_roomDatabase(): Boolean {
    // Return true jika class Note di atas tidak error (Bisa dicompile)
    return false 
}


// ==============================================================================
// ▶️ RUN KODE DI BAWAH INI UNTUK AUTOKOREKSI (Jalankan fungsi main)
// ==============================================================================
fun main() {
    Checker.printHeader("FASE 2 s/d 8 - ANDROID MODERN & ARCHITECTURE")
    
    // Test 1
    val intent = soal1_pindahActivity(Context())
    val intentOk = intent.targetClass == "HomeActivity" && intent.extras["userId"] == "A001"
    Checker.checkCondition(intentOk, "Soal 1 (Intents)", "Intent dikonfigurasi dengan benar!", "Target Activity atau Extra salah.")
    
    // Test 2
    val state = soal2_composeState()
    val isUiStateLoading = state.toString().contains("isLoading=true")
    Checker.checkCondition(isUiStateLoading, "Soal 2 (Compose State)", "State benar", "Bukan UiState / Loading != true.")
    
    // Test 3
    val vm = soal3_mvvm()
    var incrementSukses = false
    try {
        val counterProperty = vm?.javaClass?.getDeclaredField("counterState")
        counterProperty?.isAccessible = true
        val stateFlow = counterProperty?.get(vm) as MutableStateFlow<Int>
        val incrementMethod = vm.javaClass.getDeclaredMethod("increment")
        incrementMethod.invoke(vm)
        incrementSukses = stateFlow.value == 1
    } catch (e: Exception) {
        // Ignored, berarti class tidak diimplementasi benar
    }
    Checker.checkCondition(incrementSukses, "Soal 3 (MVVM StateFlow)", "ViewModel dan Increment bekerja!", "Fungsi/Property ViewModel tidak ditemukan atau alurnya salah.")
    
    // Test 4
    Checker.checkEquals(true, soal4_roomDatabase(), "Soal 4 (Room Database Annotations)")
}
