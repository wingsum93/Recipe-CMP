package org.ericho.recipeappcmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.ericho.recipeappcmp.di.initKoinJvm

val koin = initKoinJvm()

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "RecipeApp-CMP",
    ) {
        App()
    }
}