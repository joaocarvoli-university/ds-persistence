package deserializers

import EnvVars
import serializers.Serializable
import java.io.File
import java.io.FileOutputStream
import java.io.ObjectOutputStream

class SerializerObject<T: Any> : Serializable<T> {
    private lateinit var objectT: T
    private lateinit var fileName: String

    override fun addObject(objectT: T){
        this.objectT = objectT
    }

    override fun serialize(fileName: String){
        this.fileName = fileName
        writesObject()
    }

    override fun writesObject(){
        try {
            val file = File(EnvVars.BASE_PATH + fileName)
            ObjectOutputStream(FileOutputStream(file, true)).use { it.writeObject(objectT) }
        } catch (e: Exception){
            throw e
        }
    }
}