package modernjavainaction.study.ch03

import java.util.function.Predicate

fun main() {
    val nonBlankStringPredicate: (String) -> Boolean = { s -> s.isNotBlank() }
    val result = filter(listOf(" ", "test"), nonBlankStringPredicate)
    println(result)
}

fun <T> filter(target: List<T>, p: Predicate<T>): List<T> {
    val result = mutableListOf<T>()
    for (item in target) {
        if (p.test(item)) result.add(item)
    }
    return result
}