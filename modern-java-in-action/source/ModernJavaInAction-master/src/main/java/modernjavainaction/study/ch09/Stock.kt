package modernjavainaction.study.ch09

data class Stock(
    var symbol: String,
    var markey: String,
)

data class Trade(
    var stock: Stock,
    var quantity: Int,
    var price: Double,
    var type: Type,
) {
    enum class Type { BUY, SELL }

    val value = quantity * price
}

data class Order(
    var customer: String,
) {
    private val trades: MutableList<Trade> = mutableListOf()
    fun addTrade(trade: Trade) {
        trades.add(trade)
    }

    fun getValue(): Double {
        return trades.sumOf { it.value }
    }

}
