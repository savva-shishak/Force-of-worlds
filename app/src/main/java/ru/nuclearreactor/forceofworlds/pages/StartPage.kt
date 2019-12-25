package ru.nuclearreactor.forceofworlds.pages

import ru.nuclearreactor.forceofworlds.entities.Href
import ru.nuclearreactor.forceofworlds.entities.Href.Companion.href
import ru.nuclearreactor.forceofworlds.entities.Page

class StartPage: Page {

    var textContent = "Добро пожаловать в Кузницу миров"

    override fun getText(): String = textContent

    override fun getHrefs(): Array<Href> {
        return arrayOf(
            href("Тестовая страница 1", TestPage::class.java)
        )
    }
}