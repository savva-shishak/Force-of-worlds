package ru.nuclearreactor.forceofworlds.entities

interface Page {
    fun getImageUrl(): String {
        return ""
    }
    fun getText(): String
    fun getHrefs(): Array<Href>
}