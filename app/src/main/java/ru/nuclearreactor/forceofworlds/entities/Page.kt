package ru.nuclearreactor.forceofworlds.entities

interface Page {
    fun getImageUrl(): String {
        return ""
    }
    fun getHrefs(): Array<Href>
    fun getText(): String
}