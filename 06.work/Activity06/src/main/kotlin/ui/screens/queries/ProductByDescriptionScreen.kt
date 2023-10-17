package ui.screens.queries

import ui.screens.Optionable

object ProductByDescriptionScreen : Optionable {
    private var closeScreen = false

    override fun showOptions(): Boolean {
        return closeScreen
    }
}