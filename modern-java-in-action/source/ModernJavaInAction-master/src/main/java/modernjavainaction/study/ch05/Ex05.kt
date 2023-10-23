package modernjavainaction.study.ch05

import java.util.stream.Stream

fun main() {
    val listOf = (1..10).toList()
        .filter { it % 2 == 0 }
    println(listOf.count())

    Stream.iterate(0 to 1) { it.second to it.first + it.second }
        .limit(20)
        .map { it.first }
        .forEach(System.out::print)
}