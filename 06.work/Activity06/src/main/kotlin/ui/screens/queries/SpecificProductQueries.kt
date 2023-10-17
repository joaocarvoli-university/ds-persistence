package ui.screens.queries

import ui.screens.Optionable
import utils.TextsOptions

object SpecificProductQueries : Optionable {
    private var closeScreen = false

    override fun showOptions(): Boolean {
        println("> SPECIFIC QUERIES MENU: Select the option for the functionality <")
        TextsOptions.specificQueries.forEachIndexed { index, item ->
            println("(${index + 1}) - $item")
        }
        print("> insert value: ")
        val mainScreenOptionInput : Int = readln().toInt()

        when(mainScreenOptionInput){
            1 -> ProductByCodeScreen.showOptions()
            2 -> ProductByDescriptionScreen.showOptions()
            3 -> ProductByTimestampRangeScreen.showOptions()
            4 -> closeScreen = true
        }

        return closeScreen
    }
}