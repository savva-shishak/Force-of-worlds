package ru.nuclearreactor.forceofworlds.models

import com.badoo.reaktive.observable.Observable
import com.badoo.reaktive.observable.observableOf
import ru.nuclearreactor.forceofworlds.entities.Property
import ru.nuclearreactor.forceofworlds.models.mainheroeentities.Backpack

class MainHeroe {
    companion object {
        val health = Health()
        val money = Money()
        val backpack: Observable<Backpack> = observableOf(Backpack())
    }

    class Health: Property<Int>(100) {
        val maxValue = 100

        override fun set(value: Int) {
            if (value < 0) {
                super.set(0)

            } else if (value > maxValue) {
                super.set(maxValue)

            } else {
                super.set(value)
            }
        }

        fun plus(num: Int) {
            set(value + num)
        }
    }

    class Money: Property<Float>(100f) {
        override fun set(p: Float) {
            if (p < 0) {
                super.set(0f)

            } else {
                super.set(p)
            }
        }

        fun plus(num: Float) {
            set(value + num)
        }

        fun minus(num: Float) {
            set(value - num)
        }
    }
}