package utils

import java.io.FileInputStream
import java.io.IOException
import java.util.*


object PropertiesReader {
    private var properties : MutableMap<String, String>? = null
    private var propertyFileName = ""

    fun readLocalProperties(resourcePath: String){
        properties = mutableMapOf()
        propertyFileName = resourcePath.split("/").last()

        try {
            FileInputStream(resourcePath).use { input ->
                val prop = Properties()
                prop.load(input)

                prop.forEach { property ->
                    properties!![property.key.toString()] = property.value.toString()
                }
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    fun getProperty(propertyName: String): String {
        if(properties != null){
            if(properties!!.isNotEmpty()){
                val property = properties!![propertyName]
                if(property != null) return property
                else throw Exception("The property $propertyName doesn't exists")
            }
            throw Exception("The $propertyName file doesn't have any property")
        }
        throw Exception("The *.properties file was not loaded")
    }
}