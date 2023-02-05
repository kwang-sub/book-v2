package ch04

class UserV5 {
    val nickname: String
    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int) {
        nickname = getFacebookName(facebookAccountId)
    }
}

fun UserV5.getFacebookName(facebookAccountId: Int) : String = facebookAccountId.toString()

class UserV6 private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) = UserV6(email.substringBefore('@'))
        fun newFacebookUser(accountId: Int) = UserV6(getFacebookName(accountId))

        private fun getFacebookName(accountId: Int): String = accountId.toString()
    }
}

fun main() {
    val subscribingUser = UserV6.newSubscribingUser("kwnag@test.test")
    println(subscribingUser.nickname)
    println(UserV6.newFacebookUser(12).nickname)
}