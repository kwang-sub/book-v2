package modernjavainaction.study.ch05

import modernjavainaction.base.chap04.Dish
import modernjavainaction.study.ch04.menu

fun main() {
    if (menu.any(Dish::isVegetarian)) {
        println("The menu is (somewhat) vegetarian friendly!!")
    }

    val find = menu.find(Dish::isVegetarian)
    println(find)
}