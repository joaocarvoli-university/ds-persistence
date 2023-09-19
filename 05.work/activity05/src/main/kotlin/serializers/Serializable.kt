package serializers

interface Serializable<T> {
    fun addObject(objectT: T)
    fun serialize(fileName: String)
    fun writesObject()
}