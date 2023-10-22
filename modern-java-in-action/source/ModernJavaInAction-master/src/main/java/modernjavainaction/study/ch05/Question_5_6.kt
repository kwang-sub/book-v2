package modernjavainaction.study.ch05

import modernjavainaction.base.chap05.Trader
import modernjavainaction.base.chap05.Transaction

val raoul = Trader("Raoul", "Cambridge")
val mario = Trader("Mario", "Milan")
val alan = Trader("Alan", "Cambridge")
val brian = Trader("Brian", "Cambridge")

val transactions = listOf(
    Transaction(brian, 2011, 300),
    Transaction(raoul, 2012, 1000),
    Transaction(raoul, 2011, 400),
    Transaction(mario, 2012, 710),
    Transaction(mario, 2012, 700),
    Transaction(alan, 2012, 950),
)

fun main() {
    val result1 = transactions.filter { it.year == 2011 }
        .sortedBy { it.value }
    val result2 = transactions.map { it.trader.city }
        .distinct()
    val result3 = transactions.filter { it.trader.city == "Cambridge" }
        .map { it.trader }
        .distinct()
        .sortedBy { it.name }

    val result4 = transactions.map { it.trader.name }
        .distinct()
        .sortedBy { it }
        .joinToString()
    val result5 = transactions.any { it.trader.city == "Milan" }
    val result6 = transactions.filter { it.trader.city == "Cambridge" }
        .map { it.value }
    val result7 = transactions.maxOfOrNull { it.value }
    val result8 = transactions.minOfOrNull { it.value }
    println(result1)
    println(result2)
    println(result3)
    println(result4)
    println(result5)
    println(result6)
    println(result7)
    println(result8)
}