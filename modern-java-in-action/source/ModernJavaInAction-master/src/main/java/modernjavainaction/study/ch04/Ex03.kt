package modernjavainaction.study.ch04

import java.util.stream.Collectors

fun main() {
    val names = menu.stream()
        .filter {
            println("filtering: ${it.name}")
            it.calories > 300
        }
        .map {
            println("mapping: ${it.name}")
            it.name
        }
        .limit(3)
        .collect(Collectors.toList())
    println(names)
}