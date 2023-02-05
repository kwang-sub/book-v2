package ch04

class Client(val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode

    override fun toString(): String {
        return "Client(name= $name, postalCode=$postalCode)"
    }
}

class ClientV2(val name: String, val postalCode: Int) {
    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = ClientV2(name, postalCode)
}

fun main() {
    val cc = 'a'
    val str = "chlr"
    println(cc in str)
    val client1 = Client(name = "kwang", postalCode = 12)
    println(client1.postalCode in listOf(12, 11))
    val client2 = Client(name = "kwang", postalCode = 12)
    println(client1 == client2)

    val processed = hashSetOf(client1)
    println(processed.contains(client2))

    val kk = ClientV2("kk", 13)
    val k3 = kk.copy()
    println(kk == k3)
}