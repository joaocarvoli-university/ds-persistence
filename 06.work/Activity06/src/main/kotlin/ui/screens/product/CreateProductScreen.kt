package ui.screens.product

import ui.screens.Optionable

object CreateProductScreen : Optionable {
    private var closeScreen = false

    override fun showOptions(): Boolean {
        return closeScreen
    }
}