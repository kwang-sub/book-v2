package ch02

import ch03.*

fun main() {
//    println("Hello, world!")
//    println(max(1, 2))
    println(CONST_TEST)
    println("test")
    println(joinToString(listOf(1,2,3)))

}


fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun max2(a: Int, b: Int): Int = if (a > b) a else b
fun max3(a: Int, b: Int) = if (a > b) a else b


fun canPerformOperation(): Boolean = true

fun test() {
    val question = "삶, 우주, 그리고 모든 것에 대한 궁극적인 질문"
    val answer = 42
    val answer2: Int = 42

    val message = if (canPerformOperation()) "Success" else "Failed"

    val languages = arrayListOf("Java")
    languages.add("Kotlin")

    var answer3 = 42
//    answer3 = "error"
}

fun print(param: String) {
    println("hello, ${param}한글테스트")
}