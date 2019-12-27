package ru.nuclearreactor.forceofworlds.entities

interface Subject {
    val name: String
    fun use(): Unit
    var num: Int
}