package ru.nuclearreactor.forceofworlds.entities

interface subscribe<T> {
    fun action(o: T)
}