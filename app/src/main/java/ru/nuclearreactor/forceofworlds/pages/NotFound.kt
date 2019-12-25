package ru.nuclearreactor.forceofworlds.pages

import ru.nuclearreactor.forceofworlds.entities.Href
import ru.nuclearreactor.forceofworlds.entities.Page

class NotFound: Page {
    override fun getText(): String = "Страница не найденна"

    override fun getHrefs(): Array<Href> = arrayOf()
}