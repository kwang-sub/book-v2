package modernjavainaction.study.ch04

import modernjavainaction.base.chap04.Dish

fun main() {
    val highCaloricDishes = menu.filter { it.calories > 300 }
        .map(Dish::getName)
}