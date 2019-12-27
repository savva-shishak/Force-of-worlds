package ru.nuclearreactor.forceofworlds.pages.shop

import ru.nuclearreactor.forceofworlds.entities.Subject


class Product(override val name: String, val script: () -> Unit): Subject {

    override fun use() {
        script()
    }

    override var num: Int = 0
}