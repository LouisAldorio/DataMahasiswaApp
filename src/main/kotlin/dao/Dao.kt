package dao

// <T> is a generic class that compatible with any type of class
// <> is called diamond operator
interface Dao<T, UID> { // val dao : Dao<Student, String> = StudentDao
    fun getData(): List<T>
    fun addData(item: T)
    fun deleteData(uniqueID: UID)
}