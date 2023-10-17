package database

import utils.PropertiesReader
import java.sql.Connection
import java.sql.DriverManager

object SQLiteConnection {
    private var dbDriverName = ""
    private var dbName = ""
    private var connection: Connection? = null

    init {
        PropertiesReader.readLocalProperties("./src/main/resources/db.properties")
        dbDriverName = PropertiesReader.getProperty("DRIVER_NAME")
        dbName = PropertiesReader.getProperty("DATABASE_NAME")
    }

    fun getConnection(): Connection {
        if (connection == null || connection!!.isClosed) {
            connection = DriverManager.getConnection("${dbDriverName}:${dbName}.db")
            connection!!.autoCommit = false
        }
        return connection!!
    }
}