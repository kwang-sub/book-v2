package ex00

fun main() {

    solution1(arrayOf(1, 2, 3))
}

fun solution1(common: Array<Int>): Int {
    var answer: Int = 0
    val size = common.size
    val i = common[size - 1] - common[size - 2]

    return answer
}