# Kotlin Roadmap Exercises 🚀

Selamat datang di proyek **Kotlin Roadmap Exercises**! Proyek ini dirancang untuk membantu Anda menguasai Kotlin melalui serangkaian latihan bertahap, mulai dari dasar hingga konsep lanjutan seperti Coroutines.

## 📁 Struktur Proyek

- **`RoadmapExercises/`**: Berisi file latihan (`_Latihan.kt`) dan kunci jawaban (`_Jawaban.kt`).
- **`RoadmapExercises/Checker.kt`**: Sistem koreksi otomatis yang mengecek jawaban Anda.

## 🛠️ Cara Menggunakan

### 1. Selesaikan Latihan
Buka file latihan (misal: `Phase1_1_VarDataTypes_Latihan.kt`) dan cari komentar `// TODO` atau fungsi yang belum selesai.

### 2. Jalankan Program
Anda dapat menjalankan latihan dengan dua cara:

#### **Lewat IDE (IntelliJ IDEA / Android Studio)**
Klik icon **Play (segitiga hijau)** di sebelah fungsi `main()` di bagian bawah file latihan.

#### **Lewat Terminal**
Jalankan perintah berikut di root folder proyek:
```bash
kotlinc RoadmapExercises/Checker.kt RoadmapExercises/Phase1_2_ControlFlow_Latihan.kt -include-runtime -d output.jar && java -jar output.jar
```
*(Ganti nama file latihan sesuai yang sedang dikerjakan)*

## 📚 Daftar Materi (Fase 1)

1. **Variables & Data Types** (`Phase1_1_VarDataTypes_Latihan.kt`)
2. **Control Flow** (`Phase1_2_ControlFlow_Latihan.kt`)
3. **Loops** (`Phase1_3_Loops_Latihan.kt`)
4. **Functions & Null Safety** (`Phase1_4_FunctionsNullSafety_Latihan.kt`)
5. **Classes & OOP** (`Phase1_5_ClassesOOP_Latihan.kt`)
6. **Data, Sealed, & Enum Classes** (`Phase1_6_DataSealedEnum_Latihan.kt`)
7. **Scope Functions** (`Phase1_7_ScopeFunctions_Latihan.kt`)
8. **Coroutines** (`Phase1_8_Coroutines_Latihan.kt`)

---
*Semoga berhasil belajarnya! Jika bingung, silakan cek file `_Jawaban.kt` sebagai referensi.*
