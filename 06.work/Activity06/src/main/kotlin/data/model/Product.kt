package model

import java.util.Date
import java.util.UUID

data class Product(
    var code: Int?,
    var name: String?,
    var price: Double?,
    var manufacturer: String?,
    var manufacturingDate: String?,
    var expirationDate: String?,
    var description: String?,
    var updateDate: String?
) {
    constructor() : this(null,null, null, null, null, null, null, null)
}
