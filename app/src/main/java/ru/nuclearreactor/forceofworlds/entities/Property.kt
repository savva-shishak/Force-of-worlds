package ru.nuclearreactor.forceofworlds.entities

open class Property<T>(var value: T) {
    private val subs: ArrayList<(v: T) -> Unit> = ArrayList()

    fun sub(sub: (v: T) -> Unit) {
        sub(value)
        subs.add(sub)
    }

    open fun set(p: T) {
        value = p
        update()
    }

    protected fun update() {
        for (sub in subs) {
            sub(value)
        }
    }
}