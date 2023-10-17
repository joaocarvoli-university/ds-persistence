package dao

interface IGenericDAO<T> {
    fun save(objectT: T)
    fun update(objectTId: Int, objectT: T)
    fun delete(objectTId: Int)
    fun getById(objectTId: Int): T?
    fun getAll(): List<T>?
}