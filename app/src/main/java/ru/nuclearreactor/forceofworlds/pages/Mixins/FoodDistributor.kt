package ru.nuclearreactor.forceofworlds.pages.Mixins

import ru.nuclearreactor.forceofworlds.entities.Href
import ru.nuclearreactor.forceofworlds.entities.Page
import ru.nuclearreactor.forceofworlds.pages.Mixins.foods.Food

class FoodDistributor: Page {

    var selectedFood: Food = Food("", "")

    var nextHrefs: Array<Href> = arrayOf(
        Href("Подсесть к Джеймсу и Грегори, которые о чём-то оживленно спорили", this)
    )

    override fun getHrefs(): Array<Href> = nextHrefs

    override fun getText() = "Автомат затрещал, что-то внутри заскрежелало, заморгали лампочки на корпусе и по итогу, пол минуты спустя, " +
            "он открыл нижнюю створку из которой левитируя на магнитной подвеске, " +
            "медленно пролетела по барной стойке в мою сторону " + selectedFood.textAtContent
}