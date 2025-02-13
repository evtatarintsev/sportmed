package ru.athletictools

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform