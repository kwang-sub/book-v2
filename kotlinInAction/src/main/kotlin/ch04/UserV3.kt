package ch04

interface UserV3 {
    val nickname: String
}

class PrivateUser(override val nickname: String) : UserV3
class SubscribingUser(val email: String) : UserV3 {
    override val nickname: String
        get() = email.substringBefore('@')
}
/*
class FacebookUser(val accountId: Int) : UserV3 {
    override val nickname = getFacebookName(accountId)
}
*/

fun main() {
    println(PrivateUser("test@kotlinlang.org").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)
}



