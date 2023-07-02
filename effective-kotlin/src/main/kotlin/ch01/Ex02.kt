package ch01

fun main() {
    val a = 10
//    a = 20

    val list = mutableListOf(1, 2, 3)
    list.add(4)
    println(list)
    println()

    println(fullName)
    name = "Change"
    println(fullName)
    println()

    println(fizz)
    println(fizz)
    println(buzz)
    println(buzz)
}

var name: String = "Marcin"
var surname: String = "Moskala"

val fullName: String
    get() = "$name $surname"

fun calculate(): Int {
    println("Calculating...")
    return 42
}

val fizz = calculate()
val buzz
    get() = calculate()
