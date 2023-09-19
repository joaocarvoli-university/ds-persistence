package serializers

import EnvVars
import deserializers.Deserializable
import java.io.*

class DeserializerObject<T: Any>: Deserializable<T> {
    private lateinit var objectT: T
    private lateinit var fileName: String

    override fun addObject(objectT: T){
        this.objectT = objectT
    }

    override fun deserialize(fileName: String): T {
        this.fileName = fileName
        readsObject()
        return objectT
    }

    override fun readsObject(){
        try {
            val file = File(EnvVars.BASE_PATH + fileName)
            ObjectInputStream(FileInputStream(file)).use { this.objectT = it.readObject() as T }
        } catch (e: Exception){
            //throw e
            println(e.message)
        }
    }
}