package ru.nuclearreactor.forceofworlds.pages.shop

import ru.nuclearreactor.forceofworlds.entities.Href
import ru.nuclearreactor.forceofworlds.entities.Page
import ru.nuclearreactor.forceofworlds.models.MainHeroe

class Eaths: Page {

    var health: Int = 0
    var money: Float = 0f

    init {
        MainHeroe.health.sub {
            health = it
        }

        MainHeroe.money.sub {
            money = it
        }
    }

    override fun getText() = "Перед вами находится огромный прилавок с продуктами\n" +
            "У вас ${health}% здоровья и ${money} руб"

    override fun getHrefs(): Array<Href> =
        arrayOf(
            getHrefAtProduct("Молоко", +25, 36f),
            getHrefAtProduct("Хлеб", +10, 10f),
            getHrefAtProduct("Яйца", +15, 23f),
            Href("Вернуться хол", Shop())
        )

    private fun getHrefAtProduct(label: String, health: Int, price: Float): Href {
        val href = Href(
            buildLabel(label, health, price),
            buildScript(health, price))

        if (!isCanBuyAtPrice(price)) {
            href.enable = false
        }

        return href
    }

    private fun buildLabel(label: String, health: Int, price: Float): String {
        return "${label} (+${health}% зд; - ${price} руб.)"
    }

    private fun buildScript(health: Int, price: Float): () -> Page {
        return fun(): Page {
            MainHeroe.health.set(this.health + health)
            MainHeroe.money.set(this.money - price)
            return this
        }
    }

    private fun isCanBuyAtPrice(price: Float): Boolean {
        return money >= price
    }

}