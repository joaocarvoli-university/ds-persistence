package ui

import ui.screens.product.CRUDProductScreen
import ui.screens.queries.SpecificProductQueries
import utils.TextsOptions

object MainScreen {
    private var closeScreen = false

    fun showOptions(): Boolean {
        println("> MAIN MENU: Select the option for the functionality <")
        TextsOptions.mainScreenOptions.forEachIndexed { index, item ->
            println("(${index + 1}) - $item")
        }
        print("> insert value: ")
        val mainScreenOptionInput : Int = readln().toInt()

        when(mainScreenOptionInput){
            1 -> while (true) if(CRUDProductScreen.showOptions()) break
            2 -> while (true) if(SpecificProductQueries.showOptions()) break
            3 -> closeScreen = true
        }

        return closeScreen
    }
}