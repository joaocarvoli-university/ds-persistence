package model

import java.io.Serializable

data class Product(
  val name: String,
  val price: Double,
  val manufacturer: String,
  val manufacturingDate: String,
  val expirationDate: String
): Serializable {
  constructor() : this("", (0).toDouble(), "", "", "")
}
