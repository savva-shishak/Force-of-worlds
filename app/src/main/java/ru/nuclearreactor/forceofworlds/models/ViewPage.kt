package ru.nuclearreactor.forceofworlds.models

import ru.nuclearreactor.forceofworlds.entities.Page
import ru.nuclearreactor.forceofworlds.pages.StartPage

class ViewPage {
    companion object {
        private var page: Page = StartPage()
        private val subs: ArrayList<(Page) -> Unit> = ArrayList()

        private fun onUpdate() {
            for (sub in subs) {
                sub(page)
            }
        }

        public fun setPage(newPage: Page) {
            this.page = newPage
            onUpdate()
        }

        public fun sub(sub: (Page) -> Unit) {
            subs.add(sub)
            sub(page)
        }
    }
}