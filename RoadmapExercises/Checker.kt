package roadmap

// ==============================================================================
// 🛠️ CHECKER ENVIRONMENT
// Ini adalah sistem koreksi otomatis. Anda TIDAK PERLU mengubah file ini.
// Cara kerjanya: Cukup jalankan fungsi main() di file Latihan yang Anda kerjakan.
// ==============================================================================

object Checker {
    
    fun checkEquals(expected: Any?, actual: Any?, soal: String) {
        if (expected == actual) {
            println("✅ $soal: BENAR! (Output: $actual)")
        } else {
            println("❌ $soal: SALAH.")
            println("   -> Jawaban Anda : $actual")
            println("   -> Seharusnya   : $expected")
        }
    }

    fun checkCondition(condition: Boolean, soal: String, successMsg: String = "Test Passed", errorMsg: String = "Test Failed") {
        if (condition) {
            println("✅ $soal: BENAR! ($successMsg)")
        } else {
            println("❌ $soal: SALAH. $errorMsg")
        }
    }
    
    fun printHeader(title: String) {
        println("\n" + "=".repeat(50))
        println("🚀 KOREKSI: $title 🚀")
        println("=".repeat(50))
    }
}
