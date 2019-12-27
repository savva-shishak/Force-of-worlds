package ru.nuclearreactor.forceofworlds.pages

import ru.nuclearreactor.forceofworlds.entities.Page

class Pages {
    companion object {
        private val book: ArrayList<Page> = ArrayList()

        fun get(page: Page): Page {
            for (p in book) {
                if (p::class.java == page::class.java) {
                    return p
                }
            }

            book.add(page)

            return page
        }
    }
}