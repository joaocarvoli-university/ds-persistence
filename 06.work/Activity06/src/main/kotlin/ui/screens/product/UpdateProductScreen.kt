package ui.screens.product

import ui.screens.Optionable

object UpdateProductScreen : Optionable {
    private var closeScreen = false

    override fun showOptions(): Boolean {
        return closeScreen
    }
}