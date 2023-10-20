package modernjavainaction.study.ch04

import modernjavainaction.base.chap04.Dish

fun main() {
    val dishes = listOf(
        Dish("a", false, 100,Dish.Type.FISH),
        Dish("b", true, 200,Dish.Type.OTHER),
        Dish("c", false, 300,Dish.Type.MEAT),
        Dish("d", true, 400,Dish.Type.OTHER),
    )

    val lowCaloricDishesName = dishes.filter { it.calories < 400 }
        .sortedBy(Dish::getCalories)
        .map { it.name }

    println(lowCaloricDishesName)
}