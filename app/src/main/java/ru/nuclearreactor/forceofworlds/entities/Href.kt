package ru.nuclearreactor.forceofworlds.entities

import ru.nuclearreactor.forceofworlds.pages.Pages.Companion.get

class Href {
    val label: String
    val script: () -> Page
    var enable: Boolean = true

    constructor(label: String, s: () -> Page) {
        this.label = label
        script = s
    }

    constructor(label: String, page: Page) {
        this.label = label

        script = fun(): Page = get(page)
    }
}