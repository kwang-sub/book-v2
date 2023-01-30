package ch01

data class Person(
    val name: String,
    val age: Int? = null
)

fun main() {
    val persons = listOf(Person("kwang"), Person("sub", 23))
    val oldest = persons.maxBy { it.age ?: 0 }
    println("가장 나이많은 사람 $oldest")

    val value = "str"

    if (value is String) {
        println(value.uppercase())
    }
}
