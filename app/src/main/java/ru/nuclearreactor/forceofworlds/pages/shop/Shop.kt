package ru.nuclearreactor.forceofworlds.pages.shop

import ru.nuclearreactor.forceofworlds.entities.Href
import ru.nuclearreactor.forceofworlds.entities.Page
import ru.nuclearreactor.forceofworlds.pages.StartPage

class Shop: Page {
    override fun getText(): String {
        return "Вы находитесь в магазине, что вам нужно?"
    }

    override fun getHrefs(): Array<Href> {
        return arrayOf(
            Href("Отдел еды", Eaths()),
            Href("Стартовая страница", StartPage())
        )
    }
}