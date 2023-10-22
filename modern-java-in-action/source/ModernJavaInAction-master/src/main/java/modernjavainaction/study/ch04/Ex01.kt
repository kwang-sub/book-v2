package modernjavainaction.study.ch04

import modernjavainaction.base.chap04.Dish

val menu = listOf(
    Dish("season", true, 120,Dish.Type.OTHER),
    Dish("pork", false, 800,Dish.Type.FISH),
    Dish("beef", false, 700,Dish.Type.OTHER),
    Dish("chicken", false, 400,Dish.Type.MEAT),
    Dish("french fries", true, 530,Dish.Type.OTHER),
    Dish("rice", true, 350,Dish.Type.OTHER),
    Dish("pizza", true, 550,Dish.Type.OTHER),
    Dish("prawns", false, 300,Dish.Type.OTHER),
    Dish("salmon", false, 450,Dish.Type.OTHER),
)
fun main() {

    val lowCaloricDishesName = menu.filter { it.calories < 400 }
        .sortedBy(Dish::getCalories)
        .map { it.name }

    println(lowCaloricDishesName)
    val threeHighCaloricDishNames = menu.filter { it.calories > 300 }
        .map(Dish::getName)
        .take(3)
    println(threeHighCaloricDishNames)
}