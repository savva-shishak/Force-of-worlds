package ru.nuclearreactor.forceofworlds.pages

import ru.nuclearreactor.forceofworlds.entities.Page
import kotlin.reflect.KClass

class Pages {
    companion object {
        private val pages: Array<Page> = arrayOf(
            StartPage(),
            TestPage()
        )

        fun <T: Page> get(clazz: Class<T>): T {
            for (page in pages) {
                if (page::class.java == clazz) {
                    return page as T
                }
            }

            return NotFound() as T
        }
    }
}