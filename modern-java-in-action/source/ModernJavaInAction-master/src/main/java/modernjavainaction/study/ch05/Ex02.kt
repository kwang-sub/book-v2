package modernjavainaction.study.ch05

fun main() {
    val strings = listOf("Hello", "World")
    val word = strings
        .flatMap { it.split("") }
        .distinct()
    println(word)
}