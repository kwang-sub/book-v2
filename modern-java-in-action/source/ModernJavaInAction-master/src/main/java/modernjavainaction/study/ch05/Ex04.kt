package modernjavainaction.study.ch05

fun main() {
    var numbers = listOf(1, 2, 3, 4)
    val reduce1 = numbers.reduce { acc, i ->
        acc * i
    }
    println(reduce1)
    val reduce2 = numbers.stream()
        .reduce(10) { t, u -> t * u }
    println(reduce2)
}