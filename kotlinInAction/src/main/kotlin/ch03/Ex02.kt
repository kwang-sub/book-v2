package ch03

const val CONST_TEST = "Test"

fun main() {
    val list = listOf("1", "23", "4")
    println(joinToString(list, separator = ", ", postfix = "!", prefix = ""))
    println(joinToString(list))
//    확장함수 사용
    println(list.joinToStringV2())
    println(list.joinToStringV2(prefix = "tt "))
    println(list.join())
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

fun <T> Collection<T>.joinToStringV2(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

// String 타입외에는 호출 못한다.
fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToStringV2(separator = separator, prefix = prefix, postfix = postfix)

fun String.lastChar() : Char = this.get(this.length - 1)