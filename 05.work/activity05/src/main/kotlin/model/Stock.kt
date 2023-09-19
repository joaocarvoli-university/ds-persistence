package model

import java.io.Serializable

data class Stock(
    val products: List<Product>
): Serializable {
    constructor(): this(listOf())
}
