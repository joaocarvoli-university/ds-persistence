package database

import org.sqlite.SQLiteException
import java.sql.Connection

object TablesCreator {
    fun createProductTable(connection: Connection){
        try {
            val query = """
            CREATE TABLE IF NOT EXISTS products (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                code VARCHAR(20),
                name VARCHAR(255),
                price VARCHAR(10),
                manufacturer VARCHAR(20),
                manufacturingDate DATE,
                expirationDate DATE,
                description VARCHAR(255),
                timestamp VARCHAR(20)
            )
        """.trimIndent()

            val statement = connection.prepareStatement(query)
            statement.execute()
        } catch (sql: SQLiteException){
            println(sql.message)
        }
    }
}