package ru.nuclearreactor.forceofworlds.pages

import ru.nuclearreactor.forceofworlds.entities.Href
import ru.nuclearreactor.forceofworlds.entities.Page

class Separate: Page {
    override fun getHrefs(): Array<Href> {
        return arrayOf()
    }

    override fun getText(): String {
        return ""
    }
}