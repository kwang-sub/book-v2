package ch03

const val CONST_TEST = "Test"

fun main() {
    val list = listOf(1, 23, 4)
    println(joinToString(list, separator = ", ", postfix = "!", prefix = ""))
    println(joinToString(list))
    println("sdd".lastChar())
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun String.lastChar() : Char = this.get(this.length - 1)