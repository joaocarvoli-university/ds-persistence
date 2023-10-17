import dao.JpaProductDAO
import data.database.DbManager
import database.SQLiteConnection
import database.TablesCreator
import ui.MainScreen

object Application {
    fun runApp(args: Array<String>){
        println("------------- Starting application -------------")
        DbManager.startService()

        while(true){
            if(MainScreen.showOptions()){
                break
            }
        }
        println("------------- Closing application -------------")
    }
}