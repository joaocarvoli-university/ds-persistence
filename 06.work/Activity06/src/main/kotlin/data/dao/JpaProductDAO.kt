package dao

import database.SQLiteConnection
import database.TablesCreator
import model.Product
import utils.Helpers
import java.sql.Connection

class JpaProductDAO : IGenericDAO<Product>, IProductDAO {
    private var connection : Connection = SQLiteConnection.getConnection()

    override fun save(objectT: Product) {
        val query = """
            INSERT INTO products (code, name, price, manufacturer, manufacturingDate, expirationDate, description, timestamp)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?);
        """.trimIndent()

        val statement = connection.prepareStatement(query)

        objectT.code?.let { statement.setInt(1, it) }
        statement.setString(2, objectT.name)
        objectT.price?.let { statement.setDouble(3, it) }
        statement.setString(4, objectT.manufacturer)
        statement.setString(5, objectT.manufacturingDate)
        statement.setString(6, objectT.expirationDate)
        statement.setString(7, objectT.description)
        statement.setString(8, Helpers.getCurrentTime())

        statement.execute()
        connection.commit()
    }

    override fun update(objectTId: Int, objectT: Product) {
        val query = """
            UPDATE products SET code = ?, name = ?, price = ?, manufacturer = ?, manufacturingDate = ?, expirationDate = ?, description = ?, timestamp = ?
            WHERE id = ?;
        """.trimIndent()

        val statement = connection.prepareStatement(query)
        val product = getById(objectTId)

        if(objectT.code != null) product?.code = objectT.code
        if(objectT.name != null) product?.name = objectT.name
        if(objectT.description != null) product?.description = objectT.description
        if(objectT.price != null) product?.price = objectT.price
        if(objectT.manufacturer != null) product?.manufacturer = objectT.manufacturer
        if(objectT.manufacturingDate != null) product?.manufacturingDate = objectT.manufacturingDate
        if(objectT.expirationDate != null) product?.expirationDate = objectT.expirationDate
        product?.updateDate = Helpers.getCurrentTime()

        product?.code?.let { statement.setInt(1, it) }
        statement.setString(2, product?.name)
        product?.price?.let { statement.setDouble(3, it) }
        statement.setString(4, product?.manufacturer)
        statement.setString(5, product?.manufacturingDate)
        statement.setString(6, product?.expirationDate)
        statement.setString(7, product?.description)
        statement.setString(8, product?.updateDate)
        statement.setInt(9, objectTId)

        statement.execute()
        connection.commit()
    }

    override fun delete(objectTId: Int) {
        val query = """
            DELETE FROM  products WHERE id = ?
        """.trimIndent()

        val statement = connection.prepareStatement(query)
        statement.setInt(1, objectTId)
        statement.execute()
        connection.commit()
    }

    override fun getById(objectTId: Int): Product? {
        val query = """
            SELECT * FROM products WHERE id = ?
        """.trimIndent()

        val statement = connection.prepareStatement(query)
        statement.setInt(1, objectTId)
        val resultSet = statement.executeQuery()

        var product : Product? = null
        if(resultSet.next()){
            product = Product()
            product.name = resultSet.getString("name")
            product.code = resultSet.getInt("code")
            product.price = resultSet.getDouble("price")
            product.manufacturer = resultSet.getString("manufacturer")
            product.manufacturingDate = resultSet.getString("manufacturingDate")
            product.expirationDate = resultSet.getString("expirationDate")
            product.description = resultSet.getString("description")
            product.updateDate = resultSet.getString("timestamp")
        }

        connection.commit()
        return product
    }

    override fun getAll(): List<Product> {
        val query = """
            SELECT * FROM products
        """.trimIndent()

        val statement = connection.prepareStatement(query)
        val resultSet = statement.executeQuery()
        val productsList : MutableList<Product> = mutableListOf()

        while(resultSet.next()) {
            val product = Product()
            product.name = resultSet.getString("name")
            product.code = resultSet.getInt("code")
            product.price = resultSet.getDouble("price")
            product.manufacturer = resultSet.getString("manufacturer")
            product.manufacturingDate = resultSet.getString("manufacturingDate")
            product.expirationDate = resultSet.getString("expirationDate")
            product.description = resultSet.getString("description")
            product.updateDate = resultSet.getString("timestamp")

            productsList.add(product)
        }

        connection.commit()
        return productsList
    }

    override fun getByProductCode(productCode: Int): Product? {
        val query = """
            SELECT * FROM products WHERE code = ?
        """.trimIndent()

        val statement = connection.prepareStatement(query)
        statement.setInt(1, productCode)
        val resultSet = statement.executeQuery()

        var product : Product? = null
        if(resultSet.next()){
            product = Product()
            product.name = resultSet.getString("name")
            product.code = resultSet.getInt("code")
            product.price = resultSet.getDouble("price")
            product.manufacturer = resultSet.getString("manufacturer")
            product.manufacturingDate = resultSet.getString("manufacturingDate")
            product.expirationDate = resultSet.getString("expirationDate")
            product.description = resultSet.getString("description")
            product.updateDate = resultSet.getString("timestamp")
        }

        connection.commit()
        return product
    }

    override fun getByProductDesc(description: String): List<Product> {
        val query = """
            SELECT * FROM products WHERE description LIKE ?
        """.trimIndent()

        val statement = connection.prepareStatement(query)
        statement.setString(1, "%${description}%")

        val resultSet = statement.executeQuery()
        val productsList : MutableList<Product> = mutableListOf()

        while(resultSet.next()) {
            val product = Product()
            product.name = resultSet.getString("name")
            product.code = resultSet.getInt("code")
            product.price = resultSet.getDouble("price")
            product.manufacturer = resultSet.getString("manufacturer")
            product.manufacturingDate = resultSet.getString("manufacturingDate")
            product.expirationDate = resultSet.getString("expirationDate")
            product.description = resultSet.getString("description")
            product.updateDate = resultSet.getString("timestamp")

            productsList.add(product)
        }

        connection.commit()
        return productsList
    }

    override fun getByProductDateRange(startTime: String, endTime: String): List<Product> {
        val query = """
            SELECT * FROM products
            WHERE timestamp BETWEEN ? AND ?
        """.trimIndent()

        val statement = connection.prepareStatement(query)
        statement.setString(1, startTime)
        statement.setString(2, endTime)

        val resultSet = statement.executeQuery()
        val productsList : MutableList<Product> = mutableListOf()

        while(resultSet.next()) {
            println("oi")
            val product = Product()
            product.name = resultSet.getString("name")
            product.code = resultSet.getInt("code")
            product.price = resultSet.getDouble("price")
            product.manufacturer = resultSet.getString("manufacturer")
            product.manufacturingDate = resultSet.getString("manufacturingDate")
            product.expirationDate = resultSet.getString("expirationDate")
            product.description = resultSet.getString("description")
            product.updateDate = resultSet.getString("timestamp")

            productsList.add(product)
        }

        connection.commit()
        return productsList
    }
}