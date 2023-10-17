package ui.screens.product

import ui.screens.Optionable
import utils.TextsOptions

object CRUDProductScreen : Optionable {
    private var closeScreen = false

    override fun showOptions(): Boolean {
        println("> CRUD PRODUCT MENU: Select the option for the functionality <")
        TextsOptions.crudScreenOption.forEachIndexed { index, item ->
            println("(${index + 1}) - $item")
        }
        print("> insert value: ")
        val mainScreenOptionInput : Int = readln().toInt()

        when(mainScreenOptionInput){
            1 -> CreateProductScreen.showOptions()
            2 -> UpdateProductScreen.showOptions()
            3 -> ReadByIdScreen.showOptions()
            4 -> ReadAllScreen.showOptions()
            5 -> DeleteProductScreen.showOptions()
            6 -> closeScreen = true
        }

        return closeScreen
    }
}