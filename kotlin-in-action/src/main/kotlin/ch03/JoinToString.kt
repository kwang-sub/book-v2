package ch03

import java.lang.StringBuilder

fun <T> joinToString(
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String,
): String {
    val result = StringBuilder(prefix)
    for ((index, value) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(value)
    }
    result.append(postfix)
    return result.toString()
}