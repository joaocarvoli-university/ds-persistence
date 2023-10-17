package data.database

import database.SQLiteConnection
import database.TablesCreator

object DbManager {
    fun startService(){
        try {
            val dbConnection = SQLiteConnection.getConnection()
            TablesCreator.createProductTable(dbConnection)
        } catch (ex: Exception){
            println("The database was not started successfully!")
        }
    }
}