package ru.nuclearreactor.forceofworlds.entities

import ru.nuclearreactor.forceofworlds.models.ViewPage
import ru.nuclearreactor.forceofworlds.pages.Pages
import ru.nuclearreactor.forceofworlds.pages.Pages.Companion.get
import ru.nuclearreactor.forceofworlds.pages.TestPage
import kotlin.reflect.KClass

class Href {
    val label: String
    val script: () -> Page
    var enable: Boolean = true

    constructor(l: String, s: () -> Page) {
        label = l
        script = s
    }

    constructor(l: String, page: Page) {
        label = l
        script = fun(): Page {
            return page
        }
    }

    companion object {
        fun <T: Page> href(l: String, clazz: Class<T>): Href {
            return Href(l, get(clazz))
        }
    }
}