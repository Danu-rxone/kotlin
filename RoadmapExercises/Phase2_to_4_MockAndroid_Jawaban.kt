package roadmap.mockandroid

// ==============================================================================
// 🔑 FASE 2 SAMPAI 8: ANDROID & ARCHITECTURE (KUNCI JAWABAN)
// ==============================================================================

// SOAL 1
fun soal1_pindahActivity_jawaban(context: Context): Intent {
    val intent = Intent(context, "HomeActivity")
    intent.putExtra("userId", "A001")
    return intent
}

// SOAL 2
data class UiState(
    val isLoading: Boolean = false,
    val dataItem: List<String> = listOf()
)

fun soal2_composeState_jawaban(): UiState {
    return UiState(isLoading = true)
}

// SOAL 3
class MainViewModel : ViewModel() {
    val counterState = MutableStateFlow(0)
    
    fun increment() {
        counterState.value += 1
    }
}

fun soal3_mvvm_jawaban(): MainViewModel {
    return MainViewModel()
}

// SOAL 4
@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0, // Inisialisasi default id = 0 sangat disarankan Room
    val title: String
)

fun soal4_roomDatabase_jawaban(): Boolean {
    // Dengan Note Data Class di atas yang berhasil dibuat, kita me return true
    return true
}
