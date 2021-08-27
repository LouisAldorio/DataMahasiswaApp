package dao

import model.Student

class StudentDao : Dao<Student, String> {

    private var students = arrayListOf<Student>().apply {
        add(
            Student(
                "Tony Stark",
                "1",
                "Teknik Informatika",
                "4IA01",
                "Universitas Gunadharma"
            )
        )
        add(
            Student(
                "Bruce Banner",
                "2",
                "Teknik Elektro",
                "4IA02",
                "Universitas Pelita Harapan"
            )
        )
        add(
            Student(
                "Steve Rogers",
                "2",
                "Teknik Informatika",
                "4IA01",
                "Universitas Gunadharma"
            )
        )
    }

    override fun getData(): List<Student> {
        return students
    }

    override fun addData(item: Student) {
        students.add(item)
    }

    override fun deleteData(uniqueID: String) {
        students.remove(students.find { student ->
            student.nim == uniqueID
        })
    }
}