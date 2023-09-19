import deserializers.JSONDeserializerObject
import deserializers.SerializerObject
import serializers.DeserializerObject
import model.Product
import model.Stock
import deserializers.XMLDeserializerObject
import serializers.JSONSerializerObject
import serializers.XMLSerializerObject

fun main(){
    val product = Product("Bombril", 3.20, "Bombril", "", "")
    val product02 = Product("Esponja", 1.10, "Bombril", "", "")

    val stock = Stock(listOf(product, product02))

    firstPart(stock)
    secondPart(stock)
    thirdPart(stock)
}

private fun <T: Any> firstPart(objectT: T) {
    println("------------------ FIRST, SECOND AND THIRD QUESTIONS ------------------")
    val serializerGeneric = SerializerObject<T>()
    val deserializerGeneric = DeserializerObject<T>()

    serializerGeneric.addObject(objectT)
    serializerGeneric.serialize("generic_file.data")

    println(deserializerGeneric.deserialize("generic_file.data"))
}

private inline fun <reified T: Any> secondPart(objectT: T) {
    println("\n------------------ FOURTH, FIFTH QUESTIONS ------------------")
    val xmlSerializerObject = XMLSerializerObject<T>()
    val xmlDeserializerObject = XMLDeserializerObject(T::class.java)

    xmlSerializerObject.addObject(objectT)
    xmlSerializerObject.serialize("xml_file.xml")

    println(xmlDeserializerObject.deserialize("xml_file.xml"))
}

private inline fun <reified T: Any> thirdPart(objectT: T) {
    println("\n------------------ SIXTH, SEVENTH QUESTIONS ------------------")
    val jsonSerializerObject = JSONSerializerObject<T>()
    val jsonDeserializerObject = JSONDeserializerObject(T::class.java)

    jsonSerializerObject.addObject(objectT)
    jsonSerializerObject.serialize("json_file.json")

    println(jsonDeserializerObject.deserialize("json_file.json"))
}