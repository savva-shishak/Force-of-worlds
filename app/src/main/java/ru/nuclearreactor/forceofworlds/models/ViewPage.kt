package ru.nuclearreactor.forceofworlds.models

import ru.nuclearreactor.forceofworlds.entities.Page
import ru.nuclearreactor.forceofworlds.pages.Page1
import ru.nuclearreactor.forceofworlds.pages.Page2
import ru.nuclearreactor.forceofworlds.pages.Pages.Companion.get

class ViewPage {
    companion object {
        private var page: Page = get(Page2())
        private val subs: ArrayList<(Page) -> Unit> = ArrayList()

        private fun onUpdate() {
            for (sub in subs) {
                sub(page)
            }
        }

        fun set(newPage: Page) {
            this.page = newPage
            onUpdate()
        }

        fun sub(sub: (Page) -> Unit) {
            subs.add(sub)
            sub(page)
        }
    }
}