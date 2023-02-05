package ch04

class UserV4(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value"
            """.trimIndent())
            field = value
        }
}

fun main() {
    val userV4 = UserV4("Alice")
    userV4.address = "address"
}