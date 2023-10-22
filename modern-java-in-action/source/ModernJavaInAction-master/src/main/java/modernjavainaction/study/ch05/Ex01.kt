package modernjavainaction.study.ch05

import modernjavainaction.base.chap04.Dish
import modernjavainaction.study.ch04.menu
import java.util.Comparator
import java.util.stream.Collectors

fun main() {
    val vegetarianDishes = menu.stream()
        .filter(Dish::isVegetarian)
        .collect(Collectors.toList())
        .toList()
    println(vegetarianDishes)

    val numbers = listOf(1, 2, 1, 3, 3, 2, 4)
    numbers.stream()
        .filter { it % 2 == 0 }
        .distinct()
        .forEach(System.out::println)

    val slicedMenu1 = menu.stream()
        .takeWhile { it.calories < 320 }
        .collect(Collectors.toList())
    println(slicedMenu1)

    val slicedMenu2 = menu.stream()
        .sorted(Comparator.comparing(Dish::getCalories))
        .dropWhile { it.calories < 320 }
        .skip(2)
        .collect(Collectors.toList())
    println(slicedMenu2)

    val dishes = menu.stream()
        .filter { it.type == Dish.Type.MEAT }
        .limit(2)
        .collect(Collectors.toList())
    println(dishes)
}