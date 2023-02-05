package ch04

class LengthCounter {
    var counter: Int = 0
        private set
    fun addWord (word: String) {
        counter += word.length
    }
}

fun main() {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("hi!")
    println(lengthCounter.counter)
}