package deserializers

interface Deserializable<T> {
    fun addObject(objectT: T)
    fun deserialize(fileName: String): T
    fun readsObject()
}