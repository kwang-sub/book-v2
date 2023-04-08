package ch08

fun main() {
    val sum1: (Int, Int) -> Int = { x, y -> x + y }
    val sum2 = { x: Int, y: Int -> x + y }

    val action = { println(42) }

    val action2: () -> Unit = { println(42) }

    var canReturnNull: (Int, Int) -> Int? = { x, y -> if (x + y >= 10) x + y else null }

    var funOrNull: ((Int, Int) -> Int)? = null
    funOrNull = { x, y -> x / y }


}