package ui.screens.queries

import ui.screens.Optionable

object ProductByCodeScreen : Optionable {
    private var closeScreen = false

    override fun showOptions(): Boolean {
        return closeScreen
    }
}