package ch03

fun main() {
    val set = hashSetOf(1, 2, 3)
    val list = arrayListOf(1, 2, 3)
    val map = hashMapOf(1 to "one", 2 to "two")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    println(list.first())
    println(set.max())
}