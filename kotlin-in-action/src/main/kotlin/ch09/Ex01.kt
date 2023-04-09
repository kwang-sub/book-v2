package ch09

import com.sun.jdi.IntegerValue

fun main() {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))

    val authors = listOf("Dmitry", "Svetlana")
    val readers = mutableListOf<String>("kwang", "Dmitry")
    println(readers.filter { it !in authors })

    println(authors.penultimate)
    println(oneHalf('a'.code))

    println(max("kwang", "sub"))
}

val <T> List<T>.penultimate: T
    get() = this[size - 2]

fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

fun <T : Comparable<T>> max(first: T, second: T): T {
    return if (first > second) first else second
}