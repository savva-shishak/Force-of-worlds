package ru.nuclearreactor.forceofworlds.pages

import ru.nuclearreactor.forceofworlds.entities.Href
import ru.nuclearreactor.forceofworlds.entities.Page
import ru.nuclearreactor.forceofworlds.pages.Mixins.FoodDistributor
import ru.nuclearreactor.forceofworlds.pages.Mixins.foods.Food
import ru.nuclearreactor.forceofworlds.pages.Mixins.foods.arrayOfFoodsOptions
import ru.nuclearreactor.forceofworlds.pages.Pages.Companion.get


class Page2: Page {
    private val foodDistributor = get(FoodDistributor()) as FoodDistributor

    init {
        foodDistributor.nextHrefs = arrayOf(
            Href("Подсесть к Джеймсу и Грегори, которые о чём-то оживленно спорили", JamesAndGregory()),
            Href("Выбрать отдельный столик возле карты-плана аванпоста АИД", Separate())
        )
    }

    override fun getHrefs(): Array<Href> {
        val listOfOptionsFoodsHrefs: ArrayList<Href> = ArrayList()

        for (food in arrayOfFoodsOptions) {
            listOfOptionsFoodsHrefs.add(buildHref(food))
        }

        return listOfOptionsFoodsHrefs.toTypedArray()
    }

    override fun getText() = "Медальон колониста, висевший у меня на шее, засветился, когда я подошёл к автораздатчику. Между машиной и мной загорелась 3D графическое изображение блюд из списка доступных. К счастью там было сотни наименований, которые могли понравиться любому колонисту, вместо дюжины позиций, которые встречались в студенческих столовках до войны. Быстро продиагностировав моё физическое эмоциональное состояние - автомат предложил выбор из трёх рекомендуемых блюд: порция мороженое с вкраплениями витаминного субстракта, гидрированный бифштекс с горошком и зеленью, изогречка с искусственными рыбными и кольмарными белками. Взмахом руки я вышел в общий список из 230 позиций и бегло просмотрел другие варианты синтетической пищи.\n" +
            "- Бери что дают и не выерипенивайся - Усмехнулся Грегори - это стандарт для молодого растущего организма.\n" +
            "Я улыбнулся, закрыл основное меню, вернувшись к выбору из трёх блюд. Затем выбрал необходимую позицию и кивнул в знак подтверждения, голосом дополнив \"подтвержаю\".\n" +
            "Закозом была: ..."

    fun buildHref(food: Food): Href {
        return Href(
            food.nameOnButton,
            fun(): Page {
                foodDistributor.selectedFood = food

                return foodDistributor
            }
        )
    }
}