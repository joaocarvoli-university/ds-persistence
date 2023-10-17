package ui.screens.product

import ui.screens.Optionable

object ReadByIdScreen : Optionable {
    private var closeScreen = false

    override fun showOptions(): Boolean {
        return closeScreen
    }
}