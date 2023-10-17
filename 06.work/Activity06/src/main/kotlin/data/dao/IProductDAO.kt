package dao

import model.Product

interface IProductDAO {
    fun getByProductCode(productCode: Int): Product?
    fun getByProductDesc(description: String): List<Product>
    fun getByProductDateRange(startTime: String, endTime: String): List<Product>

}