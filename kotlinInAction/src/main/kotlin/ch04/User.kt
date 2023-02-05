package ch04

import javax.naming.Context
import javax.swing.text.AttributeSet

data class User (
    val nickname: String,
    val isSubscribed: Boolean = true
)

open class UserV2(val nickname: String) {}
data class TwitterUser(val age: String) : UserV2(nickname = "test"){}

open class ViewV2 {
    constructor(ctx: Context) {}
    constructor(ctx: Context, attr: AttributeSet) {}
}

class MyButton : ViewV2 {
    constructor(ctx: Context) : super (ctx) {}
    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {}
}

fun main() {
    val hyun = User("현석")
    println(hyun)

    val kwang = TwitterUser("string")
    println(kwang)
    println(kwang.nickname)
}