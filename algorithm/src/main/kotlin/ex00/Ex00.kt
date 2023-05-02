package ex00

fun main() {
    val array = arrayOf("aya", "ye", "woo", "m a")
    solution(array)
}

fun solution(babbling: Array<String>): Int {
    val reg = "aya|ye|woo|ma".toRegex()
    return babbling
        .map { it.replace(reg, "") }
        .count { it.isEmpty() }
}