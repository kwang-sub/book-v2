package ch04

fun main() {
    val user = User("íě")
    println(user.isSubscribed)

    val user1 = User("ęłě", false)
    println(user1.isSubscribed)
}