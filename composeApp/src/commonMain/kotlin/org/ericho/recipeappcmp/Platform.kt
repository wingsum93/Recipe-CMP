package org.ericho.recipeappcmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform