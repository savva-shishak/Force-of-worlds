package ru.nuclearreactor.forceofworlds.pages

import ru.nuclearreactor.forceofworlds.entities.Href
import ru.nuclearreactor.forceofworlds.entities.Page
import ru.nuclearreactor.forceofworlds.pages.Pages.Companion.get

class TestPage: Page {

    override fun getText(): String = "Тестовая страница"

    override fun getHrefs(): Array<Href> {
        return arrayOf(
            Href("Стартовая страница", fun(): StartPage {
                val startPage = get(StartPage::class.java)
                startPage.textContent = "Вы только что были на тестовой странице"
                return startPage
            })
        )
    }
}