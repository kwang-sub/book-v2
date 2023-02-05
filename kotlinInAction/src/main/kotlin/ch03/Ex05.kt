package ch03

/*fun main() {
    val strings: List<String> = listOf("first", "second", "fourteenth")
    println(strings.last())
}*/


fun main(args: Array<String>) {
    val test = arrayOf("1", "2", "3")
    val list = listOf("0", *test)
    println(list)

    var map = mapOf(1 to "one", 2 to "two")
    println(map)

    val pair = 1 to "test"
    println(pair.javaClass)
    println(pair)

    println("test" plus " sum")
}

infix fun String.plus(str: String) : String = this + str
