package ch02

import geometry.shapes.createRandomRectangle

fun main() {
    val person  = Person("Bob", true)
    println(person.name)
    println(person.isMarried)

    val rectangle = createRandomRectangle()
    println(rectangle.isSquare)

    println(Color.INDIGO.rgb())
    println(getMnemonic(Color.VIOLET))
}