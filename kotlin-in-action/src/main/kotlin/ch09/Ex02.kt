package ch09

fun main() {
    test(listOf("1", "2"))
}

fun test(list: List<*>) {
    val intList = list as? List<Int>?: throw IllegalArgumentException("예외던짐")

}