package ch06.atom73

fun function1(): Int =
    throw Exception1(-52)

fun function2() = function1()

fun function3() = function2()

fun main() {
    function3()
}