package ru.nuclearreactor.forceofworlds.pages

import ru.nuclearreactor.forceofworlds.entities.Href
import ru.nuclearreactor.forceofworlds.entities.Page

class JamesAndGregory: Page {
    override fun getHrefs() = arrayOf(
        Href("", this)
    )

    override fun getText() = ""
}