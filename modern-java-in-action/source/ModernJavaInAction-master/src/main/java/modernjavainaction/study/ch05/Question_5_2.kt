package modernjavainaction.study.ch05

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val result1 = numbers.map { it * it }
    println(result1)

    val numbers1 = listOf(1, 2, 3)
    val numbers2 = listOf(3, 4)
    val result2 = numbers1
        .flatMap { num1 -> numbers2.map { num1 to it } }
    println(result2)

    val result3 = numbers1
        .flatMap { num1 -> numbers2.map { num1 to it } }
        .filter { (it.first + it.second) % 3 == 0 }
    println(result3)
}