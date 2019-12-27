package ru.nuclearreactor.forceofworlds.pages

import com.badoo.reaktive.observable.subscribe
import ru.nuclearreactor.forceofworlds.entities.Href
import ru.nuclearreactor.forceofworlds.entities.Page
import ru.nuclearreactor.forceofworlds.models.MainHeroe
import ru.nuclearreactor.forceofworlds.pages.shop.Shop

class ProfileGamer: Page {

    var health: Int = 0
    var maxSizeOfBackpack: Int = 0
    var freeSpaceBackpack: Int = 0

    init {
        MainHeroe.health.sub {
            health = it
        }

        MainHeroe.backpack.subscribe(
            onNext = {
                maxSizeOfBackpack = it.maxSize
                freeSpaceBackpack = it.freeSpace()
            }
        )
    }

    override fun getText(): String =
        "Ваше здоровье: ${health} %\n" +
         state()

    override fun getHrefs(): Array<Href> {

        if (health <= 0) {
            return arrayOf(
                Href("Возродиться", fun(): ProfileGamer {
                    MainHeroe.health.set(MainHeroe.health.maxValue)
                    return this
                }),
                Href("На стартовую страницу", StartPage()))

        } else {
            val hrefOnPlusHealth = Href("Скушать кашу ( +13% здоровья)", fun(): ProfileGamer {
                MainHeroe.health.set(health + 13)
                return this
            })

            if (health == 100) {
                hrefOnPlusHealth.enable = false
            }

            return arrayOf(
                hrefOnPlusHealth,
                Href("Ударить дракона ( -18% здоровья)", fun(): ProfileGamer {
                    MainHeroe.health.set(health - 18)
                    return this
                }),
                Href("В магазин", Shop()),
                Href("На стартовую страницу", StartPage())
            )
        }
    }

    private fun state(): String {
        if (health == 0) {
            return "Вы мертвы"

        } else if(health <= 20) {
            return "Вы серьёзно раннены"

        } else if(health <= 40) {
            return "Вы сильно ранены"

        } else if(health <= 80) {
            return "У вас еть ранения"

        } else {
            return "Вы здоровы"
        }
    }
}