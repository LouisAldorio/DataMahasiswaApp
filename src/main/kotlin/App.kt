import model.Student
import kotlin.system.exitProcess

class App {

    private val daoObject = dao.StudentDao()

    companion object {
        
        @JvmStatic
        fun main(args: Array<String>) {
            App().start()
        }
    }

    fun start() {
        navigateToMainMenu()
    }

    private fun printHeader() {
        println("""
            ==============================
            Aplikasi Data Mahasiswa
            ==============================
            1. Cetak Semua Data Mahasiswa
            2. Tambah Data Mahasiswa
            3. Hapus Data Mahasiswa
            4. Keluar
            ==============================
            Masukan Pilihan (1,2,3,4) ?
            ==============================
        """.trimIndent())
    }

    private fun navigateToMenu(menu : String) {
        when(menu) {
            "1" -> {
                openMenuPrintStudent()
            }
            "2" -> {
                openMenuAddStudent()
            }
            "3" -> {
                openMenuDeleteStudent()
            }
            "4" -> {
                exitProcess(0)
            }
            else -> {
                println("Pilihan Tidak Ada")
            }
        }
        askToMainMenu()
    }

    private fun openMenuDeleteStudent() {
        println("======================================")
        print("Hapus Data Dengan NIM = ")
        readLine()?.let {
            daoObject.deleteData(it)
        }
        println("======================================")
        println("Hapus Data Berhasil")
    }

    private fun openMenuAddStudent() {
        println("======================================")
        print("Nama Mahasiswa = ")
        val name = readLine().orEmpty()
        print("NIM Mahasiswa = ")
        val nim = readLine().orEmpty()
        print("Jurusan Mahasiswa = ")
        val major = readLine().orEmpty()
        print("Kelas = ")
        val classname = readLine().orEmpty()
        print("Nama Universitas = ")
        val univ = readLine().orEmpty()
        daoObject.addData(Student(name,nim,major,classname,univ))
        println("======================================")
        println("Insert Data Berhasil")
    }

    private fun openMenuPrintStudent() {
        val students = daoObject.getData()
        if(students.isNotEmpty()) {

            students.forEachIndexed { index, student ->
                println("==========================================")
                println("Mahasiswa ke - ${index + 1}")
                println("==========================================")
                println("Nama        : ${student.name}")
                println("NIM         : ${student.nim}")
                println("Jurusan     : ${student.major}")
                println("Kelas       : ${student.className}")
                println("University  : ${student.university}")
            }
        }else {
            println("==========================================")
            println("Tidak Ada Data!")
            println("==========================================")
        }
    }

    private fun askToMainMenu() {
        println("""
            ====================================
            Kembali ke menu utama ? (Y/N)
            ====================================
        """.trimIndent())

        if(readLine().equals("Y", ignoreCase = true)) {
            navigateToMainMenu()
        }else {
            exitProcess(0)
        }
    }

    private fun navigateToMainMenu() {
        printHeader()
        readLine()?.let {
            navigateToMenu(it)
        }
    }
}