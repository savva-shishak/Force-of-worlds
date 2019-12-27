package ru.nuclearreactor.forceofworlds.pages

import ru.nuclearreactor.forceofworlds.entities.Href
import ru.nuclearreactor.forceofworlds.entities.Page
import ru.nuclearreactor.forceofworlds.pages.shop.Shop

class StartPage: Page {

    var count = 0

    override fun getText(): String {
        return "Добро пожаловать в Кузницу миров \n" +
                "Счётчик: ${count++}"
    }

    override fun getHrefs(): Array<Href> {
        return arrayOf(
            Href("Ваш профиль", ProfileGamer()),
            Href("Магазин", Shop())
        )
    }
}